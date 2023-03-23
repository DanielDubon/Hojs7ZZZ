package Model;

public class BST<E extends Comparable<? super E>> {
    private Node<E> root;

    public BST() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void makeEmpty() {
        root = null;
    }

    public void insert(E x) {
        root = insert(x, root);
    }

    public void remove(E x) {
        root = remove(x, root);
    }

    public E findMin() {
        if (isEmpty())
            return null;
        return findMin(root).element;
    }

    public E findMax() {
        if (isEmpty())
            return null;
        return findMax(root).element;
    }

    public boolean contains(E x) {
        return contains(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty tree");
        else
            printTree(root);
    }

    private Node<E> insert(E x, Node<E> t) {
        if (t == null)
            return new Node<>(x);
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = insert(x,  t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ; // duplicate, do nothing
        return t;
    }

    private Node<E> remove(E x, Node<E> t) {
        if (t == null)
            return t;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    private Node<E> findMin(Node<E> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    private Node<E> findMax(Node<E> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;
        return t;
    }

    private boolean contains(E x, Node<E> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true; // match
    }

    private void printTree(Node<E> node) {
        if (node != null) {
            printTree(node.left);
            System.out.println(node.element);
            printTree(node.right);
        }

    }


}
