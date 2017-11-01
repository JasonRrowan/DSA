package list;
/**An iterator for LinkedList*/
class RefIterator<E> implements Iterator<E>
{
    LinkedList<E> list;
    //ref to the node with value obtained by next()
    Node<E> cursor;

    public RefIterator(LinkedList<E> list)
    {
        this.list = list;
        cursor = list.head;
    }

    public boolean hasNext()
    {
        return cursor.next != list.tail;
    }

    public E next()
    {
        cursor = cursor.next;
        return cursor.value;
    }

    public void remove()
    {
        cursor.next.prev = cursor.prev;
        cursor.prev.next = cursor.next;
        cursor = cursor.prev;
        list.size--;
    }
    
    public boolean hasThreeMore()
    {
        return false;
    }
    
}
