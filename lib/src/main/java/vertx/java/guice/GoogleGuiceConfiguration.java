package vertx.java.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

public class GoogleGuiceConfiguration extends AbstractModule {

    @Override
    protected void configure() {
        bind(SomeClass.class).in(Scopes.SINGLETON);

        bind(String.class).annotatedWith(Names.named("prefix")).toInstance("LOGGER: ");
    }
}
