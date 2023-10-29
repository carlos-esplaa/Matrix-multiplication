package Bigdata.matrixmultiplication.reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderFile extends Reader {
    private BufferedReader br;

    public ReaderFile(String filePath) {
        try {
            br = new BufferedReader(new FileReader(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedReader getBufferedReader() {
        return br;
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    @Override
    public void close() throws IOException {
        if (br != null) {
            br.close();
        }
    }
}
