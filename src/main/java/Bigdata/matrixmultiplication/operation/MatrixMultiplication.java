package Bigdata.matrixmultiplication.operation;
import Bigdata.matrixmultiplication.matrix.*;
import Bigdata.matrixmultiplication.matrixbuilder.*;

import java.util.ArrayList;
import java.util.List;

public class MatrixMultiplication {

    public static List<Coordinate> multiplyMatrices(List<?> crsList, List<?> ccsList) {
        List<Coordinate> result = new ArrayList<>();
        for (Object crsOrInteger : crsList) {
            for (Object ccsOrInteger : ccsList) {
                for (int i = 0; i < CompressedRowMatrixBuilder.getMatrixRowSize(); i++) {
                    double sum = getSum((CompressedRowMatrix) crsOrInteger, i, (CompressedColumMatrix) ccsOrInteger);
                    if (sum != 0) {
                        result.add(new Coordinate(i, CompressedColumMatrixBuilder.getMatrixColumSize(), sum));
                    }
                }
            }
        }
        return result;
    }

    private static double getSum(CompressedRowMatrix crs, int i, CompressedColumMatrix ccs) {
        double sum = 0;
        int rowStart = crs.rowPointer.get(i);
        int rowEnd = (i == crs.matrixRowSize - 1) ? ccs.matrixColumSize : crs.rowPointer.get(i + 1);

        for (int j = rowStart; j < rowEnd; j++) {
            int col = ccs.columPointer.get(j);
            double crsValue = crs.rowsValue.get(j);
            double ccsValue = ccs.columsValue.get(j);
            sum += crsValue * ccsValue;
        }
        return sum;
    }
}
