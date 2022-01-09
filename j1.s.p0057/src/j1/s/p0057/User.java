
package j1.s.p0057;

public class User {
    private String username;
    private String password;
    private HashPass hashPass = new HashPass();
    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = hashPass.gethassPass(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = hashPass.gethassPass(password);
    }

    @Override
    public String toString() {
        return username + "|" + password ;
    }
    
    
}
