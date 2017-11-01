package list;
/**A List iterator for ArrayLists*/
class ArraylistIterator<E> extends ArrayIterator<E> implements ListIterator<E>
{
    //super ndx is the implicit cursor position, between pos ndx-1 and ndx
    boolean forward = true;

    ArraylistIterator(List<E> list)
    {
        super(list);
        ndx = 0;
    }

    ArraylistIterator(List<E> list, int start)
    {
        super(list);
        ndx = start;
    }

    public boolean hasNext()
    {
        return ndx < list.size();
    }

    public E next()
    {
        ndx++;
        return list.get(ndx-1);
    }

    //public void remove()
    //{
    //    if(forwad)
    //    {
    //        ndx--;
    //        list.remove(ndx);
    //    }
    //    else
    //    {
    //        list.remove(ndx);
    //    }
    //}

    /**simple version*/
    public void remove()
    {
        if(forward)
        {
            ndx--;
        }
        list.remove(ndx);
    }

    public boolean hasPrevious()
    {
        return ndx > 0;
    }

    public E previous()
    {
        forward = false;
        ndx--;
        return list.get(ndx);
    }

    public void add(E value)
    {
        list.add(ndx,value);
        ndx++;
    }
}

