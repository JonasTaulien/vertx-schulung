package vertx.java.guice;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;

public class SimpleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(SomeClass.class).in(Scopes.SINGLETON);
    }
}
