/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import Database.UserConn;
import View.TBA;
import java.sql.SQLException;

/**
 *
 * @author Anas
 */
public class ProfileMember extends Controller{
    
    public ProfileMember(MappingController mappingController) {
        super(mappingController);
        super.view = new TBA();
    }
    
    public void EditProfile(String password, String bio, String name) throws SQLException{
        User u = super.mappingController.GetCurrentUser();
        UserConn.updateUser(u,password,bio,name);
        
        ChangeView(null);
    }
    
    public void ToEditProfile(){
        
        ChangeView(null);
        
    }
    
    public void BackToProfile(){
        ChangeView(null);
        
    }
}
