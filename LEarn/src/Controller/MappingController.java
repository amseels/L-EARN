/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import learn.User;

/**
 *
 * @author Anas
 */
public class MappingController {

    public MappingController() {
        this.activeController = new LoginController(this);
    }
    
    private User user;
    private IController activeController;
    
    enum Role{
        Admin,
        Member,
        Tutor
    }
    public void Move(User user){
        
        this.user = user;
        if("admin".equals(user.getRole())){
            activeController.Hide();
            activeController = new AdminController();
        }
        if("member".equals(user.getRole())){
            activeController.Hide();
            activeController = new MemberController();
        }
        if("tutor".equals(user.getRole())){
            activeController.Hide();
            activeController = new MentorController();
        }
    }
}
