package vertx.java.rxjava.task;

import io.reactivex.Observable;

import javax.inject.Inject;

public class FetchSentAttachmentsForUserProcess {

    private final MessageRepository messageRepository;



    @Inject
    public FetchSentAttachmentsForUserProcess(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }



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

        return this.messageRepository.fetchAllMessages()
                                     .filter(msg -> msg.wasSendBy(user.getId()))
                                     .flatMap(msg -> Observable.fromIterable(msg.getAttachments()))
                                     .onErrorResumeNext((Throwable err) -> Observable.empty());
    }
}
