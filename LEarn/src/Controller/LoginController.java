/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.Conn;
import javax.swing.JFrame;

/**
 *
 * @author Anas
 */
public class LoginController implements IController{
    private MappingController mappingController;
    private JFrame view;
    
    public LoginController(MappingController mappingController) {
        this.mappingController = mappingController;
        Show();
    }
    
    public void Login(String username, String password){
                
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
