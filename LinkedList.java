package list;
/**
 * Lab 2
 * 
 * 
 * @author (Jason Renna) 
 * @version (Sep 2017)
 */
public class LinkedList<E> implements List<E>
{
    int size = 0;
    Node<E> head;
    Node<E> tail;
    private Node<E> ref;

    public LinkedList()
    {
        head = new Node<E>(null, null, null);
        tail = new Node<E>(null, null, head);
        head.next = tail;
    }

    /** made to avoid duplicate code*/
    private void setRef(int ndx)
    {   
        if(ndx > (size/2))
        {
            ref = tail.prev;
            for(int i = size; i > ndx; i--)
            {
                ref = ref.prev;
            }
        }
        else if(ndx <= (size/2))
        {
            ref = head.next;
            for(int i = 0; i < ndx; i++)
            {
                ref = ref.next;
            }
        }
    }

    public void add(E value)
    {
        Node<E> temp = new Node<E>(value, tail, tail.prev);
        tail.prev.next = temp;
        tail.prev = temp;
        size++;
    }

    public void add(int ndx, E value)
    {
        setRef(ndx);
        Node<E> temp = new Node<E>(value, ref, ref.prev);
        ref.prev.next = temp;
        ref.prev = temp;
        size++;
    }

    public E get(int ndx)
    {
        //ref = head.next;
        setRef(ndx);
        return ref.value;
    }

    public E set(int ndx, E value)
    {
        setRef(ndx);
        E result = ref.value;
        ref.value = value;
        return result;
    }

    public E remove(int ndx)
    {
        setRef(ndx);
        ref.prev.next = ref.next;
        ref.next.prev = ref.prev;
        size--;
        return ref.value;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        Node<E> temp = head;
        boolean empty = true;
        for(int i = 0; (i < size) && (get(i) != null); i++)
        {
            if(temp.next.value != null)
            {
                empty = false;
            }
            temp = temp.next;
        }
        return empty;
    }

    public void clear()
    {
        head.next = tail;
        tail.prev = head;
        size = 0;

    }

    public int indexOf(E obj)
    {
        Node<E> temp = head;
        for(int i = 0;((i < size)); i++)
        {
            if(temp.next.value.equals(obj))
            {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    public boolean contains(E obj)
    {
        boolean temp = false;
        if(indexOf(obj) != -1)
            temp = true;
        return temp;
    }

    public String toString()
    {
        if(!(isEmpty()))
        {
            Node<E> temp = head;
            String result = "[";
            for(int i = 0; i < size; i++)
            {
                if(size -1 > i)
                {
                    result = result.concat(temp.next.value + ", "); 
                }
                else
                {
                    result = result.concat(temp.next.value + ""); 
                }
                temp = temp.next;
            }
            return result + "]";
        }
        return null;
    }

    public boolean equals (Object obj)
    {
        if(obj == this)
        {
            return true;
        }
        if(obj instanceof List)
        {
            List<E> temp = (List<E>) obj;
            int tempSize = temp.size();
            if(size != tempSize)
            {
                return false;
            }
            Iterator<E> tempIt = temp.iterator();
            Iterator<E> thisIt = this.iterator();
            while(tempIt.hasNext())
            {
                if(!tempIt.next().equals(thisIt.next()))
                {
                    return false;

                }
            }
            return true;
        }
        return false;
    }

    public Iterator<E> iterator()
    {
        return new RefIterator<E>(this);
    }

    public ListIterator<E> listIterator()
    {
        return new RefListIterator<E>(this);
    }

    public ListIterator<E> listIterator(int start)
    {
        return new RefListIterator<E>(this, start);
    }

    public boolean equalNeighbors()
    {
        return true;
    }

    public void addAll(List list)
    {
        Iterator<E> it = this.iterator();
        while(it.hasNext())
        {
            E value = it.next();
            list.add(value);
        }
    }
}

