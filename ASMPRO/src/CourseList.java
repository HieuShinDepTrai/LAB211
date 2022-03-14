

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class CourseList {
    ArrayList<Course> a;
    Scanner in;

    public CourseList() {
        a = new ArrayList<>();
        in = new Scanner(System.in);
    }

    // Thêm một Course vào trong ArrayList a, dữ liệu nhận từ người dùng
    public void add() {
        while (true) {
            String id = Validation.getString("Enter course id: ");
            if (getCourseById(id) != null) {
                System.out.println("Already exist!");
                continue;
            }

            String name = Validation.getString("Enter course name: ");

            int credit = Validation.getInt("Enter course credit: ", 0, Integer.MAX_VALUE);

            a.add(new Course(name, id, credit));
            System.out.println("Information of course has been added");
            break;
        }
    }

    // In ra tất cả những Course trong ArrayList a
    public void listAll() {
        printHeader();
        for (Course c : a) {
            printCourse(c);
        }
    }

    // Truy xuất đến Course bằng ID
    public Course getCourseById(String id) {
        for (Course c : a) {
            if (c.getId().equalsIgnoreCase(id)) {
                return c;
            }
        }
        return null;
    }

    // In Course
    public void printCourse(Course c) {
        System.out.printf("%-15s | %-25s | %-15d\n", c.getId(), c.getName(), c.getCredit());
    }

    //In header
    public void printHeader() {
        System.out.printf("%-15s | %-25s | %-15s\n", "Course id", "Course name", "Course credit");
    }

    // Tìm kiếm Course thông qua ID
    // Sử dụng getCourseById đã viết ở trên
    // Nếu chưa có Course nào có Id đó thì sẽ in ra là "Does Not Exist!"
    // Nếu có thì in ra thông tin của Course đó
    public void search() {
        while (true) {
            String id = Validation.getString("Enter course id: ");
            Course c = getCourseById(id);
            if (c == null) {
                System.out.println("Does not exist!");
                continue;
            }

            System.out.println("Information of course");
            printCourse(c);
            break;
        }
    }

    // Sắp xếp lại ArrayList a theo thứ tự mạc định sau đó in ra thông báo
    public void sort() {
        Collections.sort(a);
        System.out.println("Information of course has been sorted");
    }

    // Cập nhật lại thông tin của Course qua Id nhận từ người dùng
    public void update() {
        while (true) {
            String id = Validation.getString("Enter course id: ");
            Course c = getCourseById(id);
            if (c == null) {
                System.out.println("Does not exist!");
                continue;
            }

            System.out.println("Information of course");
            printCourse(c);

            c.setCredit(Validation.getInt("Enter new course credit: ", 0, Integer.MAX_VALUE));

            System.out.println("Information of course has been updated");
            break;
        }
    }
}
