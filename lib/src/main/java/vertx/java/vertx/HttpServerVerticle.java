package vertx.java.vertx;

import io.reactivex.Completable;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpServerVerticle extends AbstractVerticle {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private final Vertx vertx;



    public HttpServerVerticle(Vertx vertx) {
        this.vertx = vertx;
    }



    @Override
    public Completable rxStart() {
        return Completable.fromAction(() -> log.info("HttpServerVerticle is starting..."))
                          .andThen(
                                  this.vertx
                                          .rxExecuteBlocking(
                                                  promise -> {
                                                      log.info("Sleeping");

                                                      try {
                                                          Thread.sleep(5000);
                                                      } catch (InterruptedException e) {
                                                          promise.fail(e);
                                                      }

                                                      promise.complete();
                                                  },
                                                  false
                                          )
                                          .ignoreElement()
                          )
                          .doOnComplete(() -> log.info("HttpServerVerticle started :)"))
                          .doOnError(err -> log.error("Failed to start HttpServerVerticle :("));
    }
}
