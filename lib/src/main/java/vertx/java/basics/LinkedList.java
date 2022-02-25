package vertx.java.basics;

import java.util.Objects;
import java.util.Optional;

public abstract class LinkedList<E> {

    /**
     * @param <E> the element type
     *
     * @return an empty LinkedList
     */
    public static <E> LinkedList<E> empty() {
        return new Empty<>();
    }



    /**
     * @return true if this LinkedList is empty, otherwise false
     */
    public abstract boolean isEmpty();



    /**
     * @param element the element to append
     *
     * @return a new LinkedList with the same contents as this LinkedList but with the new element added to the end
     */
    public LinkedList<E> append(E element) {
        return new Element<>(element, this);
    }



    /**
     * @param index index of the element to return
     *
     * @return the element at the specified index (first element has the index 0)
     *
     * @throws IndexOutOfBoundsException if this LinkedList is empty or if it is not large enough to have an element
     *                                   at the given index
     */
    public abstract E get(int index) throws IndexOutOfBoundsException;


    public abstract Optional<E> safeGet(int index);



    protected abstract E getInternal(int index, int indexOfCurrentElement) throws IndexOutOfBoundsException;

    protected abstract Optional<E> safeGetInternal(int index, int indexOfCurrentElement);



    /**
     * @return the number of elements in this LinkedList
     */
    public abstract int count();



    /**
     * @param predicate the predicate to test each element
     *
     * @return a new LinkedList with the same contents as this LinkedList but without all elements where the given
     *         predicate returned false
     */
    public abstract LinkedList<E> filter(Predicate<E> predicate);



    /**
     * @param mapper the function to use for transforming each element
     * @param <F>    the element type of the new LinkedList
     *
     * @return a new LinkedList where each of the elements of this LinkedList got transformed with the given mapper
     *         function
     */
    public abstract <F> LinkedList<F> map(Function<E, F> mapper);



    /**
     * @param mapper the function to use for transforming each element into a LinkedList
     * @param <F>    the element type of the new LinkedList
     *
     * @return a new LinkedList where each of the elements of this LinkedList got transformed into a LinkedList and
     *         then all of those LinkedList got concatenated
     */
    public abstract <F> LinkedList<F> flatMap(Function<E, LinkedList<F>> mapper);



    /**
     * @param list the LinkedList to append
     *
     * @return a new LinkedList that contains all elements of this LinkedList and then all elements of the given
     *         LinkedList
     */
    public abstract LinkedList<E> appendAll(LinkedList<E> list);



    protected abstract LinkedList<E> prependAll(LinkedList<E> list);



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
        public Optional<E> safeGet(int index) {
            return Optional.empty();
        }



        @Override
        protected E getInternal(int index, int indexOfCurrentElement) throws IndexOutOfBoundsException {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }



        @Override
        protected Optional<E> safeGetInternal(int index, int indexOfCurrentElement) {
            return Optional.empty();
        }



        @Override
        public int count() {
            return 0;
        }



        @Override
        public LinkedList<E> filter(Predicate<E> predicate) {
            return this;
        }



        @Override public <F> LinkedList<F> map(Function<E, F> mapper) {
            return LinkedList.empty();
        }



        @Override
        public <F> LinkedList<F> flatMap(Function<E, LinkedList<F>> mapper) {
            return LinkedList.empty();
        }



        @Override
        public LinkedList<E> appendAll(LinkedList<E> list) {
            return list;
        }



        @Override protected LinkedList<E> prependAll(LinkedList<E> list) {
            return list;
        }



        @Override
        public boolean equals(Object o) {
            return (o instanceof Empty<?>);
        }



        @Override
        public int hashCode() {
            return Objects.hash();
        }



        @Override
        public String toString() {
            return "";
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
        public Optional<E> safeGet(int index) {
            int numberOfElements = this.count();

            return this.safeGetInternal(index, numberOfElements - 1);
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
        protected Optional<E> safeGetInternal(int index, int indexOfCurrentElement) {
            if (index == indexOfCurrentElement) {
                return Optional.of(this.content);

            } else {
                return this.next.safeGetInternal(index, indexOfCurrentElement - 1);
            }
        }



        @Override
        public int count() {
            return 1 + this.next.count();
        }



        @Override
        public LinkedList<E> filter(Predicate<E> predicate) {
            if (predicate.apply(this.content)) {
                return new Element<>(this.content, this.next.filter(predicate));

            } else {
                return this.next.filter(predicate);
            }
        }



        @Override
        public <F> LinkedList<F> map(Function<E, F> mapper) {
            return new Element<>(
                    mapper.apply(this.content),
                    this.next.map(mapper)
            );
        }



        @Override
        public <F> LinkedList<F> flatMap(Function<E, LinkedList<F>> mapper) {
            return mapper.apply(this.content).prependAll(this.next.flatMap(mapper));
        }



        @Override
        public LinkedList<E> appendAll(LinkedList<E> list) {
            return list.prependAll(this);
        }



        @Override
        public LinkedList<E> prependAll(LinkedList<E> list) {
            return new Element<>(this.content, this.next.prependAll(list));
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



        @Override
        public int hashCode() {
            return Objects.hash(content, next);
        }



        @Override
        public String toString() {
            return this.next.isEmpty()
                   ? "" + this.content
                   : this.next + "," + this.content;
        }
    }
}
