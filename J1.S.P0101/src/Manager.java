
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class Manager extends ArrayList<employee> {

    //Search employee by ID, tra ve employee day neu tim thay
    public employee search(String id) {
        id = id.trim().toUpperCase();
        for (int i = 0; i < this.size(); i++) // linear search is used
        {
            if (this.get(i).getId().equals(id)) {
                return this.get(i);
            }
        }
        return null; // not found
    }

    //tim kiem theo ten
    public employee searchName(String xName) {

        for (int i = 0; i < this.size(); i++) {
            String Fullname = this.get(i).getFirstName() + this.get(i).getLastName();
            if (Fullname.toLowerCase().contains(xName.toLowerCase())) {
                return this.get(i);
            }
        }
        return null; // not found
    }

    //check id duplicate
    private boolean isIDDupplicated(String id) {
        id = id.trim().toUpperCase();
        return search(id) != null; //neu id da ton tai thi tra ve true
    }

    //--------------------------ham display list--------------------------------
    public void Display() {
        if (this.isEmpty()) {
            System.err.println("Empty list!!!!!");
        } else {
            System.out.println("-------------------------Employee list:--------------------------");
            System.out.printf("%-10s%-20s%-15s%-20s%-30s%-20s%-15s%-10s%-15s%-30s\n",
                    "ID",
                    "FIRST NAME",
                    "LAST NAME",
                    "PHONE NUMBER",
                    "EMAIL",
                    "ADDRESS",
                    "DOB",
                    "SEX",
                    "SALARY",
                    "EGENCY");
            for (employee emp : this) {
                System.out.println(emp);
            }
            System.out.println("Total: " + this.size() + " employee(s).");
        }
    }

    // -----------------Add new employee------------------------------------
    public void addEmployee() {
        //input data of new employee
        String newID, newFirstname, newLastname, newPhone, newEmail, newAddress, newEgency;
        Date newDOB;
        int newSex;
        double newSalary;
        boolean IDDupplicated = false;
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        SDF.setLenient(false);
        do {
            newID = Inputter.inputPattern("Enter ID (ex: 000): ", "Wrong ID format! Please re-Enter: ", "[\\d]{3}");;
            newID = newID.trim();
            IDDupplicated = isIDDupplicated(newID); // check id dupl
            if (IDDupplicated) {
                System.out.println("ID is duplicated");
            }
        } while (IDDupplicated == true);
        newFirstname = Inputter.inputNonBlankStr("Enter firstname: ");
        newLastname = Inputter.inputNonBlankStr("Enter lastname: ");
        newPhone = Inputter.inputPattern("Enter phone number (10 or 11 chu so): ", "Wrong PhoneNumber format! Please re-Enter", "[0-9]{10,11}"); //SDT 10 hoac 11 chu so
        newEmail = Inputter.inputPattern("Enter Email (hieushindeptrai@gmail.com): ", "Wrong Email format! Please re-Enter", "[a-zA-Z]\\w*(\\.\\w+)*@\\w+(\\.\\w{1,4}){1,3}");
        newAddress = Inputter.inputNonBlankStr("Enter address: ");                                                              
        newDOB = Inputter.getDate("Enter DOB(dd/MM/YYYY): ");
        newSex = Inputter.inputInt("Enter sex(1-male; 2-Female; 3-neither): ", 1, 3);
        newSalary = Inputter.inputDouble("Enter salary: ", 0, Double.MAX_VALUE);
        newEgency = Inputter.inputNonBlankStr("Enter Egency: ");

        //Create new employee
        employee emp = new employee(newID, newFirstname, newLastname, newPhone, newEmail, newAddress, newDOB, newSex, newSalary, newEgency);
        //add new Employyee to the list
        this.add(emp);
        System.out.println("Employee " + newID + " has been added");
    }

    //-----------------------ham update base on code---------------------------
    public void updateEmployee() {
        if (this.isEmpty()) //check xem list co j ko
        {
            System.err.println("Empty list! can't perform update");
        } //neu list co thi check xem id co ton tai ko
        else {
            String updateID = Inputter.inputPattern("Enter employee ID need update: ", "Wrong ID format! Please re-Enter: ", "[\\d]{3}");
            employee emp = this.search(updateID);
            if (emp == null) {
                System.err.println("Can't find employee " + updateID);
                //neu id ton tai thi update
            } else {
                System.out.println("----Employee Found!!-----");
                emp.setFirstName(Inputter.inputNonBlankStr("Enter new firstname: "));
                emp.setLastName(Inputter.inputNonBlankStr("Enter new lastname: "));
                emp.setPhone(Inputter.inputPattern("Enter new phone number (10 or 11 chu so): ", "Wrong PhoneNumber format! Please re-Enter", "[\\d]{10,11}"));
                emp.setEmail(Inputter.inputPattern("Enter new Email (hieushindeptrai@gmail.com): ", "Wrong Email format! Please re-Enter", "^[a-zA-Z][a-zA-Z0-9]+@[a-z]+(\\.[a-z]+){1,6}$"));
                emp.setAddress(Inputter.inputNonBlankStr("Enter new address: "));
                emp.setDOB(Inputter.getDate("Enter new DOB(dd/MM/YYYY): "));
                emp.setSex(Inputter.inputInt("Enter new sex(1-male; 2-Female; 3-neither): ", 1, 3));
                emp.setSalary(Inputter.inputDouble("Enter new salary: ", 0, Double.MAX_VALUE));
                emp.setEgency(Inputter.inputNonBlankStr("Enter new Egency: "));
                System.out.println("Employee " + updateID + " has been updated");
            }
        }
    }

    //---------------ham remove base on code-------------------------------
    public void removeEmployee() {
        if (this.isEmpty()) {
            System.err.println("Empty list! can't perform remove");
        } else {
            String removeID = Inputter.inputPattern("Enter employee ID need remove: ", "Wrong ID format! Please re-Enter: ", "[\\d]{3}");
            employee emp = this.search(removeID);
            if (this.search(removeID) == null) {
                System.err.println("Can't find employee " + removeID);
            } else {
                this.remove(emp);
                System.out.println("Employee " + removeID + " has been removed");
            }
        }
    }

    //-----------------------search employee by name----------------------
    public void searchByName() {
        if (this.isEmpty()) {
            System.err.println("Empty list! can't perform search");
        } else {
            int count = 0;
            ArrayList<employee> foundList = new ArrayList<>();
            String partName = Inputter.inputNonBlankStr("Enter name to search(first/last/part name): "); //phan ten de so sanh

            for (int i = 0; i < this.size(); i++) {
                String fullName = this.get(i).getFirstName() + this.get(i).getLastName(); // lay ra full name cua employee hien tai          
                if (fullName.toLowerCase().contains(partName.toLowerCase())) {
                    foundList.add(this.get(i));
                    count++;
                }
            }
            if (count > 0) {
                System.out.println("-------------------------Founded list:--------------------------");
                System.out.printf("%-10s%-20s%-15s%-20s%-30s%-20s%-15s%-10s%-15s%-30s\n",
                        "ID",
                        "FIRST NAME",
                        "LAST NAME",
                        "PHONE NUMBER",
                        "EMAIL",
                        "ADDRESS",
                        "DOB",
                        "SEX",
                        "SALARY",
                        "EGENCY");
                for (int i = 0; i < foundList.size(); i++) {
                    System.out.println(foundList.get(i));
                }
                System.out.println("Total found: " + foundList.size() + " employee(s).");
            } else {
                System.err.println("Can't Find employee");
            }
        }
    }

    //--------------------Sort by salary---------------------
    public void sortBySalary() {
        if (this.isEmpty()) {
            System.err.println("Empty List! Can't perform sort");
        } else {
            Collections.sort(this);
            System.out.println("Sort Success");
        }
    }

}
