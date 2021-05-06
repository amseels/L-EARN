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
 * Class controller yang mengatur login dari aplikasi
 * @author Anas
 */
public class LoginController implements IController{
    private MappingController mappingController;
    private JFrame view;
    
    /**
     * Constructor dari kelas ini
     * @param mappingController : global mapping controller
     */
    public LoginController(MappingController mappingController) {
        this.mappingController = mappingController;
        view = new Login(this);
        Show();
    }
    
    /**
     * Method yang berfungsi untuk melakukan login.
     * Apabila berhasil akan berindah UI sesuai dengan tipe role dari user
     * @param username : string username
     * @param password : string password
     */
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
