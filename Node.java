package list;

class Node<E>
{
    E value;
    Node<E> next;
    Node<E> prev;
    private Node<E> ref;

    Node(E value, Node<E> next, Node<E> prev)
    {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

