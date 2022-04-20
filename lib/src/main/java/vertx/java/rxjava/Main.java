package vertx.java.rxjava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.vertx.reactivex.core.Vertx;

public class Main {

    public static void main(String[] args) {
        Vertx vertx = Vertx.vertx();
        vertx.createHttpServer().requestHandler(request -> {
        }).listen(1212);

        Observable.fromArray("Hallo", "Ich", "Bin", "Ein", "Observable")
                  .map(String::length)
                  .flatMap(numberOfChars -> Observable.range(0, numberOfChars))
                  .map(i -> i + 10)
                  .subscribe(
                          i -> {
                              System.out.println("Zahl: " + i);
                          },
                          err -> {
                              System.err.println("Fehler: " + err.getMessage());
                          },
                          () -> {
                              System.out.println("Completed");
                          }
                  );

        System.out.println("------------OBSERVABLE-----------------");

        Observable.<Integer>error(new RuntimeException("25362: UNIQUE CONSTRAINT VIOLATION"))
                  .doOnError(err -> System.out.println("Error: " + err.getMessage()))
                  .onErrorResumeNext((Throwable error) -> {
                      if (error.getMessage().startsWith("25362")) {
                          return Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8);

                      } else {
                          return Observable.error(error);
                      }
                  })
                  .doOnNext(next -> {
                      System.out.println("Ein neues Element: " + next);
                  })
                  .map(i -> i * 100)
                  .toList()
                  .subscribe(
                          next -> System.out.println("Response: " + next),
                          err -> System.out.println("Error: " + err.getMessage())
                  );


        System.out.println("---------------SINGLE--------------");

        Single.just("ein objekt")
              .flatMapObservable(Observable::just)
              .subscribe(
                      i -> System.out.println("Next: " + i),
                      err -> System.out.println("Error: " + err)
              );


        System.out.println("------------MAYBE-----------------");

        Maybe.empty()
             .subscribe(
                     obj -> {
                         System.out.println("Gefülltes Maybe: " + obj);
                     },
                     err -> {
                         System.out.println("Fehler: " + err);
                     },
                     () -> {
                         System.out.println("Leeres Maybe");
                     }
             );


        System.out.println("------------COMPLETABLE-----------------");

        Completable.fromAction(() -> {
                       System.out.println("ACTION!");
                   })
                   .andThen(Completable.fromAction(() -> {
                       System.out.println("NOCH EINE ACTIOn!");
                   }))
                   .subscribe(
                           () -> {
                               System.out.println("Completed!");
                           },
                           err -> {
                               System.out.println("Fehler: " + err);
                           }
                   );
    }
}
