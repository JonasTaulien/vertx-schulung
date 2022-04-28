package vertx.java.rxjava.task;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        // TODO:
        //  - Implement UserCreationProcess::execute
        //      - Use Dependency Injection for injecting the services that are needed by the Process. Use Google Guice.
        //      - You might have to prepare the other services for usage with Google Guice.
        //  - Use the UserCreationProcess in this main
        //      - Create one user with valid email. Log the id of that user.
        //      - Create one user with invalid email (with an email address not containing '@'). Log the error message.
        //  - Implement FetchSentAttachmentsForUserProcess::execute
        //      - Also use Dependency Injection
        //  - Use the FetchSentAttachmentsForUserProcess in this main
        //      - Fetch all the attachments from user with id 1. Email address does not matter.
        //      - Log the content of each Attachment

        Injector injector = Guice.createInjector(new GoogleGuiceConfiguration());
        UserCreationProcess userCreationProcess = injector.getInstance(UserCreationProcess.class);

        userCreationProcess.execute("test@test.com")
                           .subscribe(
                                   user -> System.out.println("User erfolgreich erstellt. Id: " + user.getId()),
                                   err -> {
                                       System.err.println("Fehler bei der Erstellung des Users:");
                                       err.printStackTrace();
                                   }
                           );
    }
}
