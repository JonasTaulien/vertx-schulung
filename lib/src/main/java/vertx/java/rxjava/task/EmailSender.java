package vertx.java.rxjava.task;

import io.reactivex.Completable;

public class EmailSender {

    public Completable sendWelcomeMail(User user) {
        return Completable.fromAction(() -> {
            System.out.println("Hi " + user.getEmail() + "!");
        });
    }
}
