/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

/**
 *
 * @author lanh0
 */
public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();
        while (true) {            
            int number = manager.menu();
            switch(number){
                 case 1:
                    manager.createAccount();
                    break;
                case 2: 
                    manager.login();
                    break;
                case 3: 
                    return;
            }
        }
    }
}
