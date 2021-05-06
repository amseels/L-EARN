/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.TBA;
import Model.User;

/**
 *  Class controller yang mengatur perpindahan antar controller
 * @author Anas
 */
public class MappingController {

    /**
     * Constructor dari kelas mapping controller
     */
    public MappingController() {
        this.activeController = new LoginController(this);
    }
    
    private User user;
    private IController activeController;
    
    /**
     * method yang berfungsi untuk melakukan perpindahan controller
     * @param user : user yang telah login
     */
    public void Move(User user){
        
        this.user = user;
        if("admin".equals(user.getRole())){
            activeController.Hide();
            activeController = new AdminController();
            TBA tmp = new TBA();
            tmp.show();
        }
        if("member".equals(user.getRole())){
            activeController.Hide();
            activeController = new MemberController();
            TBA tmp = new TBA();
            tmp.show();
        }
        if("tutor".equals(user.getRole())){
            activeController.Hide();
            activeController = new MentorController();
            TBA tmp = new TBA();
            tmp.show();
        }
    }
}
