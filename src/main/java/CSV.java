import java.io.*;
import java.util.*;


public class CSV {
    //Contador de columnas
    int cont = 0;
    //Métodos

    //Métodos read
    public Table readTable(String document) throws IOException {
        File archivo = new File(document);
        if (archivo.exists()){
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr); //Esto lee de una en una las líneas
            String linea;
            int i = 0;
            List<String> headers = new LinkedList<String>();
            List<Row> rows = new ArrayList();
            while((linea = br.readLine()) != null){
                if (i<1){
                    headers = readHeaders(linea);
                }
                else{
                    rows.add(readRows(linea));
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
    public TableWithLabels readTableWithLabels (String document) throws IOException {
        Map<String, Integer> labelsToolIndex = new HashMap<>();
        File archivo = new File(document);
        if (archivo.exists()){
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            int i = 0;
            List<String> headers = new LinkedList<String>();
            List<RowWithLabel> rows = new ArrayList();
            while((linea = br.readLine()) != null){
                if (i<1){
                    headers = readHeaders(linea);
                }
                else{
                    rows.add(readRowsWithLable(linea, labelsToolIndex));
                }
                i++;
            }

            TableWithLabels table = new TableWithLabels(headers,rows,labelsToolIndex);
            return table;
        }
        else{
            throw new FileNotFoundException();
        }
    }
    //Métodos auxiliares
    public List<String> readHeaders(String linea) {
        List<String> header = new ArrayList<>();
        String words = "";
        for (int i = 0; i < linea.length(); i++) {
            char caracter = linea.charAt(1);
            if (caracter != ',') {
                words = words + caracter;
            } else {
                if (!words.equals("class"))
                {
                    header.add(words);
                    cont++;
                }
                words = "";
            }
        }
        return header;
    }
    public Row readRows(String linea){
        Row rows = new Row();
        List<Double> rowList = new LinkedList<>();
        String numberString = "";
        for (int i = 0; i < linea.length(); i++) {
            char caracter = linea.charAt(i);
            if (caracter != ',') {
                numberString = numberString + caracter;
            } else {
                rowList.add(Double.parseDouble(numberString));
                numberString = "";
            }
        }
        rows = (Row) rowList;
        return rows;
    }
    public RowWithLabel readRowsWithLable(String linea, Map<String, Integer> labelsMap){
        int numberClass;
        List<Double> rowList = new LinkedList<>();
        String numberString = "";
        for (int i = 0; i < cont; i++) {
            char caracter = linea.charAt(i);
            if (caracter != ',') {
                numberString = numberString + caracter;
            } else {
                rowList.add(Double.parseDouble(numberString));
                numberString = "";
            }
        }
        String identifier = "";
        for (int i = cont; i<linea.length();i++){
            identifier += linea.charAt(i);
        }
        if (labelsMap.containsKey(identifier)){
            numberClass = labelsMap.get(identifier);
        }
        else{
            numberClass = labelsMap.size();
            labelsMap.put(identifier,numberClass);
        }
        RowWithLabel row = new RowWithLabel(rowList,numberClass);
        return row;
    }
}
