/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.TBA;

/**
 *
 * @author Anas
 */
public class AdminController extends Controller{
    
    public AdminController(MappingController mappingController) {
        super(mappingController);
        super.view = new TBA();
    }
    
    public void UserVerification(){
        // get all user
        
        // show view User Verification
        
    }
    
    public void PostUserVerification(int id){
        
    }
    
    public void PaymentVerification(){
        // get all payment
        
        // show view Payment Verification
        
    }
    
    public void PostPaymentVerification(int id){
        
    }
    
    public void AnswerVerification(){
        // get all payment
        
        // show view Answer Verification
        
    }
    
    public void RemoveAnswerVerification(int id){
        
    }
}
