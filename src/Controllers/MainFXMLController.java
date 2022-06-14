package Controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mxculexer
 */
public class MainFXMLController implements Initializable {

    private TextField tfFName;
    private TextField tfLName;
    private Label lbEmsg;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField tfUserName;
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void btnOkClicked(ActionEvent event) {
        String firstname = tfFName.getText();
        String lastName = tfLName.getText();
        lbEmsg.setText("Wecome "+ firstname +" "+ lastName);
    }

    private void btnClearClicked(ActionEvent event) {
        tfFName.setText("");
        tfLName.setText("");    
        lbEmsg.setText("");
    }

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String role;
    
    
    @FXML
    private void btnlogInClicked(ActionEvent event) throws IOException {
        String uname = tfUserName.getText();
        String passwd = pfPassword.getText();
        
        if(uname.equals("") || passwd.equals("")){
            JOptionPane.showMessageDialog(null, "Please Enter Username And Password");
        }else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT * FROM users where username=? && password=? ");
                pst.setString(1, uname);
                pst.setString(2, passwd);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    pst = con.prepareStatement("SELECT Role FROM users WHERE username=?");
                    pst.setString(1, uname);
                    rs = pst.executeQuery();
                    if(rs.next()){
                        role = rs.getString(1);
                        if(role.equals("Guest")){
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("../FoodFXML.fxml"));
                            root = loader.load();
                            FoodFXMLController foodFXMLControler = loader.getController();
                            foodFXMLControler.displayName(uname);
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        }else if(role.equals("Admin")){
                            
                            root = FXMLLoader.load(getClass().getResource("../AdminFXML.fxml"));
                            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                            scene = new Scene(root);
                            stage.setScene(scene);
                            stage.show();
                        }
                    }
                    
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Incorect UserName OR password");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnSignup(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../SignupFXML.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
    
}
