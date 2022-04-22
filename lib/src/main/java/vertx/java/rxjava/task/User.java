package vertx.java.rxjava.task;

import java.util.Objects;

public class User {

    private final int id;

    private final String email;



    public User(int id, String email) {
        this.id = id;
        this.email = email;
    }



    public int getId() {
        return id;
    }



    public String getEmail() {
        return email;
    }



    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return id == user.id
               && Objects.equals(email, user.email);
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, email);
    }



    @Override public String toString() {
        return "User{" +
               "id=" + id +
               ", email='" + email + '\'' +
               '}';
    }
}
