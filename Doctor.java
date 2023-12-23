public class Doctor implements Comparable<Doctor> {
    private int id;
    private String name;
    private String department;
//    private int maxSize;
    private int currentSize;

    public Doctor(int id, String name, int currentSize, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
//        this.maxSize = maxSize;
        this.currentSize = currentSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    @Override
    public int compareTo(Doctor o) {
        if (this.currentSize < o.currentSize)
            return -1;
        if (this.currentSize > o.currentSize)
            return 1;
        return 0;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

