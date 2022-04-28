package vertx.java.rxjava.task;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class GoogleGuiceConfiguration extends AbstractModule {

    @Provides
    String provideEmailAddressRegex() {
        return "^.*@.*$";
    }
}
