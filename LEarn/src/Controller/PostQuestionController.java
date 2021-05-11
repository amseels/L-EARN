/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.MappingController.StateTransition;
import View.*;

/**
 *
 * @author Anas
 */
public class PostQuestionController extends Controller{
    
    public PostQuestionController(MappingController mappingController) {
        super(mappingController);
        super.view = new TBA();
    }
    
    public void PostQuestion(String question){
        // post quetion to database
        
        // back to homepage
        BackToLandpage();
    }
    
    public void BackToLandpage(){
        mappingController.Move(StateTransition.LandpageMember);
    }
}
