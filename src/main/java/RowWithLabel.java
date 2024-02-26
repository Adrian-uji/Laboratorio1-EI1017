import java.util.List;

public class RowWithLabel extends Row{
    //Elementos
    private List<Double> data;
    private int numberClass;
    //Constructores
    public RowWithLabel(){
        data = null; numberClass = -1;
    }
    public RowWithLabel(List<Double> d, int n){
        data = d;
        numberClass = n;
    }
    //Métodos
    public int getNumberCLass(){
        return numberClass;
    }
}
