package vertx.java.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class PrefixLogger {

    private final String prefix;



    @Inject
    public PrefixLogger(@Named("prefix") String prefix) {
        this.prefix = prefix;
    }



    public void log(String message) {
        System.out.println(this.prefix + message);
    }
}
