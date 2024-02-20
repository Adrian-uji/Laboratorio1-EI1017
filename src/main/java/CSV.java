import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class CSV { //Class es la etiqueta
    public Table readTable(String document) throws IOException { //En lugar de "static void" va Table
        File archivo = new File(document);
        if (archivo.exists()){
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int i = 0;
            List<String> headers = new LinkedList<String>();
            List<Row> rows = new ArrayList();
            while((linea = br.readLine()) != null){
                if (i<1){
                    headers = readHeaders(linea);
                }
                boolean haveClass = headers.contains("class");
                else{
                    rows.add(readRows(linea, haveClass, headers.size());
                }
                i++;
            }
            Table table = new Table(headers,rows);
            return table;
        }
        else{
            throw new FileNotFoundException();
        }
    }
    public List<String> readHeaders(String linea) {
        List<String> header = new ArrayList<>();
        String words = "";
        for (int i = 0; i < linea.length(); i++) {
            char caracter = linea.charAt(1);
            if (caracter != ',') {
                words = words + caracter;
            } else {
                header.add(words);
                words = "";
            }
        }
        return header;
    }
    public Row readRows(String linea, boolean hc, int numColumns){
        /*Esto ta' mal, lo tengo que cambiar*/
        List<Double> rowList = new LinkedList<>();
        String numberString = "";
        for (int i = 0; i < linea.length(); i++) {
            if (hc){
                char caracter = linea.charAt(1);
                if (caracter != ',') {
                    numberString = numberString + caracter;
                } else {
                    rowList.add(Double.parseDouble(numberString));
                    numberString = "";
                    numColumns--;
                }
            }
        }

    }
}
