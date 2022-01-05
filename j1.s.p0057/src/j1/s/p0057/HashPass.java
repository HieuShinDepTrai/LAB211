/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.p0057;

import java.security.MessageDigest;

/**
 *
 * @author lanh0
 */
public class HashPass {
    // MD5 hashing technique
    protected String gethassPass(String password){
        String encrytedpassword = null; 
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i]&0xff)+0x100,16).substring(1));
                // 0x100: là 256 số thập phân đặt bit thứ 9 thành 1
            }
            encrytedpassword = s.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrytedpassword;
    }
}
