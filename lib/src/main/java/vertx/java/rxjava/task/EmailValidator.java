package vertx.java.rxjava.task;

import io.reactivex.Completable;

public class EmailValidator {

    private final String emailPattern;



    public EmailValidator(String emailPattern) {
        this.emailPattern = emailPattern;
    }



    public Completable validate(String email) {
        if (email.contains("@")) {
            return Completable.complete();

        } else {
            return Completable.error(new ValidationException("The given email address is invalid"));
        }
    }
}
