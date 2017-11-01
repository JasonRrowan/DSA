package list;

public interface Iterator<E>
{
    /**@return true if thre are more values to be obtained*/
    boolean hasNext(); 

    /**@return the next element in the collection.  (Pre-condition: hasNext() is true)*/
    E next();

    /**Remove the value last obtained by a call to next() (Precondition: next() has been called at least once since last call to remove*/
    void remove();

    boolean hasThreeMore();
}