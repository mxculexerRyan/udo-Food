package Controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mxculexer
 */
public class FoodFXMLController implements Initializable {

    @FXML
    private Label lbDisplayText;
    @FXML
    private Label lbPageLabel;
    @FXML
    private Label lbBill;
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;
    
    public void switchToScene1(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../MainFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        
    }
    @FXML
    public void switchToScene2(ActionEvent event) throws IOException{
        root = FXMLLoader.load(getClass().getResource("../LoginFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        
    }
    String name;
    public void displayName(String uname){
        name = uname;
        lbPageLabel.setText(name + "'s Acc");
    }
    

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
    String u_id;
    String bill;

    @FXML
    private void btnPizzaClicked(ActionEvent event) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT ID FROM users where username=?");
                pst.setString(1, name);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    u_id = rs.getString(1);
                    pst = con.prepareStatement("INSERT INTO orders (userr_id, item, price) VALUES (?,?,?) ");
                    pst.setString(1, u_id);
                    pst.setString(2, "Pizza");
                    pst.setString(3, "20000");
                    int status  = pst.executeUpdate();
                    
                    if(status == 1){
                        JOptionPane.showMessageDialog(null, "Your Order Process Will be Available Shortly");
                        lbDisplayText.setText("Hello "+ name +" Pizza Comming Right Up");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Your Order Was not Processed");
                    }
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to Process your order");
                        lbDisplayText.setText("Please Login First to Order Meal");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }

    @FXML
    private void btnPilauClicked(ActionEvent event) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT ID FROM users where username=?");
                pst.setString(1, name);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    u_id = rs.getString(1);
                    pst = con.prepareStatement("INSERT INTO orders (userr_id, item, price) VALUES (?,?,?) ");
                    pst.setString(1, u_id);
                    pst.setString(2, "Pilau");
                    pst.setString(3, "5000");
                    int status  = pst.executeUpdate();
                    
                    if(status == 1){
                        JOptionPane.showMessageDialog(null, "Your Order Process Will be Available Shortly");
                            lbDisplayText.setText("");
                            lbDisplayText.setText("Hello "+ name +" Pilau Comming Right Up");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Your Order Was not Processed");
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to Process your order");
                        lbDisplayText.setText("Please Login First to Order Meal");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btnChickenClicked(ActionEvent event) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT ID FROM users where username=?");
                pst.setString(1, name);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    u_id = rs.getString(1);
                    pst = con.prepareStatement("INSERT INTO orders (userr_id, item, price) VALUES (?,?,?) ");
                    pst.setString(1, u_id);
                    pst.setString(2, "Chicken");
                    pst.setString(3, "15000");
                    int status  = pst.executeUpdate();
                    
                    if(status == 1){
                        JOptionPane.showMessageDialog(null, "Your Order Process Will be Available Shortly");
                            lbDisplayText.setText("");
                            lbDisplayText.setText("Hello "+ name +" Chicken Comming Right Up");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Your Order Was not Processed");
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to Process your order");
                    lbDisplayText.setText("Please Login First to Order Meal");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btnBurgerClicked(ActionEvent event) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT ID FROM users where username=?");
                pst.setString(1, name);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    u_id = rs.getString(1);
                    pst = con.prepareStatement("INSERT INTO orders (userr_id, item, price) VALUES (?,?,?) ");
                    pst.setString(1, u_id);
                    pst.setString(2, "Burger");
                    pst.setString(3, "7000");
                    int status  = pst.executeUpdate();
                    
                    if(status == 1){
                        JOptionPane.showMessageDialog(null, "Your Order Process Will be Available Shortly");
                            lbDisplayText.setText("");
                            lbDisplayText.setText("Hello "+ name +" Burger Comming Right Up");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Your Order Was not Processed");
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to Process your order");
                    lbDisplayText.setText("Please Login First to Order Meal");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btnFishClicked(ActionEvent event) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT ID FROM users where username=?");
                pst.setString(1, name);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    u_id = rs.getString(1);
                    pst = con.prepareStatement("INSERT INTO orders (userr_id, item, price) VALUES (?,?,?) ");
                    pst.setString(1, u_id);
                    pst.setString(2, "Fish");
                    pst.setString(3, "10000");
                    int status  = pst.executeUpdate();
                    
                    if(status == 1){
                        JOptionPane.showMessageDialog(null, "Your Order Process Will be Available Shortly");
                            lbDisplayText.setText("");
                            lbDisplayText.setText("Hello "+ name +" Fish Comming Right Up");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Your Order Was not Processed");
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to Process your order");                        
                    lbDisplayText.setText("Please Login First to Order Meal");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btnOctopusClicked(ActionEvent event) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT ID FROM users where username=?");
                pst.setString(1, name);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    u_id = rs.getString(1);
                    pst = con.prepareStatement("INSERT INTO orders (userr_id, item, price) VALUES (?,?,?) ");
                    pst.setString(1, u_id);
                    pst.setString(2, "Octopus");
                    pst.setString(3, "8000");
                    int status  = pst.executeUpdate();
                    
                    if(status == 1){
                        JOptionPane.showMessageDialog(null, "Your Order Process Will be Available Shortly");
                            lbDisplayText.setText("");
                            lbDisplayText.setText("Hello "+ name +" Octopus Comming Right Up");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Your Order Was not Processed");
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to Process your order");                        
                    lbDisplayText.setText("Please Login First to Order Meal");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btnBananaClicked(ActionEvent event) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT ID FROM users where username=?");
                pst.setString(1, name);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    u_id = rs.getString(1);
                    pst = con.prepareStatement("INSERT INTO orders (userr_id, item, price) VALUES (?,?,?) ");
                    pst.setString(1, u_id);
                    pst.setString(2, "Banana");
                    pst.setString(3, "12000");
                    int status  = pst.executeUpdate();
                    
                    if(status == 1){
                        JOptionPane.showMessageDialog(null, "Your Order Process Will be Available Shortly");
                            lbDisplayText.setText("");
                            lbDisplayText.setText("Hello "+ name +" Banana Comming Right Up");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Your Order Was not Processed");
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to Process your order");
                    lbDisplayText.setText("Please Login First to Order Meal");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btnWaliBeanCicked(ActionEvent event) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT ID FROM users where username=?");
                pst.setString(1, name);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    u_id = rs.getString(1);
                    pst = con.prepareStatement("INSERT INTO orders (userr_id, item, price) VALUES (?,?,?) ");
                    pst.setString(1, u_id);
                    pst.setString(2, "Wali Maharage");
                    pst.setString(3, "1000");
                    int status  = pst.executeUpdate();
                    
                    if(status == 1){
                        JOptionPane.showMessageDialog(null, "Your Order Process Will be Available Shortly");
                            lbDisplayText.setText("");
                            lbDisplayText.setText("Hello "+ name +" Wali Maharage Comming Right Up");
                        
                    }else{
                        JOptionPane.showMessageDialog(null, "Your Order Was not Processed");
                    }
                    
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Failed to Process your order");
                    lbDisplayText.setText("Please Login First to Order Meal");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    @FXML
    private void btnLogOutClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../LoginFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

    @FXML
    private void btnGenerateBill(ActionEvent event) {
        try {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/udo_food", "root", "");
                pst = con.prepareStatement("SELECT ID FROM users where username=?");
                pst.setString(1, name);
                rs = pst.executeQuery();
                
                if(rs.next()){
                    u_id = rs.getString(1);
                    pst = con.prepareStatement("SELECT SUM(price) FROM orders WHERE (userr_id=? && Status=?) ");
                    pst.setString(1, u_id);
                    pst.setString(2, "Unpaid");
                    rs = pst.executeQuery();
                    
                    if(rs.next()){
                        bill = rs.getString(1);
                        JOptionPane.showMessageDialog(null, "Your Bill is being Processed and Will be Available Shortly");
                            lbBill.setText("");
                            lbBill.setText("Hello "+ name +" You have a "+ bill +" Tsh: Pending Bill");
                    }
                    
                    
                }else{
                    lbBill.setText("");
                    lbBill.setText("Hello Guest You have no pending Bill yet");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

//    @FXML
//    private void btnHomeClicked(ActionEvent event) {
//    }
//
//    @FXML
//    private void btnPayBillsClicked(ActionEvent event) {
//    }
    
}
    
