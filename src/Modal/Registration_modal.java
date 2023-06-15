/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modal;

/**
 *
 * @author razer
 */
public class Registration_modal {
    String Full_Name,Address,Contactno,Username,password,retype_password;

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String Full_Name) {
        this.Full_Name = Full_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContactno() {
        return Contactno;
    }

    public void setContactno(String Contactno) {
        this.Contactno = Contactno;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRetype_password() {
        return retype_password;
    }

    public void setRetype_password(String retype_password) {
        this.retype_password = retype_password;
    }
    public Registration_modal(String Full_Name, String Address,String Contactno,String Username,String password,String retype_password){
        this.Full_Name = Full_Name;
        this.Address = Address;
        this.Contactno = Contactno;
        this.Username = Username;
        this.password = password;
        this.retype_password = retype_password;
        
    }
    
}
