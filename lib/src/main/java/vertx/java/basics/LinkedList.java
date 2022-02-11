package vertx.java.basics;

public abstract class LinkedList {

    public static LinkedList empty() {
        return new Empty();
    }



    public abstract boolean isEmpty();

    public abstract LinkedList append(int element);



    private static class Empty extends LinkedList {

        @Override
        public boolean isEmpty() {
            return true;
        }



        @Override
        public LinkedList append(int element) {
            return new Element(element, this);
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
        public LinkedList append(int element) {
            return null;
        }
    }
}
