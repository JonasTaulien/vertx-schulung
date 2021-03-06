package vertx.java.guice;

import com.google.inject.Inject;

import java.util.List;

public class StatisticCalculator {

    private final FileReader fileReader;



    @Inject
    public StatisticCalculator(FileReader fileReader) {
        this.fileReader = fileReader;
    }



    /**
     * @param resourceFilePath e.g. "/numbers.txt"
     *
     * @return sum of all numbers in the given file. If the file is empty this returns 0.
     */
    public int sumLines(String resourceFilePath) {
        List<String> lines = this.fileReader.readLinesFromResourceFile(resourceFilePath);

        int sum = 0;
        for (String line : lines) {
            sum += Integer.parseInt(line);
        }

        return sum;
    }

}
