package list;
/**an iterator that can move in both directions*/
public interface ListIterator<E> extends Iterator<E>
{
    /** @return true if there is a previous value*/
    boolean hasPrevious();

    /** @return the previous value Pre: hasPrevious is true*/
    E previous();

    /** remove the last value obtained by a call to next or previous Pre: must be preceded by a call to next() or previous()*/
    void remove();

    public void add (E value);
}
