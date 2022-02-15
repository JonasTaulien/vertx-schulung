package vertx.java.basics;

import java.util.Objects;

public abstract class LinkedList<E> {

    public static <E> LinkedList<E> empty() {
        return new Empty<>();
    }



    public abstract boolean isEmpty();



    public LinkedList<E> append(E element) {
        return new Element<>(element, this);
    }



    public abstract E get(int index) throws IndexOutOfBoundsException;



    protected abstract E getInternal(int index, int count) throws IndexOutOfBoundsException;



    public abstract int count();

    public abstract LinkedList<E> filter(Predicate<E> predicate);



    private static class Empty<E> extends LinkedList<E> {

        @Override
        public boolean isEmpty() {
            return true;
        }



        @Override
        public E get(int index) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }



        @Override
        protected E getInternal(int index, int count) throws IndexOutOfBoundsException {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }



        @Override
        public int count() {
            return 0;
        }



        @Override
        public LinkedList<E> filter(Predicate<E> predicate) {
            return this;
        }



        @Override
        public boolean equals(Object o) {
            return (o instanceof Empty<?>);
        }
    }

    private static class Element<E> extends LinkedList<E> {

        private final E content;

        private final LinkedList<E> next;



        private Element(E content, LinkedList<E> next) {
            this.content = content;
            this.next = next;
        }



        @Override
        public boolean isEmpty() {
            return false;
        }



        @Override
        public E get(int index) throws IndexOutOfBoundsException {
            int numberOfElements = this.count();
            return this.getInternal(index, numberOfElements - 1);
        }



        @Override
        protected E getInternal(int index, int indexOfCurrentElement) throws IndexOutOfBoundsException {
            if (index == indexOfCurrentElement) {
                return this.content;

            } else {
                return this.next.getInternal(index, indexOfCurrentElement - 1);
            }
        }



        @Override
        public int count() {
            return 1 + this.next.count();
        }



        @Override
        public LinkedList<E> filter(Predicate<E> predicate) {
            if(predicate.apply(this.content)){
                return new Element<>(this.content, this.next.filter(predicate));

            } else {
                return this.next.filter(predicate);
            }
        }



        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Element<?> element = (Element<?>) o;
            return Objects.equals(content, element.content) && Objects.equals(next, element.next);
        }



        @Override public int hashCode() {
            return Objects.hash(content, next);
        }
    }
}
