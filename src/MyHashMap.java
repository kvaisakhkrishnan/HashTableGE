import java.util.StringTokenizer;


class MyHashMap<K, V> {
    private int size;
    private MyMapNode<K, V>[] buckets;

    // Constructor
    public MyHashMap(int size) {
        this.size = size;
        this.buckets = new MyMapNode[size];
    }

    // Get the index for a key
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % size;
        return index < 0 ? index + size : index;
    }

    // Get the value for a key
    public V get(K key) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; // Key not found
    }

    // Put a key-value pair into the hash map
    public void put(K key, V value) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = buckets[index];

        // Check if key already exists, update value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Key not found, add a new node
        MyMapNode<K, V> newNode = new MyMapNode<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // Display the frequency of words in the hash map
    public void displayFrequency() {
        for (MyMapNode<K, V> head : buckets) {
            while (head != null) {
                System.out.println("Word: " + head.key + ", Frequency: " + head.value);
                head = head.next;
            }
        }
    }
}