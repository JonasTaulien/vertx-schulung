package vertx.java.rxjava.task;

import java.util.List;
import java.util.Objects;

public class Message {


    private final int sendByUserId;
    private final List<MessageAttachment> attachments;



    public Message(int sendByUserId, List<MessageAttachment> attachments) {
        this.sendByUserId = sendByUserId;
        this.attachments = attachments;
    }



    public boolean wasSendBy(int userId) {
        return this.sendByUserId == userId;
    }



    public List<MessageAttachment> getAttachments() {
        return attachments;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Message message = (Message) o;
        return sendByUserId == message.sendByUserId && Objects.equals(attachments, message.attachments);
    }



    @Override
    public int hashCode() {
        return Objects.hash(sendByUserId, attachments);
    }



    @Override public String toString() {
        return "Message{" +
               "sendByUserId=" + sendByUserId +
               ", attachments=" + attachments +
               '}';
    }
}
