package vertx.java.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class MainOhneGuice {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();

        StatisticCalculator statisticCalculator = injector.getInstance(StatisticCalculator.class);
        ResourceReader resourceReader = injector.getInstance(ResourceReader.class);

        statisticCalculator.sumLines("/numbers.txt");
    }
}
