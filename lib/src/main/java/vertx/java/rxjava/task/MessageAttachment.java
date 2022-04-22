package vertx.java.rxjava.task;

import java.util.Objects;

public class MessageAttachment {

    private final String content;



    public MessageAttachment(String content) {
        this.content = content;
    }



    public String getContent() {
        return content;
    }



    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MessageAttachment that = (MessageAttachment) o;
        return Objects.equals(content, that.content);
    }



    @Override
    public int hashCode() {
        return Objects.hash(content);
    }



    @Override public String toString() {
        return "MessageAttachment{" +
               "content='" + content + '\'' +
               '}';
    }
}
