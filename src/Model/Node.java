package Model;




public class Node<E> {
    E element;
    Node<E> left;
    Node<E> right;

    public Node(E element) {
        this(element, null, null);
    }

    public Node(E element, Node<E> left, Node<E> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}

}
