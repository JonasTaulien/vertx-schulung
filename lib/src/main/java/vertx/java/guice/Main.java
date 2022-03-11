package vertx.java.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        StatisticCalculator statisticCalculator = injector.getInstance(StatisticCalculator.class);

        System.out.println(
                "sum of file: " +
                statisticCalculator.sumLines("/numbers.txt")
        );
    }
}
