package Controllers;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * FXML Controller class
 *
 * @author mxculexer
 */


public class AdminFXMLController implements Initializable {

    @FXML
    private TableView<ModelTable> table;
    @FXML
    private TableColumn<ModelTable, String> col_id;
    @FXML
    private TableColumn<ModelTable, String> col_uname;
    @FXML
    private TableColumn<ModelTable, String> col_passwd;
    
    @FXML
    private TableColumn<ModelTable, String> col_status;
    @FXML
    private TableColumn<ModelTable, String> col_role;
    
    ObservableList<ModelTable> oblist = FXCollections.observableArrayList();
    
    
    private Stage stage;
    private Scene scene;
    private Parent root;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            Connection con = DbConnector.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users");
            
            while(rs.next()){
                oblist.add(new ModelTable(rs.getString("id"), rs.getString("username"), rs.getString("password"), rs.getString("status"), rs.getString("Role")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
            col_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
            col_uname.setCellValueFactory(new PropertyValueFactory<>("uname"));
            col_passwd.setCellValueFactory(new PropertyValueFactory<>("passwd"));
            col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
            col_role.setCellValueFactory(new PropertyValueFactory<>("role"));
            table.setItems(oblist);
    }    

    @FXML
    private void btnlogoutClicked(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("../LoginFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }
    
}
