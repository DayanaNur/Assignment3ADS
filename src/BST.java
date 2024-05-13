import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * BST class represents a binary search tree data structure.
 * @param <K> the type of keys stored in the tree, which must be Comparable
 * @param <V> the type of values associated with the keys
 */
public class BST<K extends Comparable<K>, V> implements Iterable<BST.Entry<K, V>> {
    private Node root;
    private int size;
    /**
     * Constructs an empty binary search tree.
     */
    public BST() {
        root = null;
        size = 0;
    }

    public void inOrder() {
    }
    /**
     * Removes a node with the specified key from the binary search tree.
     * @param i the key of the node to be removed
     */
    public void remove(int i) {
    }

    private class Node {
        private K key;
        private V value;
        private Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
    /**
     * Inserts a new key-value pair into the binary search tree.
     * @param key the key to be inserted
     * @param value the value associated with the key
     */
    public void insert(K key, V value) {
        root = insert(root, key, value);
    }
    private Node insert(Node current, K key, V value) {
        if (current == null) {
            size++;
            return new Node(key, value);
        }
        int cmp = key.compareTo(current.key);
        if (cmp < 0) current.left = insert(current.left, key, value);
        else if (cmp > 0) current.right = insert(current.right, key, value);
        else current.value = value; // Update value if key already exists
        return current;
    }

    // Size method
    public int size() {
        return size;
    }

    private void inorder(Node node, List<Entry<K, V>> list) {
        if (node != null) {
            inorder(node.left, list);
            list.add(new Entry<>(node.key, node.value));
            inorder(node.right, list);
        }
    }


    @Override
    public Iterator<Entry<K, V>> iterator() {
        List<Entry<K, V>> entries = new ArrayList<>();
        inorder(root, entries);
        return entries.iterator();
    }
    /**
     * Entry class representing a key-value pair in the binary search tree.
     * @param <K> the type of the key
     * @param <V> the type of the value
     */
    public static class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}



