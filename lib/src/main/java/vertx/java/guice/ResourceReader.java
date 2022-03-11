package vertx.java.guice;

import java.io.InputStream;

public class ResourceReader {

    public InputStream createInputStreamFromResourceFilePath(String resourceFilePath){
        return this.getClass().getResourceAsStream(resourceFilePath);
    }
}
