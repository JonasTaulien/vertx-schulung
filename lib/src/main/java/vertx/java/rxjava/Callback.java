package vertx.java.rxjava;

public interface Callback<T> {

    void execute(T value);
}
