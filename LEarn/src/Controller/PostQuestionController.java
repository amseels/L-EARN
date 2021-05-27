/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.MappingController.StateTransition;
import Database.QuestionConn;
import Model.Question;
import View.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anas
 */
public class PostQuestionController extends Controller{
    
    public PostQuestionController(MappingController mappingController) {
        super(mappingController);
        super.view = new TBA();
    }
    
    public void PostQuestion(String question, String category){
        // post quetion to database
        Question questionObj = new Question(question, category);
        int uid = mappingController.GetCurrentUser().getUserId();
        try {
            QuestionConn.postQuestion(questionObj, uid);
        } catch (SQLException ex) {
            Logger.getLogger(PostQuestionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // back to homepage
        BackToLandpage();
    }
    
    public void BackToLandpage(){
        mappingController.Move(StateTransition.LandpageMember);
    }
}
