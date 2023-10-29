package Bigdata.matrixmultiplication.matrix;
import java.util.List;

public class CompressedRowMatrix {
    public List<Integer> rowPointer;
    public List<Integer> colums;
    public java.util.List<Double> rowsValue;
    public int matrixRowSize;

    public CompressedRowMatrix(List<Integer> rowPointer, List<Integer> colums, List<Double> rowsValue, int matrixRowSize) {
        this.rowPointer = rowPointer;
        this.colums = colums;
        this.rowsValue = rowsValue;
        this.matrixRowSize = matrixRowSize;
    }


}
