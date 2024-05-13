import java.util.Random;
/**
 * TestHashTable class is used to test the functionality of the MyHashTable class.
 */
public class TestHashTable {
    public static void main(String[] args) {
        MyHashTable<MyTestingClass, Student> table = new MyHashTable<>();
        Random random = new Random();

        // Add 10000 random elements to the hashtable
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass(random.nextInt(10000));
            Student value = new Student("Student " + i, random.nextInt(100));
            table.put(key, value);
        }

        // Print number of elements in each bucket
        int[] bucketSizes = new int[table.chainArray.length];
        for (int i = 0; i < table.chainArray.length; i++) {
            MyHashTable.HashNode<MyTestingClass, Student> current = table.chainArray[i];
            while (current != null) {
                bucketSizes[i]++;
                current = current.next;
            }
        }

        for (int i = 0; i < bucketSizes.length; i++) {
            System.out.println("Bucket " + i + ": " + bucketSizes[i] + " elements");
        }
    }

    public void test() {
    }
}
class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}