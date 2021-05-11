/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.MappingController.StateTransition;
import Database.UserConn;
import Model.User;
import View.Register_Member;
import View.Register_Tutor;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.RegularExpression;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anas
 */
public class SignUpController extends Controller{
    
    public SignUpController(MappingController mappingController, boolean member) {
        super(mappingController);
        if(member)
            this.view = new Register_Member(this);
        else
            this.view = new Register_Tutor();
    }
    
    public boolean RegisterUser(String username, String nama, String password, String bio){
        User user = new User(password, bio, nama, username, bio);
        user.setRole("member");

        try {
            UserConn.postUser(user);
            mappingController.Move(StateTransition.LandpageMember, user);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
    
    public boolean RegisterTutor(String username, String nama, String password, String bio){
        User user = new User(password, bio, nama, username, bio);
        user.setRole("tutor");

        try {
            UserConn.postUser(user);
            mappingController.Move(StateTransition.Login);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
