package vertx.java.rxjava;

import io.vertx.junit5.VertxExtension;
import io.vertx.junit5.VertxTestContext;
import io.vertx.reactivex.core.Vertx;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(VertxExtension.class)
public class AsyncFileReaderTest {

    @Test
    void readFile_readsTheGivenFile(Vertx vertx, VertxTestContext ctx) {
        final AsyncFileReader fileReader = new AsyncFileReader(vertx);

        fileReader.readFile(
                "file.txt",
                fileContent -> {
                    ctx.verify(() -> {
                        assertEquals("Ein Dateiinhalt\n", fileContent);
                        ctx.completeNow();
                    });
                },
                (Throwable err) -> ctx.failNow(err)
        );
    }



    @Test
    void rxReadFile_readsTheGivenFile(Vertx vertx, VertxTestContext ctx) {
        final AsyncFileReader fileReader = new AsyncFileReader(vertx);

        fileReader.rxReadFile("file.txt")
                  .subscribe(
                          fileContent -> ctx.verify(() -> {
                              assertEquals("Ein Dateiinhalt\n", fileContent);
                              ctx.completeNow();
                          }),

                          (Throwable err) -> ctx.failNow(err)
                  );
    }
}
