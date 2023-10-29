import Bigdata.matrixmultiplication.matrix.*;
import Bigdata.matrixmultiplication.matrixbuilder.*;
import Bigdata.matrixmultiplication.operation.*;
import Bigdata.matrixmultiplication.reader.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public void controller() throws IOException {
        ReaderFile readerFile = new ReaderFile("./mc2depi/mc2depi.mtx");
        BufferedReader br = readerFile.getBufferedReader();
        List<Coordinate> matrix = CoordinateBuilder.createMatrix(br);
        String size = CoordinateBuilder.getSize();
        ArrayList columspointer = CompressedColumMatrixBuilder.getColumPointer(matrix, size);
        ArrayList rowspointer = CompressedRowMatrixBuilder.getRowPointer(matrix, size);
        long startTime = System.currentTimeMillis();
        List<Coordinate> multiplication = MatrixMultiplication.multiplyMatrices(rowspointer, columspointer);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("La multiplicación de matrices tardó " + elapsedTime + " milisegundos.");
    }
}
