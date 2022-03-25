package vertx.java.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Named;

import java.util.Map;

public class GoogleGuiceConfiguration extends AbstractModule {

    @Override
    protected void configure() {
        bind(SomeClass.class).in(Scopes.SINGLETON);
        bind(Config.class).in(Scopes.SINGLETON);
    }



    @Provides
    Map<String, String> provideConfigValues() {
        System.out.println("new map creation!");

        return Map.of(
                "LOG_PREFIX", "LOGGER: ",
                "LOG_POSTFIX", " DONE!",
                "NUMBERS_RESOURCE_PATH", "/numbers.txt"
        );
    }



    @Provides
    @Named("prefix")
    String logPrefix(Config config) {
        System.out.println("logPrefix Config: " + config);
        return config.getLogPrefix();
    }



    @Provides
    @Named("postfix")
    String logPostfix(Config config) {
        System.out.println("logPostfix Config: " + config);
        return config.getLogPostfix();
    }
}
