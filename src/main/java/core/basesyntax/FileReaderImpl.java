package core.basesyntax;

import java.io.File;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String path) {
        if (path == null) {
            throw new RuntimeException("Path can`t be null!");
        }
        try {
            return Files.readAllLines(Path.of(path));
        } catch (Exception e) {
            throw new RuntimeException("Cannot read file: " + path, e);
        }
    }
}
