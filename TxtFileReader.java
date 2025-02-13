import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TxtFileReader {

    public String readFileContent(String filePathAsString) {

        Path filePath = Paths.get(filePathAsString);

        try {
            return  Files.readString(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file at path: " + filePathAsString, e);
        }
    }
}
