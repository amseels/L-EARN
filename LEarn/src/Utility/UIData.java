/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Anas
 */
public class UIData {
    public static class CustomFont{
        
        private Font font;
        private float size;
        private String pathname;
        
        public CustomFont(float size, String pathname) {
            this.size = size;
            this.pathname = pathname;
            LoadFont();
        }
        private void LoadFont(){
            try{
                font = Font.createFont(Font.TRUETYPE_FONT, new File("res/" + pathname));
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(font);
            } catch (FontFormatException | IOException ex) {
                Logger.getLogger(UIData.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        public Font getFont() {
            return font.deriveFont(size);
        }
        
        public Font getFont(int size) {
            return font.deriveFont(size);
        }
        
        public String FontName(){
            return pathname;
        }
    }
    
    public static final CustomFont FONT1 = new CustomFont(32, "Roboto-Regular.ttf");
    public static final CustomFont FONT2 = new CustomFont(32, "Roboto-Thin.ttf");
    
    public static void main(String[] args) {
        System.out.println(FONT1.FontName());
        System.out.println(FONT2.FontName());
    }
}
