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
import View.*;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
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
            super.view = new LandpageMember(this);
        }else{
            // Subscription Plan page
            super.view = new Pembayaran(this);
        }
    }

    private boolean AuthenticationMember(int id){
        // Get Membership from database
        Membership member = null;
        try {
            member = MembershipConn.getMembershipByDate(id);
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return member != null;
    }
    
    public void PostMemberSubscription(String subs, InputStream paymentFile){
        List<String> subsType = Arrays.asList("Santai", "Ngambis", "Langganan");
        
        int subsid = subsType.indexOf(subs) + 1;
        try {
            Membership member = new Membership();
            member.payment_proof = paymentFile;
            int uid = mappingController.GetCurrentUser().getUserId();
            
            MembershipConn.postMembership(member, subsid, uid);
        } catch (Exception ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void SearchByCategory(String category){
        // get all Question from database by category
        List<Question> questions = new ArrayList<>();
        
        try {
            questions = QuestionConn.getAllQuestionsByCategory(category);
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
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
    
    public void Home(){
        mappingController.Move(StateTransition.LandpageMember);
    }
    
    public void PostQuestion(){
        mappingController.Move(StateTransition.PostQuestionMember);
    }
    
    public void ProfileMember(){
        mappingController.Move(StateTransition.ProfileMember);
    }
    
    public void Logout(){
        mappingController.Move(StateTransition.Quit);
    }
}
