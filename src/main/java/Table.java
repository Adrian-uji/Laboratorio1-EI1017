import java.util.HashMap;
import java.util.List;

public class Table {
    List<String> header;
     List<Row> rows;
    public Table(){
        header = null;
    }
    public Table(List<String> h, List<Row> r){
        header = h;
        rows = r;
    }
}
