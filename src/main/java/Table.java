import java.util.HashMap;
import java.util.List;

public class Table {
    //Elementos
    private List<String> header;
    private List<Row> rows;

     //Constructores
    public Table(){
        header = null;
        rows = null;
    }
    public Table(List<String> h, List<Row> r){
        header = h;
        rows = r;
    }

    //Métodos
    public Row getRowAt(int pos) throws IndexOutOfBoundsException{
        if (pos > rows.size()){
            throw new IndexOutOfBoundsException();
        }
        else{
            return rows.get(pos);
        }
    }
    public int readRows(){
        return rows.size();
    }
    public List<String> getHeader(){
        return header;
    }
    public List<Row> getRows(){
        return rows;
    }
}
