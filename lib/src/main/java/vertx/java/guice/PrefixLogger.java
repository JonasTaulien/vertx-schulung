package vertx.java.guice;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class PrefixLogger {

    private final String prefix;
    private final String postfix;



    @Inject
    public PrefixLogger(
            @Named("prefix") String prefix,
            @Named("postfix") String postfix
    ) {
        this.prefix = prefix;
        this.postfix = postfix;
    }



    public void log(String message) {
        System.out.println(this.prefix + message + this.postfix);
    }
}
