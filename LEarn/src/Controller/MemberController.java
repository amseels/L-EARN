/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.MappingController.StateTransition;
import Model.Membership;
import Model.Question;
import Search.LuceneManager;
import View.TBA;
import java.util.ArrayList;
import java.util.List;

/**
 * Class controller yang mengatur member page
 * @author Anas
 */
public class MemberController extends Controller{

    public MemberController(MappingController mappingController) {
        super(mappingController);
        
        int idUser = 0;
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
    
    public void SearchByCategory(String category){
        // get all Question from database by category
        List<Question> questions = new ArrayList<>();
        
        mappingController.Move(StateTransition.QuestionMember, questions);
    }
    
    public void SearchByWord(String word){
        // get all Question from database
        List<Question> questions = new ArrayList<>();
        
        LuceneManager manager = LuceneManager.getInstance();
        for(int i = 0; i < questions.size(); i++)
            manager.AddItem(questions.get(i).getContent(), i);
        
        List<Question> results = new ArrayList<>();
        if(manager.SearchResult(word)){
            List<Integer> resultId = manager.ShowResult();
            resultId.forEach((res) -> {
                results.add(questions.get(res));
            });
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
