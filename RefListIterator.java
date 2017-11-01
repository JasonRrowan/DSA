package list;
/**A ListIterator for LinkedList*/

class RefListIterator<E> extends RefIterator<E> implements ListIterator<E>
{//super.cursor refers to last value obtained by a call to next() or previous()
    boolean forward = true;

    RefListIterator(LinkedList<E> list)
    {
        super(list);
        cursor = list.head;
    }

    RefListIterator(LinkedList<E> list, int start)
    {
        super(list);
        cursor = list.head;
        for(int i = 0; i < start; i++)
        {
            cursor = cursor.next;
        }
    }

    public boolean hasNext()
    {
        if(list.isEmpty())
        {
            return false;
        }
        if(forward)
        {
            return cursor.next != list.tail;
        }
        else
        {
            return true;
        }
    }

    public E next()
    {
        if(forward)
        {
            cursor = cursor.next;
            return cursor.value;
        }
        forward = true;
        return cursor.value;
    }

    public void remove()
    {
        cursor.prev.next = cursor.next;
        cursor.next.prev = cursor.prev;
        if(forward)
        {
            cursor = cursor.prev;
        }
        else
        {
            cursor = cursor.next;
        }
        list.size--;
    }

    public boolean hasPrevious()
    {
        if(forward)
        {
            return cursor != list.head;
        }
        return cursor.prev != list.head;
    }

    public E previous()
    {
        if(!forward)
        {
            cursor = cursor.prev;
        }
        forward = false;
        return cursor.value;
    }

    public void add(E value)
    {

        if(forward)
        {
            Node<E> temp = new Node<E>(value, cursor.next, cursor);
            cursor.next.prev = temp;
            cursor.next =  temp;
            cursor = temp;
        }
        else
        {
            Node<E> temp = new Node<E>(value, cursor, cursor.prev);
            cursor.prev.next = temp;
            cursor.prev = temp;
        } 
        list.size++;
    }
}
