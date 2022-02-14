package vertx.java.basics;

public abstract class LinkedList<E> {

    public static <E> LinkedList<E> empty() {
        return new Empty<E>();
    }



    public abstract boolean isEmpty();



    public LinkedList<E> append(E element) {
        return new Element<E>(element, this);
    }



    public abstract E get(int index) throws IndexOutOfBoundsException;



    protected abstract E getWithCount(int index, int count) throws IndexOutOfBoundsException;



    public abstract int count();



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
        protected E getWithCount(int index, int count) throws IndexOutOfBoundsException {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }



        @Override
        public int count() {
            return 0;
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
            return this.getWithCount(index, numberOfElements);
        }



        @Override
        protected E getWithCount(int index, int count) throws IndexOutOfBoundsException {
            if (index == (count - 1)) {
                return this.content;

            } else {
                return this.next.getWithCount(index, count - 1);
            }
        }



        @Override
        public int count() {
            return 1 + this.next.count();
        }
    }
}
