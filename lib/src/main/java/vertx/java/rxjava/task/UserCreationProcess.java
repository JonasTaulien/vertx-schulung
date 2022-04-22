package vertx.java.rxjava.task;

import io.reactivex.Single;

public class UserCreationProcess {

    /**
     * @param email the email address of the new user
     *
     * @return the created user
     */
    public Single<User> execute(String email) {
        // TODO:
        //  - Validate email using EmailValidator::validate
        //  - Store user in DB using UserRepository::create
        //  - Send welcome email to user using EmailSender::sendWelcomeMail
        //  - Return the created user.
        //      - Tip: The Completable-class has a method called `toSingleDefault()`
        return null;
    }
}
