package Controller;

import Model.employee;
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

    public ArrayList<employee> searchName(String sName) {
        ArrayList<employee> foundList = new ArrayList<>();

        for (int i = 0; i < this.size(); i++) {
            String fullName = this.get(i).getFirstName() + this.get(i).getLastName(); // lay ra full name cua employee hien tai          
            if (fullName.toLowerCase().contains(sName.toLowerCase())) {
                foundList.add(this.get(i));
            }
        }
        return foundList;
    }

    //---------------Ham get List------------------------
//    public ArrayList<employee> getList(){
//        return this;
//    }
    // -----------------Add new employee------------------------------------
    public void addEmployee(String newID, String newFirstname, String newLastname, String newPhone, String newEmail, String newAddress, Date newDOB, int newSex, double newSalary, String newEgency) {
        this.add(new employee(newID, newFirstname, newLastname, newPhone, newEmail, newAddress, newDOB, newSex, newSalary, newEgency));
    }

    //-----------------------ham update base on code---------------------------
    public void updateEmployee(int index, String newID, String newFirstname, String newLastname, String newPhone, String newEmail, String newAddress, Date newDOB, int newSex, double newSalary, String newEgency) throws Exception {
        this.set(index, new employee(newID, newFirstname, newLastname, newPhone, newEmail, newAddress, newDOB, newSex, newSalary, newEgency));
    }

    //---------------ham remove base on code-------------------------------
    public void removeEmployee(String ID) {
        this.remove(search(ID));
    }

    //--------------------Sort by ralary---------------------
    public void sort() {
        Collections.sort(this);
    }

}
