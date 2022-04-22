package vertx.java.rxjava.task;

import io.reactivex.Observable;

public class FetchSentAttachmentsForUserProcess {


    /**
     * @param user The user fow which to return the sent Attachments.
     *
     * @return all the {@link MessageAttachment}s the given user has sent to any other user.
     */
    public Observable<MessageAttachment> execute(User user) {
        // TODO:
        //  - Fetch all Messages using MessageRepository::fetchAllMessages
        //  - Filter the Messages, so that we continue only with the messages that were send by the given user.
        //  - Return only the Attachments from the Messages
        //      - Tip: You can convert a List into an Observable by using `Observable.fromIterable`
        //  - Recover from errors by returning an empty Observable

        return null;
    }
}
