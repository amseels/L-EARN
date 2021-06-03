/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.TutorConn;
import Database.UserConn;
import Model.User;
import View.TBA;
import java.sql.SQLException;

/**
 *
 * @author Anas
 */
public class ProfileTutor extends Controller{

    public ProfileTutor(MappingController mappingController) {
        super(mappingController);
        super.view = new TBA();
    }
    
    public void EditProfile(String password, String bio, String name, String bank, String rekening, String nama_rekening) throws SQLException{
        User u = super.mappingController.GetCurrentUser();
        UserConn.updateUser(u,password,bio,name);
        TutorConn.updateTutor(u, bank, rekening, nama_rekening);
        
        ChangeView(null);
    }
    
    public void ToEditProfile(){
        ChangeView(null);
        
    }
    
    public void BackToProfile(){
        ChangeView(null);
        
    }
}
