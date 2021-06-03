/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.MappingController.StateTransition;
import Database.MembershipConn;
import Database.QuestionConn;
import Model.Membership;
import Model.Question;
import Search.LuceneManager;
import View.TBA;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class controller yang mengatur member page
 * @author Anas
 */
public class MemberController extends Controller{

    public MemberController(MappingController mappingController) {
        super(mappingController);
        
        int idUser = mappingController.GetCurrentUser().getUserId();
        if(AuthenticationMember(idUser)){
            // Member Page
            super.view = new TBA();
        }else{
            // Subscription Plan page
            super.view = new TBA();
        }
    }

    private boolean AuthenticationMember(int id){
        // Get Membership from database
        Membership member = null;
        
        return member != null;
    }
    
    public void PostMemberSubscription(int sid){
        try {
            Membership member = new Membership();
            int uid = mappingController.GetCurrentUser().getUserId();
            
            MembershipConn.postMembership(member, Integer.toHexString(sid), Integer.toHexString(uid));
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SearchByCategory(String category){
        // get all Question from database by category
        List<Question> questions = new ArrayList<>();
        
        mappingController.Move(StateTransition.QuestionMember, questions);
    }
    
    public void SearchByWord(String word){
        // get all Question from database
        List<Question> questions = new ArrayList<>();
        
        try {
            questions = QuestionConn.getAllQuestions();
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LuceneManager manager = LuceneManager.getInstance();
        for(int i = 0; i < questions.size(); i++)
            manager.AddItem(questions.get(i).getContent(), i);
        
        List<Question> results = new ArrayList<>();
        if(manager.SearchResult(word)){
            List<Integer> resultId = manager.ShowResult();
            for(Integer id : resultId)
                results.add(questions.get(id));
        }
            
        mappingController.Move(StateTransition.QuestionMember, results);
    }
    
    public void ShowQuestionHistory(){
        // get all user question from database
        List<Question> questions = new ArrayList<>();
        
        mappingController.Move(StateTransition.QuestionHistory, questions);
    }
    
    public void PostQuestion(){
        mappingController.Move(StateTransition.PostQuestionMember);
    }
    
    public void ProfileMember(){
        mappingController.Move(StateTransition.ProfileMember);
    }
}
