/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.*;
import View.Login;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import learn.User;

/**
 *
 * @author Anas
 */
public class LoginController implements IController{
    private MappingController mappingController;
    private JFrame view;
    
    public LoginController(MappingController mappingController) {
        this.mappingController = mappingController;
        view = new Login(this);
        Show();
    }
    
    public void Login(String username, String password){       
        try {
            User user = UserConn.getUserByUsernameAndPassword(username, password);
            mappingController.Move(user);
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void Show() {
        view.show();
    }

    @Override
    public void Hide() {
        view.hide();
        view.dispose();
    }
}
