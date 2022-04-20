package vertx.java.rxjava;

import io.reactivex.Observable;
import io.reactivex.Single;
import vertx.java.basics.LinkedList;

public class Main {

    public static void main(String[] args) {
        Observable.fromArray(1, 2, 3, 4, 5, 6, 7, 8, 9)
                  .map(i -> i + 1)
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
    }
}
