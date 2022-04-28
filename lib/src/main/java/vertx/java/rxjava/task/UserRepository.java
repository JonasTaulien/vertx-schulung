package vertx.java.rxjava.task;

import com.google.inject.Inject;
import io.reactivex.Single;

import java.util.Random;

public class UserRepository {

    private final Random random;



    @Inject
    public UserRepository(Random random) {
        this.random = random;
    }



    public Single<User> create(String email) {
        final int id = random.nextInt();

        return Single.just(new User(id, email));
    }
}
