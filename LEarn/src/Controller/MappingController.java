/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Class controller yang mengatur perpindahan antar controller
 * @author Anas
 */
public class MappingController {

    /**
     * Constructor dari kelas mapping controller
     */
    public MappingController() {
        this.activeController = new LoginController(this);
        activeController.Show();
    }
    
    private StateTransition currentState = StateTransition.Login;
    
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
        QeustionTutor,
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
                new Transition(StateTransition.SignUpTutor, StateTransition.Login),
                new Transition(StateTransition.SignUpMember, StateTransition.Login),
                new Transition(StateTransition.Login, StateTransition.LandpageMember),
                new Transition(StateTransition.Login, StateTransition.LandpageTutor),
                new Transition(StateTransition.Login, StateTransition.LandpageAdmin)
        )
        );
    
    private User user;
    private Controller activeController;
    
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
            default:
                
        }
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
            activeController.Hide();
            activeController = new LoginController(this);
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
                break;
            case SignUpMember:
                break;
            case LandpageMember:
                activeController = new MemberController(this);
                break;
            case ProfileMember:
                break;
            case PostQuestionMember:
                break;
            case SearchResult:
                break;
            case QuestionHistory:
                break;
            case QuestionMember:
                break;
            case LandpageTutor:
                break;
            case QeustionTutor:
                break;
            case WithdrawalHistory:
                break;
            case ProfileTutor:
                break;
            case LandpageAdmin:
                break;
            default:
                throw new AssertionError(currentState.name());

        }
        
        last.Hide();
        activeController.Show();
    }
}
