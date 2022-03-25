package vertx.java.guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector simpleInjector = Guice.createInjector();
        StatisticCalculator statisticCalculator = simpleInjector.getInstance(StatisticCalculator.class);

        System.out.println(
                "sum of file: " +
                statisticCalculator.sumLines("/numbers.txt")
        );



        // Singleton: Instanz einer Klasse, aber die einzige, die es jemals geben wird
        // per Default gibt Google Guice IMMER eine NEUE instanz zurück (kein Singleton)
        SomeClass someA = simpleInjector.getInstance(SomeClass.class);
        SomeClass someB = simpleInjector.getInstance(SomeClass.class);

        System.out.println("New instance A: " + someA + ", B: " + someB);

        someA.value = 10;
        System.out.println("Values A: " + someA.value + ", B: " + someB.value + " Same objects:" + (someA == someB));



        // Mit module, in dem konfiguriert ist, dass SomeClass als Singleton erstellt werden soll: es wird nur eine
        // Instanz erstellt.
        Injector moduleInjector = Guice.createInjector(new GoogleGuiceConfiguration());

        SomeClass moduleA = moduleInjector.getInstance(SomeClass.class);
        SomeClass moduleB = moduleInjector.getInstance(SomeClass.class);

        System.out.println("Singleton A: " + moduleA + ", B: " + moduleB + " Same objects:" + (moduleA == moduleB));

        moduleA.value = 10;
        System.out.println("Singleton Values A: " + moduleA.value + ", B: " + moduleB.value);



        // toInstance() im Module
        PrefixLogger logger = moduleInjector.getInstance(PrefixLogger.class);
        logger.log("A message");



        // @Provides im Module
        Config config = moduleInjector.getInstance(Config.class);
        System.out.println("config instance: " + config);
        logger.log(
                "CONFIG: sum of file: " +
                statisticCalculator.sumLines(config.getNumbersResourcePath())
        );

        logger.log(
                "CONFIG: sum of file2: " +
                statisticCalculator.sumLines("/numbers2.txt")
        );
    }
}
