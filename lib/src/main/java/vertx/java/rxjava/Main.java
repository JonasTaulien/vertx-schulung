package vertx.java.rxjava;

import io.reactivex.Observable;

public class Main {

    public static void main(String[] args) {
        Observable.<Integer>fromPublisher(s -> {
                      for (int i = 0; i < 1; i++) {
                          s.onError(new RuntimeException("ein böser fehler"));

                          s.onNext(i);
                      }

                      s.onComplete();
                  })
                  .subscribe(
                          str -> {
                              System.out.println("String: " + str);
                          },
                          err -> {
                              System.err.println("Fehler: " + err.getMessage());
                          }
                  );
    }
}
