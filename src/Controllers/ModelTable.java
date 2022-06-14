package Controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author mxculexer
 */
public class ModelTable {
    
    String Id, uname, passwd, status, role;
    
    public ModelTable(String Id, String uname, String passwd, String Status, String role){
        this.Id = Id;
        this.uname = uname;
        this.passwd = passwd;
        this.status = Status;
        this.role = role;
        
    }


    public String getId() {
        return Id;
    }

    public String getUname() {
        return uname;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getStatus() {
        return status;
    }
    
    
    public String getRole() {
        return role;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    public void setRole(String role) {
        this.role = role;
    }
    
    
}
