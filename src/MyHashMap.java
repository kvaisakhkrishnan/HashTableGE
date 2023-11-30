import java.util.StringTokenizer;


class MyHashMap<K, V> {
    private int size;
    private MyMapNode<K, V>[] buckets;

    public MyHashMap(int size) {
        this.size = size;
        this.buckets = new MyMapNode[size];
    }

    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % size;
        return index < 0 ? index + size : index;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }

        return null; 
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        MyMapNode<K, V> newNode = new MyMapNode<>(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = buckets[index];
        MyMapNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void displayFrequency() {
        for (MyMapNode<K, V> head : buckets) {
            while (head != null) {
                System.out.println("Word: " + head.key + ", Frequency: " + head.value);
                head = head.next;
            }
        }
    }
}