/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Database.AnswerConn;
import Database.QuestionConn;
import Model.*;
import View.SearchKategory;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Anas
 */
public class QuestionMemberController extends Controller{

    public String category;
    public List<Question> questions;
    
    public QuestionMemberController(MappingController mappingController) {
        super(mappingController);
        category = mappingController.category;
        questions = mappingController.questions;
        super.view = new SearchKategory(this);
        view.show();
    }

    public void ShowQuestionHistory(){
        // get all user question from database
        int uid = mappingController.GetCurrentUser().getUserId();
        List<Question> questions = null;
        try {
            questions = QuestionConn.getAllQuestions(uid);
        } catch (SQLException ex) {
            //Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        mappingController.Move(MappingController.StateTransition.QuestionHistory, questions, "");
    }

    public void Home(){
        mappingController.Move(MappingController.StateTransition.LandpageMember);
    }

    public void ProfileMember(){
        mappingController.Move(MappingController.StateTransition.ProfileMember);
    }
    
    public void Logout(){
        mappingController.Move(MappingController.StateTransition.Quit);
    }

    public void ShowAnswerQuestion(int id){
        Question question = questions.get(id);
        Answer answer = AnswerConn.getAnswerByQuestionId(question.question_id);
        
        // Show Detail Answer view
        ChangeView(null);
    }
}
