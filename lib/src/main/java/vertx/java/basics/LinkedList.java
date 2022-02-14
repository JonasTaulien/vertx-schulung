package vertx.java.basics;

public abstract class LinkedList {

    public static LinkedList empty() {
        return new Empty();
    }



    public abstract boolean isEmpty();



    public LinkedList append(int element) {
        return new Element(element, this);
    }



    public abstract int get(int index) throws IndexOutOfBoundsException;



    protected abstract int getWithCount(int index, int count) throws IndexOutOfBoundsException;



    public abstract int count();



    private static class Empty extends LinkedList {

        @Override
        public boolean isEmpty() {
            return true;
        }



        @Override
        public int get(int index) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }



        @Override
        protected int getWithCount(int index, int count) throws IndexOutOfBoundsException {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }



        @Override
        public int count() {
            return 0;
        }
    }

    private static class Element extends LinkedList {

        private final int content;

        private final LinkedList next;



        private Element(int content, LinkedList next) {
            this.content = content;
            this.next = next;
        }



        @Override
        public boolean isEmpty() {
            return false;
        }



        @Override
        public int get(int index) throws IndexOutOfBoundsException {
            int numberOfElements = this.count();
            return this.getWithCount(index, numberOfElements);
        }



        @Override
        protected int getWithCount(int index, int count) throws IndexOutOfBoundsException {
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
