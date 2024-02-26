import java.util.HashMap;
import java.util.List;

public class Row {
    //Elementos
    private List<Double> data;

    //Constructores
    public Row(){
        data = null;
    }
    public Row( List<Double> l){
        data = l;
    }

    //Métodos
    public List<Double> getData(){
        return data;
    }
}
