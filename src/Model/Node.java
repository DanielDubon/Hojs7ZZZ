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

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public Node<E> getLeft() {
        return left;
    }

    public void setLeft(Node<E> left) {
        this.left = left;
    }

    public Node<E> getRight() {
        return right;
    }

    public void setRight(Node<E> right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node [data=" + element + ", leftChild=" + left + ", rightChild=" + right + "]";
    }
}


