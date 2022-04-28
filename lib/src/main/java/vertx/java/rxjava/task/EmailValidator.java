package vertx.java.rxjava.task;

import com.google.inject.Inject;
import io.reactivex.Completable;

public class EmailValidator {

    private final String emailPattern;



    @Inject
    public EmailValidator(String emailPattern) {
        this.emailPattern = emailPattern;
    }



    public Completable validate(String email) {
        if (email.matches(this.emailPattern)) {
            return Completable.complete();

        } else {
            return Completable.error(new ValidationException("The given email address is invalid"));
        }
    }
}
