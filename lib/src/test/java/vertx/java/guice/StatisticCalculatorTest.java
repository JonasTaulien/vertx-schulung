package vertx.java.guice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class StatisticCalculatorTest {

    @Test
    void sumLines_correctResult(){
        FileReader fileReader = mock(FileReader.class);

        when(fileReader.readLinesFromResourceFile(any()))
                .thenReturn(Arrays.asList("1", "2", "3"));

        StatisticCalculator calc = new StatisticCalculator(fileReader);

        int actual = calc.sumLines("/someFile.txt");
        assertEquals(6, actual);
    }
}
