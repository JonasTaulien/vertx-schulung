package vertx.java.guice;

import com.google.inject.Inject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    private final ResourceReader resourceReader;



    @Inject
    public FileReader(ResourceReader resourceReader) {
        this.resourceReader = resourceReader;
    }



    public List<String> readLinesFromResourceFile(String resourceFilePath) {
        InputStream is = this.resourceReader.createInputStreamFromResourceFilePath(resourceFilePath);

        if (is == null) {
            throw new RuntimeException("Resource does not exist");
        }

        Scanner scanner = new Scanner(is);

        ArrayList<String> lines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }

        return lines;
    }
}
