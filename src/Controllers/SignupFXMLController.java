package Controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mxculexer
 */
public class SignupFXMLController implements Initializable {

    @FXML
    private TextField tfUserName;
    @FXML
    private PasswordField pfPassword;
    @FXML
    private PasswordField pfCpassword;
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

    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    @FXML
    private void btnSignupClicked(ActionEvent event) throws SQLException, IOException {
        String uname = tfUserName.getText();
        String passwd = pfPassword.getText();
        String cpasswd = pfCpassword.getText();
        
        if(uname.equals("") || passwd.equals("") || cpasswd.equals("")){
            JOptionPane.showMessageDialog(null, "Please Fill Out all Fields");
        }else{
            try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("INSERT INTO users (username, password, status) VALUES (?,?,?) ");
                pst.setString(1, uname);
                pst.setString(2, passwd);
                pst.setString(3, "Active");
                int status  = pst.executeUpdate();
                if(status == 1){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../FoodFXML.fxml"));
                    root = loader.load();
                    FoodFXMLController foodFXMLControler = loader.getController();
                    foodFXMLControler.displayName(uname);
                    stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Record Addtion Failed");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @FXML
    private void btnLoggedInClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../LoginFXML.fxml"));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
}
