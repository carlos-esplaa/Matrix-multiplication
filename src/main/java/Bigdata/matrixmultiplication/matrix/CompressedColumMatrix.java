package Bigdata.matrixmultiplication.matrix;
import java.util.List;
public class CompressedColumMatrix {
    public List<Integer> columPointer;
    public List<Integer> rows;
    public List<Double> columsValue;
    public int matrixColumSize;

    public CompressedColumMatrix(List<Integer> columPointer, List<Integer> rows, List<Double> columsValue, int matrixColumSize) {
        this.columPointer = columPointer;
        this.rows = rows;
        this.columsValue = columsValue;
        this.matrixColumSize = matrixColumSize;
    }



}
