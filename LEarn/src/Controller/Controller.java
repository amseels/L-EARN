/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javax.swing.JFrame;

/**
 *
 * @author Anas
 */
public class Controller {
    protected final MappingController mappingController;
    protected JFrame view;

    public Controller(MappingController mappingController) {
        this.mappingController = mappingController;
    }
    
    public void Show(){
        view.setVisible(true);
    };
    public void Hide(){
        view.dispose();
    };    
}
