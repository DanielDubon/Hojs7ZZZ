package Controller;


public class Assosiation<K, V> implements Comparable<Assosiation<String, String>> {
    private K key;
    private V value;

    public Assosiation(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(Assosiation<String, String> o) {
        return 0;
    }

    @Override
    public String toString() {
        return key.toString() + ": " + value.toString();
    }
}
