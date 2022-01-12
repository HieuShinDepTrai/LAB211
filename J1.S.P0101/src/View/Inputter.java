/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Manager;
import Controller.Utility;
import Model.employee;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 *
 * @author ACER
 */
public class Inputter {

     Manager m = new Manager();   
    
    //--------------------------ham display list--------------------------------
    public void Display(){
        if(m.isEmpty())
            System.err.println("Empty list!!!!!");
        else{
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
            for(employee emp : m)
                System.out.println(emp);
            System.out.println("Total: "+ m.size()+ " employee(s).");
        }
    }
       
    
    // -----------------Add new employee------------------------------------
    public void addEmployee() throws Exception{
        //input data of new employee
        String newID, newFirstname, newLastname, newPhone, newEmail, newAddress, newEgency;
        Date newDOB;
        int newSex;
        double newSalary;
        boolean IDDupplicated = false;
        SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        SDF.setLenient(false);
        do{
            newID = Utility.getPattern("Enter ID (ex: 000): ","Wrong ID format! Please re-Enter: ", "[\\d]{3}");;
//            newID = newID.trim();
            IDDupplicated = Utility.isIDDupplicated(newID, m); // check id dupl
            if (IDDupplicated)
                System.err.println("ID is duplicated\n");
        }
        while (IDDupplicated==true);
        newFirstname = Utility.getNonBlankStr("Enter firstname: ");
        newLastname = Utility.getNonBlankStr("Enter lastname: ");
        newPhone = Utility.getPattern("Enter phone number (10 or 11 chu so): ","Wrong PhoneNumber format! Please re-Enter: ","[\\d]{10,11}"); //SDT 10 hoac 11 chu so
        newEmail = Utility.getPattern("Enter Email (khai2002@gmail.com): ", "Wrong Email format! Please re-Enter: ", "^[a-zA-Z][a-zA-Z0-9]+@[a-z]+(\\.[a-z]+){1,6}$"); //ky tu dau p la chu
        newAddress = Utility.getNonBlankStr("Enter address: ");                                                              //duoi co the . den 6 VD .FPT.EDU.VN
        newDOB = Utility.getDate("Enter DOB(dd/MM/YYYY): ");
        newSex = Utility.getInt("Enter sex(1-male; 2-Female; 3-neither): ", 1, 3);
        newSalary = Utility.getDoublePositive("Enter salary: ","Please Enter salary >=0 : ");
        newEgency = Utility.getNonBlankStr("Enter Egency: ");
        
        //add new Employyee to the list
        m.addEmployee(newID, newFirstname, newLastname, newPhone, newEmail, newAddress, newDOB, newSex, newSalary, newEgency);
        System.out.println("Employee "+newID+ " has been added");
    }
    
    //-----------------------ham update base on code---------------------------
    public void updateEmployee() throws Exception{
        if(m.isEmpty()) //check xem list co j ko
            System.err.println("Empty list! can't perform update");
        //neu list co thi check xem id co ton tai ko
        else{
            String updateID = Utility.getPattern("Enter employee ID need update: ", "Wrong ID format! Please re-Enter: ", "[\\d]{3}");
            employee emp = m.search(updateID);
            if(emp==null){
                System.err.println("Can't find employee "+updateID);
            //neu id ton tai thi update
            }else{
                int index = m.indexOf(emp);
                String newID, newFirstname, newLastname, newPhone, newEmail, newAddress, newEgency;
                Date newDOB;
                int newSex;
                double newSalary;
                System.out.println("----Employee Found!!-----");
                newID = emp.getId(); // ko doi id
                newFirstname = Utility.getNonBlankStr("Enter new firstname: ");
                newLastname = Utility.getNonBlankStr("Enter new lastname: ");
                newPhone = Utility.getPattern("Enter new phone number (10 or 11 chu so): ","Wrong PhoneNumber format! Please re-Enter: ","[\\d]{10,11}");
                newEmail = Utility.getPattern("Enter new Email (khai2002@gmail.com): ", "Wrong Email format! Please re-Enter: ", "^[a-zA-Z][a-zA-Z0-9]+@[a-z]+(\\.[a-z]+){1,6}$");
                newAddress = Utility.getNonBlankStr("Enter new address: ");
                newDOB = Utility.getDate("Enter new DOB(dd/MM/YYYY): ");
                newSex = Utility.getInt("Enter new sex(1-male; 2-Female; 3-neither): ", 1, 3);
                newSalary = Utility.getDoublePositive("Enter new salary: ","Please Enter salary >=0 : ");
                newEgency = Utility.getNonBlankStr("Enter new Egency: ");
                m.updateEmployee(index, newID, newFirstname, newLastname, newPhone, newEmail, newAddress, newDOB, newSex, newSalary, newEgency);
                System.out.println("Employee "+ updateID + " has been updated");
                
            }
        }
    }
    
    //---------------ham remove base on code-------------------------------
    public void removeEmployee(){
        if(m.isEmpty()){
            System.err.println("Empty list! can't perform remove");
        }else{
            String removeID = Utility.getPattern("Enter employee ID need remove: ", "Wrong ID format! Please re-Enter: ", "[\\d]{3}");
            employee emp = m.search(removeID);
            if(m.search(removeID)==null){
                System.err.println("Can't find employee "+removeID);
            }else{
                m.remove(emp);
                System.out.println("Employee "+ removeID + " has been removed");
            }
        }
    }
    
    //-----------------------search employee by name----------------------
    public void searchByName(){
        if(m.isEmpty()){
            System.err.println("Empty list! can't perform search");
        }else{
            String partName = Utility.getNonBlankStr("Enter name to search(first/last/part name): "); //phan ten de so sanh
            if(m.searchName(partName).isEmpty()){
                System.err.println("Can't Find any employee");               
            }else{
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
                for(int i=0;i<m.searchName(partName).size();i++)
                    System.out.println(m.searchName(partName).get(i));
                System.out.println("Total found: "+ m.searchName(partName).size()+ " employee(s).");
            }
        }
    }
    
    //--------------------Sort by ralary---------------------
    public void sortBySalary(){
        if(m.isEmpty()){
            System.err.println("Empty List! Can't perform sort");
        }else{
            m.sort();
            System.out.println("Sort Success");
        }
    }
   
}
