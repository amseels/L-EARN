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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anas
 */
public class SignUpMemberController extends Controller{
    
    public SignUpMemberController(MappingController mappingController) {
        super(mappingController);
        this.view = new Register_Member(this);
    }
    
    public boolean RegisterUser(String username, String nama, String password, String bio){
        User user = new User(password, bio, nama, username, bio);
        user.setRole("member");

        try {
            UserConn.postUser(user);
            mappingController.Move(StateTransition.LandpageMember, user);
        } catch (SQLException ex) {
            Logger.getLogger(SignUpMemberController.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }
}
