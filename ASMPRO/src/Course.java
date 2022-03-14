

public class Course implements Comparable<Course> { 
    private int credit;
    private String id;
    private String name;

    //Constructors
    public Course() {
    }

    public Course(String name, String id, int credit) {
        this.credit = credit;
        this.id = id;
        this.name = name;
    }

    //getter and setter
    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // So sánh theo ID
    @Override
    public boolean equals(Object o) {
        if (o instanceof Course) {
            return getId().equalsIgnoreCase(((Course) o).getId());
        }
        return false;
    }

    // So sánh theo Credit
    @Override
    public int compareTo(Course c) {
        return getCredit() - c.getCredit();
    }
}
