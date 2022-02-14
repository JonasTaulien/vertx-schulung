package vertx.java.basics;

public interface Function<A, B> {

    B apply(A element);
}
