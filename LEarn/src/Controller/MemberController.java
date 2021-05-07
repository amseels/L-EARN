/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.TBA;
import javax.swing.JFrame;

/**
 * Class controller yang mengatur member page
 * @author Anas
 */
public class MemberController extends Controller{

    public MemberController(MappingController mappingController) {
        super(mappingController);
        super.view = new TBA();
    }

    
}
