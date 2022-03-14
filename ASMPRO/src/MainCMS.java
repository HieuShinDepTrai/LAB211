
/*
Class Main
- While choice != 0 để nhập khi nào khác 0, vì khác 0 sẽ Exit
- Swich case để lựa chọn option
*/
public class MainCMS {

    public static void main(String[] args) {
        int choice;

        CourseList cl = new CourseList();

        do {
            choice = Menu.menu();

            switch (choice) {
                case 1:
                    cl.listAll();
                    break;
                case 2:
                    cl.search();
                    break;
                case 3:
                    cl.add();
                    break;
                case 4:
                    cl.sort();
                    break;
                case 5:
                    cl.update();
                    break;
            }
        } while (choice != 0);
    }
}
