/**
 * MyHashTable class implements a basic hash table data structure with chaining for collision resolution.
 * @param <K> the type of keys stored in the hash table
 * @param <V> the type of values stored in the hash table
 */
public class MyHashTable<K, V> {


    static class HashNode<K, V> {
        /**
         * Constructs a new hash node with the specified key and value.
         * @param key the key of the node
         * @param value the value of the node
         */
        private K key;
        private V value;
        HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
        /**
         * Returns a string representation of the hash node.
         * @return a string representation of the hash node
         */
        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    HashNode<K, V>[] chainArray;// Array to store chains of hash nodes
    private int M = 11;
    private int size;// Number of elements in the hash table
    /**
     * Constructs an empty hash table with the default number of chains.
     */
    public MyHashTable() {
        chainArray = new HashNode[M];
        size = 0;
    }
    /**
     * Constructs an empty hash table with the specified number of chains.
     * @param M the number of chains
     */

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
        size = 0;
    }
    /**
     * Calculates the hash value for the specified key.
     * @param key the key for which to calculate the hash value
     * @return the hash value of the key
     */

    private int hash(K key) {
        return Math.abs(key.hashCode()) % M;
    }
    /**
     * Inserts a key-value pair into the hash table.
     * @param key the key to insert
     * @param value the value to insert
     */
    public void put(K key, V value) {
        int index = hash(key);
        HashNode<K, V> newNode = new HashNode<>(key, value);

        if (chainArray[index] == null) {
            chainArray[index] = newNode;
        } else {
            HashNode<K, V> current = chainArray[index];
            while (current.next != null) {
                if (current.key.equals(key)) {
                    current.value = value;
                    return;
                }
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    /**
     * Retrieves the value associated with the specified key from the hash table.
     * @param key the key whose associated value is to be retrieved
     * @return the value associated with the specified key, or null if the key is not found
     */
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];

        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        HashNode<K, V> prev = null;

        while (current != null) {
            if (current.key.equals(key)) {
                if (prev == null) {
                    chainArray[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return current.value;
            }
            prev = current;
            current = current.next;
        }
        return null;
    }
    /**
     * Checks if the hash table contains the specified value.
     * @param value the value to check for
     * @return true if the hash table contains the value, otherwise false
     */
    public boolean contains(V value) {
        for (HashNode<K, V> node : chainArray) {
            HashNode<K, V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return true;
                }
                current = current.next;
            }
        }
        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> node : chainArray) {
            HashNode<K, V> current = node;
            while (current != null) {
                if (current.value.equals(value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;

    }
    public int getSize() {
        return size;
    }
}
/**
 * Retrieves the key associated with the specified value from the hash table.
 * @param value the value whose associated key is to be retrieved
 * @return the key associated with the specified value, or null if the value is not found
 */