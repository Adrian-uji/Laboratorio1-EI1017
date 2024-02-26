import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table{
    //Elementos
    private List<String> headers;
    private List<RowWithLabel> rows;
    private Map<String,Integer> labelsToIndex;

    //Constructores
    public TableWithLabels(){
        headers = null; rows = null; labelsToIndex = null;
    }
    public TableWithLabels(List<String> h, List<RowWithLabel> r, Map<String,Integer> l){
        headers = h;
        rows = r;
        labelsToIndex = l;
    }
    //Metodos
    @Override
    public RowWithLabel getRowAt(int pos) throws IndexOutOfBoundsException{
        if (pos > rows.size()){
            throw new IndexOutOfBoundsException();
        }
        else{
            return rows.get(pos);
        }
    }
}
