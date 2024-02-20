import java.util.HashMap;
import java.util.List;

public class Row {
    private HashMap<List<Double>,String> data;
    public Row(){
        data = null;
    }
    public Row( HashMap<List<Double>,String> l){
        data = l;
    }
}
