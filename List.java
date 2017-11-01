package list;
/**
 * Write a description of interface List here.
 * 
 * @author (Jason Renna) 
 * @version (9/10/17)
 */
public interface List<E>
{
    E get(int ndx);

    E set(int ndx, E value);

    void add(E value);

    void add(int ndx, E value);

    E remove(int ndx);

    int size();

    boolean isEmpty();

    void clear();

    int indexOf(E obj);

    boolean contains(E obj);

    boolean equals (Object obj);

    Iterator<E> iterator();

    ListIterator<E> listIterator();

    ListIterator<E> listIterator(int start);

    boolean equalNeighbors();
    
    void addAll(List list);
}
