import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class MyBufferReader {

    String file;

    List<String> lines = Files.readAllLines(file, Charset.forName("UTF-8"));

    public void setPath(String filePath) {
        this.file = filePath;
    }
}
