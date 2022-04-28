package vertx.java.rxjava.task;

import com.google.inject.Inject;
import io.reactivex.Completable;
import io.reactivex.Single;

public class UserCreationProcess {

    private final EmailValidator emailValidator;

    private final UserRepository userRepository;

    private final EmailSender emailSender;



    @Inject
    public UserCreationProcess(EmailValidator emailValidator, UserRepository userRepository, EmailSender emailSender) {
        this.emailValidator = emailValidator;
        this.userRepository = userRepository;
        this.emailSender = emailSender;
    }



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

        return this.emailValidator.validate(email)
                                  .andThen(this.userRepository.create(email))
                                  .flatMap(
                                          user -> this.emailSender.sendWelcomeMail(user)
                                                                  .toSingleDefault(user)
                                  );
    }
}
