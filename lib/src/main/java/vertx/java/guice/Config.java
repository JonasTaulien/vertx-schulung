package vertx.java.guice;

import com.google.inject.Inject;

import java.util.Map;

public class Config {

    private final Map<String, String> configValues;



    @Inject
    public Config(Map<String, String> configValues) {
        this.configValues = configValues;
    }



    public String getLogPrefix() {
        return this.configValues.get("LOG_PREFIX");
    }



    public String getLogPostfix() {
        return this.configValues.get("LOG_POSTFIX");
    }



    public String getNumbersResourcePath() {
        return this.configValues.get("NUMBERS_RESOURCE_PATH");
    }
}
