package Controller;

import com.sun.nio.sctp.Association;

public class WordAssociation implements Comparable<WordAssociation> {
    private Assosiation<String, String> association;

    public WordAssociation(String key, String value) {
        this.association = new Assosiation<>(key, value);
    }

    public String getKey() {
        return association.getKey();
    }

    public String getValue() {
        return association.getValue();
    }

    @Override
    public int compareTo(WordAssociation other) {
        return this.getKey().compareTo(other.getKey());
    }

    @Override
    public String toString() {
        return getKey() + ": " + getValue();
    }
}

