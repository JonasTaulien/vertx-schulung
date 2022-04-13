package vertx.java.rxjava;

import io.reactivex.Single;
import io.vertx.reactivex.core.Vertx;

public class AsyncFileReader {

    private final Vertx vertx;



    public AsyncFileReader(Vertx vertx) {
        this.vertx = vertx;
    }



    public void readFile(String path, Callback<String> callback, Callback<Throwable> errorCallback) {
        this.vertx.fileSystem()
                  .readFile(
                          path,
                          ar -> {
                              if (ar.succeeded()) {
                                  callback.execute(ar.result().toString());

                              } else {
                                  errorCallback.execute(new RuntimeException(
                                          "Error reading file: " + path,
                                          ar.cause()
                                  ));
                              }
                          }
                  );
    }



    public Single<String> rxReadFile(String path) {
        return this.vertx.fileSystem()
                         .rxReadFile(path)
                         .map(buf -> buf.toString());
    }
}
