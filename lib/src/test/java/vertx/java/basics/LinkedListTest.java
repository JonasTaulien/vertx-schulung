package vertx.java.basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void isEmptyAfterCreation(){
        LinkedList liste = LinkedList.empty();

        assertTrue(liste.isEmpty());
    }

    @Test
    void isImmutableAfterAppend(){
        LinkedList liste = LinkedList.empty();
        liste.append(1);

        assertTrue(liste.isEmpty());
    }

    @Test
    void isEmptyAfterAppendingElement(){
        LinkedList liste = LinkedList.empty().append(1);

        assertFalse(liste.isEmpty());
    }
}
