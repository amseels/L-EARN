/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Question;
import Model.User;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Class controller yang mengatur perpindahan antar controller
 * @author Anas
 */
public class MappingController {

    private List<Question> questions;

    /**
     * Constructor dari kelas mapping controller
     */
    public MappingController() {
        this.activeController = new LoginController(this);
        activeController.Show();
    }
    
    public MappingController(boolean usedGui){
        this.activeController = new LoginController(this);
        
        if(usedGui)
            activeController.Show();
        else
            activeController.Hide();
    }
    
    private StateTransition currentState = StateTransition.Login;

    public void setCurrentState(StateTransition currentState) {
        this.currentState = currentState;
    }

    public StateTransition getCurrentState() {
        return currentState;
    }
    
    public enum StateTransition 
    {
        Login,
        SignUpTutor,
        SignUpMember,
        LandpageMember,
        ProfileMember,
        PostQuestionMember,
        SearchResult,
        QuestionHistory,
        QuestionMember,
        LandpageTutor,
        QuestionTutor,
        Withdrawal,
        WithdrawalHistory,
        ProfileTutor,
        LandpageAdmin,
        Quit
    }

    
    public class Transition{

        public Transition(StateTransition current, StateTransition next) {
            this.current = current;
            this.next = next;
        }
        public StateTransition current;
        public StateTransition next; 
    }
    
   private List<Transition> transitions = new ArrayList<Transition>
        (Arrays.asList
        (
                new Transition(StateTransition.Login, StateTransition.SignUpMember),
                new Transition(StateTransition.Login, StateTransition.SignUpTutor),
                new Transition(StateTransition.Login, StateTransition.LandpageAdmin),
                new Transition(StateTransition.Login, StateTransition.LandpageMember),
                new Transition(StateTransition.Login, StateTransition.LandpageTutor),
                new Transition(StateTransition.SignUpMember, StateTransition.LandpageMember),
                new Transition(StateTransition.SignUpTutor, StateTransition.Login)
        )
        );
    
    private User user;
    private Controller activeController;
    
    public User GetCurrentUser(){
        return user;
    }
    
    public void Move(StateTransition state, User user){
        switch(currentState){
            case Login:
                this.user = user;
                break;
            case ProfileMember:
                this.user = user;
                break;
            case ProfileTutor:
                this.user = user;
                break;
            case SignUpMember:
                this.user = user;
                break;
            default:
                
        }
        Move(state);
    }
    
    public void Move(StateTransition state, List<Question> questions){
        this.questions = questions;
        Move(state);
    }
    
    /**
     * method yang berfungsi untuk melakukan perpindahan controller
     * @param transition : State Transition yang dituju
     */
    public void Move(StateTransition state){
        if(state == StateTransition.Quit){
            currentState = StateTransition.Login;
            this.user = null;
            Point loc = activeController.Hide();
            activeController = new LoginController(this);
            activeController.Show(loc);
            return;
        }
        
        boolean isValid = false;
        for(Transition transition : transitions){
            isValid = transition.current == currentState && transition.next == state;
            if(isValid){
                isValid = true;
                currentState = state;
                break;
            }
        }
        
        if(!isValid)
            return;
        
        Controller last = activeController;
        
        switch(currentState){
            case SignUpTutor:
                activeController = new SignUpController(this, false);
                break;
            case SignUpMember:
                activeController = new SignUpController(this, true);
                break;
            case LandpageMember:
                activeController = new MemberController(this);
                break;
            case ProfileMember:
                break;
            case PostQuestionMember:
                activeController = new PostQuestionController(this);
                break;
            case SearchResult:
                break;
            case QuestionHistory:
                break;
            case QuestionMember:
                break;
            case LandpageTutor:
                activeController = new TutorController(this);
                break;
            case WithdrawalHistory:
                break;
            case ProfileTutor:
                break;
            case LandpageAdmin:
                break;
            case Login:
                activeController = new LoginController(this);
                break;
            case Quit:
                break;
            case QuestionTutor:
                break;
            case Withdrawal:
                break;
            default:
                throw new AssertionError(currentState.name());

        }
        
        Point loc = last.Hide();
        activeController.Show(loc);
    }
}
