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
        LinkedList<Integer> liste = LinkedList.<Integer>empty().append(1).append(2).append(3).append(5);

        assertEquals(3, liste.count());
    }

    // TODO: Tests für get()



    @Test
    void canAppendMultipleStrings() {
        LinkedList<String> liste = LinkedList.<String>empty().append("a").append("b").append("c");

        assertEquals(3, liste.count());
    }



    @Test
    void canFilterNumbers() {
        LinkedList<Integer> liste = LinkedList.<Integer>empty()
                                              .append(8)
                                              .append(2)
                                              .append(3)
                                              .append(9)
                                              .append(5)
                                              .append(6)
                                              .append(7)
                                              .append(1)
                                              .append(4);

        IsLessThan pred = new IsLessThan(4);

        LinkedList<Integer> expected = LinkedList.<Integer>empty()
                                                 .append(2)
                                                 .append(3)
                                                 .append(1);

        assertEquals(
                expected,
                liste.filter(pred)
        );
    }

    @Test
    void canFilterNumbersWithAbstractType() {
        LinkedList<Integer> liste = LinkedList.<Integer>empty()
                                              .append(8)
                                              .append(2)
                                              .append(3)
                                              .append(9)
                                              .append(5)
                                              .append(6)
                                              .append(7)
                                              .append(1)
                                              .append(4);

        LinkedList<Integer> expected = LinkedList.<Integer>empty()
                                                 .append(2)
                                                 .append(3)
                                                 .append(1);

        assertEquals(
                expected,
                liste.filter(new Predicate<Integer>() {
                    @Override
                    public boolean apply(Integer element) {
                        return element < 4;
                    }
                })
        );
    }


    @Test
    void canFilterNumbersWithLambdaExpression() {
        LinkedList<Integer> liste = LinkedList.<Integer>empty()
                                              .append(8)
                                              .append(2)
                                              .append(3)
                                              .append(9)
                                              .append(5)
                                              .append(6)
                                              .append(7)
                                              .append(1)
                                              .append(4);

        LinkedList<Integer> expected = LinkedList.<Integer>empty()
                                                 .append(2)
                                                 .append(3)
                                                 .append(1);

        assertEquals(
                expected,
                liste.filter((Integer element) -> {
                    return element < 4;
                })
        );
    }



    @Test
    void canFilterNumbersWithSimpleLambdaExpression() {
        LinkedList<Integer> liste = LinkedList.<Integer>empty()
                                              .append(8)
                                              .append(2)
                                              .append(3)
                                              .append(9)
                                              .append(5)
                                              .append(6)
                                              .append(7)
                                              .append(1)
                                              .append(4);

        LinkedList<Integer> expected = LinkedList.<Integer>empty()
                                                 .append(2)
                                                 .append(3)
                                                 .append(1);

        assertEquals(
                expected,
                liste.filter(element -> element < 4)
        );
    }

    @Test
    void canMap() {
        LinkedList<String> liste = LinkedList.<String>empty()
                                              .append("Hallo")
                                              .append("Ich")
                                              .append("Bin")
                                              .append("Eine")
                                              .append("Tolle")
                                              .append("Liste")
                                              .append("!");

        LinkedList<Integer> expected = LinkedList.<Integer>empty()
                                                 .append(5)
                                                 .append(3)
                                                 .append(3)
                                                 .append(4)
                                                 .append(5)
                                                 .append(5)
                                                 .append(1);

        assertEquals(
                expected,
                // TODO: map implementieren!
                liste.map(new Function<String, Integer>(){

                    @Override
                    public Integer apply(String element) {
                        return element.length();
                    }
                })
        );
        // TODO: auch als lambda schreibweise!
    }


    private static class IsLessThan implements Predicate<Integer> {

        private final int upperNumber;



        private IsLessThan(int upperNumber) {
            this.upperNumber = upperNumber;
        }



        @Override
        public boolean apply(Integer element) {
            return element < upperNumber;
        }
    }
}
