import java.util.StringTokenizer;

class MyMapNode<K, V> {
    K key;
    V value;
    MyMapNode<K, V> next;

    // Constructor
    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}