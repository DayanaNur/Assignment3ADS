import java.util.Random;

public class Main {

    public static void main(String[] args) {
        // Creating a binary tree instance
        BST<Integer, String> binaryTree = new BST<>();

        // Inserting elements into the binary tree
        binaryTree.insert(5, "Five");
        binaryTree.insert(3, "Three");
        binaryTree.insert(4, "Four");
        binaryTree.insert(2, "Two");
        binaryTree.insert(6, "Six");
        binaryTree.insert(7, "Seven");

        System.out.println("Inorder traversal before removal:");
        binaryTree.inOrder();
        System.out.println();
        System.out.println("Root data before removal: " + binaryTree.size());

        binaryTree.remove(5);
        System.out.println();
        System.out.println("Root data after removal: " + binaryTree.size());
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        // Add random 10000 elements to the hashtable
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(1000)); // Assuming values range from 0 to 999
            Student value = new Student("Name" + i, i); // You need to define the Student class
            table.put(key, value);
        }

        printBucketSizes(table);
    }

    public static void printBucketSizes(MyHashTable<MyTestingClass, Student> table) {
        int[] bucketSizes = new int[table.getSize()];

        for (MyHashTable.HashNode<MyTestingClass, Student> node : table.chainArray) {
            int count = 0;
            while (node != null) {
                count++;
                node = node.next;
            }
            if (count < bucketSizes.length) {
                bucketSizes[count]++;
            }
        }

        for (int i = 0; i < bucketSizes.length; i++) {
            if (bucketSizes[i] != 0) {
                System.out.println("Bucket size " + i + ": " + bucketSizes[i]);
            }
        }
    }
}