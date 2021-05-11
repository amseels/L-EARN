/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.MappingController.StateTransition;
import Model.Question;
import Search.LuceneManager;
import View.TBA;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anas
 */
public class TutorController extends Controller{
    
    public TutorController(MappingController mappingController) {
        super(mappingController);
        super.view = new TBA();
    }
    
    public void ProfileTutor(){
        mappingController.Move(StateTransition.ProfileTutor);
    }
    
    public void WithdrawalHistory(){
        mappingController.Move(StateTransition.WithdrawalHistory);
    }
    
    public void Withdrawal(){
        mappingController.Move(StateTransition.Withdrawal);
    }
    
     public void SearchByCategory(String category){
        // get all Question from database by category
        List<Question> questions = new ArrayList<>();
        
        mappingController.Move(StateTransition.QuestionTutor, questions);
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
            
        mappingController.Move(StateTransition.QuestionTutor, results);
    } 
}
