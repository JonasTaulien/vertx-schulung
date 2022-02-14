package vertx.java.basics;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest {

    @Test
    void isEmptyAfterCreation() {
        LinkedList<Integer> liste = LinkedList.empty();

        assertTrue(liste.isEmpty());
    }



    @Test
    void isImmutableAfterAppend() {
        LinkedList<Integer> liste = LinkedList.empty();
        liste.append(1);

        assertTrue(liste.isEmpty());
    }



    @Test
    void isNotEmptyAfterAppendingElement() {
        LinkedList<Integer> liste = LinkedList.<Integer>empty().append(1);

        assertFalse(liste.isEmpty());
    }



    @Test
    void canAppendMultipleElements() {
        LinkedList<Integer> liste = LinkedList.<Integer>empty().append(1).append(2).append(3);

        assertEquals(3, liste.count());
    }

    // TODO: Tests für get()



    @Test
    void canAppendMultipleStrings() {
        LinkedList<String> liste = LinkedList.<String>empty().append("a").append("b").append("c");

        assertEquals(3, liste.count());
    }
}
