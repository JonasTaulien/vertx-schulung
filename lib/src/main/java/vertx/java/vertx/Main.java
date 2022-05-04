package vertx.java.vertx;

import io.vertx.core.DeploymentOptions;
import io.vertx.core.VertxOptions;
import io.vertx.reactivex.core.Vertx;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);



    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx(
                new VertxOptions().setEventLoopPoolSize(16)
                                  .setMaxEventLoopExecuteTime(1).setMaxEventLoopExecuteTimeUnit(TimeUnit.SECONDS)
                                  .setMaxWorkerExecuteTime(4).setMaxWorkerExecuteTimeUnit(TimeUnit.SECONDS)
                                  .setWorkerPoolSize(50)
        );

        vertx.rxDeployVerticle(
                     () -> new HttpServerVerticle(vertx),
                     new DeploymentOptions().setInstances(1)
             )
             .subscribe(
                     did -> log.info("Successfully deployed 1 instances of HttpServerVerticle"),
                     err -> log.error("Failed to deploy verticle", err)
             );
    }
}
