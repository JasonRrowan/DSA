package list; 
/**
 * Write a description of class ArrayList here.
 * 
 * @author (Jason Renna ) 
 * @version (9/10/17)
 */
public class ArrayList<E> implements List<E>
{
    // instance variables - replace the example below with your own
    int size = 0;
    E[] values;

    /**
     * Constructor for objects of class ArrayList
     */
    public ArrayList()
    {
        this(10);
    }

    public ArrayList(int cap)
    {
        values = (E[]) new Object[cap];
    }  

    public E get(int ndx)
    {
        return values[ndx];
    }

    public E set(int ndx, E value)
    {
        E result = values[ndx];
        values[ndx] = value;
        return value;
    }

    public void add(E value)
    {
        add(size, value);
    }

    public void add(int ndx, E value)
    {
        if(size == values.length)
            alloc();
        for(int i = size; i > ndx; i--)
            values[i] = values[i - 1];
        values[ndx] = value;
        size++;
    }

    public void alloc()
    {
        E[] temp = (E[]) new Object[2 * values.length];
        for(int i = 0; i < size; i++)
            temp[i] = values[i];
        values = temp;
    }

    public E remove(int ndx)
    {
        E result = values[ndx];
        for(int i = ndx; i < size - 1; i++)
            values[i] = values[i + 1];
        size--;
        return result;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        boolean empty = true;
        for(int i = 0; (i < size) && (get(i) != null); i++)
        {
            if(get(i) != null)
            {
                empty = false;
            }
        }
        return empty;
    }

    public void clear()
    {
        for(int i = 0; i < size; i++)
            values[i] = null;
        size = 0;

    }

    public int indexOf(E obj)
    {
        for(int i = 0;((i < size)); i++)
        {
            if(values[i].equals(obj))
            {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(E obj)
    {
        for(int i = 0;((i < size)); i++)
        {
            if(values[i].equals(obj))
            {
                return true;
            }
        }
        return false;
    }

    public String toString()
    {
        if(!(isEmpty()))
        {
            String result = "[";
            for(int i = 0; i < size; i++)
            {
                if(size -1 > i)
                {
                    result = result.concat(values[i] + ", "); 
                }
                else
                {
                    result = result.concat(values[i] + ""); 
                }
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
        return new ArrayIterator<E>(this);
    }

    public ListIterator<E> listIterator()
    {
        return new ArraylistIterator<E>(this);
    }

    public ListIterator<E> listIterator(int start)
    {
        return new ArraylistIterator<E>(this, start);
    }

    /**  @return true only if there is at least one pair of neighbors in this List which are equal */
    public boolean equalNeighbors()
    {
        for(int i = 0;((i < size)); i++)
        {
            if(values[i].equals(values[i + 1]))
            {
                return true;
            }
        }
        return false;
    }

    public void addAll(List list)
    {
        
        for(int i = 0; i < (size); i++)
        {
            E value = values[i];
            list.add(value);
        }
        /**

                for(E stuff : values)
        {
            list.add(i,stuff);
        }
        */
    }
}

