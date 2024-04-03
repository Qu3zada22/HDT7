
class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int compareTo(Association<K, V> other) {
        if (other == null) {
            return -1; // Si other es null, consideramos que este objeto es menor
        }
        return this.key.compareTo(other.getKey());
    }
}
