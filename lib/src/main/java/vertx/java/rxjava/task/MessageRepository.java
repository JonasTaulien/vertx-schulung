package vertx.java.rxjava.task;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class MessageRepository {

    public Observable<Message> fetchAllMessages() {
        return Observable.fromArray(
                new Message(
                        1,
                        Arrays.asList(
                                new MessageAttachment("<img>Urlaub_1.jpeg</img>"),
                                new MessageAttachment("<img>Urlaub_2.png</img>")
                        )
                ),
                new Message(1, List.of()),
                new Message(
                        1,
                        List.of(new MessageAttachment("<doc>Quartalszahlen.xslt</doc>"))
                ),
                new Message(2,List.of()),
                new Message(
                        2,
                        Arrays.asList(
                                new MessageAttachment("<img>Screenshot_20227217612.jpeg</img>"),
                                new MessageAttachment("<img>BUG.png</img>")
                        )
                )
        );
    }
}
