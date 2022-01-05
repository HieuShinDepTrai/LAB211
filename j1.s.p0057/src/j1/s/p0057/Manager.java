/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lanh0
 */
public class Manager {

    File file = new File("D:\\DATA\\FPT\\FPT ki 3\\LAB211\\j1.s.p0057\\src\\j1\\s\\p0057\\user.dat");
    List<User> listUser = new ArrayList<>();

    public Manager() {
        readFile();
    }

    public static int menu() {
        System.out.println("1. Create new account");
        System.out.println("2. Login system");
        System.out.println("3. Exit");
        int number = CheckValidation.checkRange("> Choose: ", 1, 3);
        return number;
    }

    public void readFile() {
        if (!file.exists()) {
            return;
        }
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().equals("")) {
                    String account[] = line.split("\\|");
                    listUser.add(new User(account[0], account[1]));
                }
            }
            br.close();
            fileReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File doesn't exits!.");
        } catch (IOException ex) {
            System.out.println("File wrong");
        }
    }

    public void createAccount() {
        String data[] = inputAccount();
        User user = new User(data[0], data[1]);
        listUser.add(user);
        addAccountToFile(user);
        System.out.println("Create successful!");
    }

    public void login() {
        String username;
        String password;
        while (true) {
            username = CheckValidation.checkString("Enter Username: ", "\\S{5,}", "Username must be at least 5 characters and no spaces");
            if (checkAccount(username) == null) {
                System.out.println("Username does not exist!");
            } else {
            break;
            }
        }
        while (true) {
            password = CheckValidation.checkString("Enter Password: ", "\\S[A-Za-z\\d@$!%*#?&]{8,}", "Password must be at least 8 characters and no spaces, including special characters");
            HashPass hashPass = new HashPass();
            if (hashPass.gethassPass(password).equals(checkAccount(username))) {
                System.out.println("LOGIN SUCCESS!");
                break;
            } else {
                System.out.println("Password wrong!");
            }
        }
    }

    public String[] inputAccount() {
        String username;
        while (true) {
            username = CheckValidation.checkString("Enter Username: ", "\\S{5,}", "Username must be at least 5 characters and no spaces");
            if (checkAccount(username) != null) {
                System.out.println("This username exist");
            } else {
                break;
            }
        }
        String password = CheckValidation.checkString("Enter Password", "\\S[A-Za-z\\d@$!%*#?&]{8,}", "Password must be at least 8 characters and no spaces, including special characters.");
        return new String[]{username, password};
    }

    public String checkAccount(String username) {
        for (User user : listUser) {
            if (username.equalsIgnoreCase(user.getUsername())) {
                return user.getPassword();
            }
        }
        return null;
    }

    private void addAccountToFile(User user) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));
            bw.write(user.toString());
            bw.newLine();
            bw.close();
        } catch (Exception e) {
            System.out.println("Cannt write file!");
        }
    }

}
