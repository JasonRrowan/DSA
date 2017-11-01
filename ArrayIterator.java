package list;

/**An iterator for arraylist*/

class ArrayIterator<E> implements Iterator<E>
{
    List<E> list;
    //position of lasta value obtained by next
    int ndx = -1;
    ArrayIterator(List<E> list)
    {
        this.list = list;
    }

    public boolean hasNext()
    {
        return ndx < list.size() - 1;
    }

    public E next()
    {
        ndx++;
        return list.get(ndx);
    }

    public void remove()
    {
        list.remove(ndx);
        ndx--;
    }

    public boolean hasThreeMore()
    {
        int size = 0;
        while(this.hasNext())
        {
            this.next();
            size++;
        }
        if(size >= 3)
        {
            return true;
        }
        return false;
    }
}
