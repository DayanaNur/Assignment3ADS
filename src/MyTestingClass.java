import java.util.Random;
/**
 * MyTestingClass represents a simple testing class with an id and a name.
 */
class MyTestingClass {
    private int id;
    private String name;
    /**
     * Constructs a MyTestingClass object with the specified id.
     * @param id the id of the object
     */
    public MyTestingClass(int id) {
        this.id = id;
        this.name = name;
    }

    /**
     * Custom hashCode method to ensure better distribution.
     * @return the hash code of the object
     */
    @Override
    public int hashCode() {
        int hash = 17;
        hash = 29 * hash + id;
        hash = 29 * hash + (name != null ? name.hashCode() : 0);
        return hash;
    }
    /**
     * Indicates whether some other object is "equal to" this one.
     * @param obj the reference object with which to compare
     * @return true if this object is the same as the obj argument; false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        MyTestingClass other = (MyTestingClass) obj;
        return id == other.id && (name != null ? name.equals(other.name) : other.name == null);
    }
}




