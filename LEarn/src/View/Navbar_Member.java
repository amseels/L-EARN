/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class Navbar_Member extends javax.swing.JFrame {

    /**
     * Creates new form DetailQuestion
     */
    public Navbar_Member() {
        initComponents();
        Panel_Menu_Profil.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Panel_Menu_Profil = new javax.swing.JPanel();
        B_Profil = new javax.swing.JButton();
        B_Logout = new javax.swing.JButton();
        Label_Username = new javax.swing.JLabel();
        Panel_Navbar = new javax.swing.JPanel();
        B_Pertanyaanku = new javax.swing.JButton();
        B_ProfilMenu = new javax.swing.JButton();
        B_Home = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(224, 187, 218));
        jPanel1.setForeground(new java.awt.Color(224, 187, 218));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel1MouseEntered(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Panel_Menu_Profil.setBackground(new java.awt.Color(255, 248, 248));
        Panel_Menu_Profil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_Menu_ProfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Panel_Menu_ProfilMouseExited(evt);
            }
        });

        B_Profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil2_default.png"))); // NOI18N
        B_Profil.setPreferredSize(new java.awt.Dimension(153, 52));
        B_Profil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_ProfilMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_ProfilMouseExited(evt);
            }
        });
        B_Profil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ProfilActionPerformed(evt);
            }
        });

        B_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Logout_default.png"))); // NOI18N
        B_Logout.setPreferredSize(new java.awt.Dimension(153, 51));
        B_Logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_LogoutMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_LogoutMouseExited(evt);
            }
        });
        B_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_LogoutActionPerformed(evt);
            }
        });

        Label_Username.setFont(Label_Username.getFont().deriveFont(Label_Username.getFont().getSize()+7f));
        Label_Username.setText("Nuril K");

        javax.swing.GroupLayout Panel_Menu_ProfilLayout = new javax.swing.GroupLayout(Panel_Menu_Profil);
        Panel_Menu_Profil.setLayout(Panel_Menu_ProfilLayout);
        Panel_Menu_ProfilLayout.setHorizontalGroup(
            Panel_Menu_ProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_Menu_ProfilLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_Menu_ProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(B_Profil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Label_Username))
                .addContainerGap())
        );
        Panel_Menu_ProfilLayout.setVerticalGroup(
            Panel_Menu_ProfilLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_Menu_ProfilLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(Label_Username)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(B_Profil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_Logout, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(Panel_Menu_Profil, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 90, -1, -1));

        Panel_Navbar.setBackground(new java.awt.Color(224, 187, 218));
        Panel_Navbar.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        Panel_Navbar.setPreferredSize(new java.awt.Dimension(153, 108));
        Panel_Navbar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Panel_NavbarMouseEntered(evt);
            }
        });

        B_Pertanyaanku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Pertanyaanku_default.png"))); // NOI18N
        B_Pertanyaanku.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        B_Pertanyaanku.setBorderPainted(false);
        B_Pertanyaanku.setPreferredSize(new java.awt.Dimension(153, 51));
        B_Pertanyaanku.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                B_PertanyaankuFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                B_PertanyaankuFocusLost(evt);
            }
        });
        B_Pertanyaanku.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_PertanyaankuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_PertanyaankuMouseExited(evt);
            }
        });
        B_Pertanyaanku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_PertanyaankuActionPerformed(evt);
            }
        });

        B_ProfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil_default.png"))); // NOI18N
        B_ProfilMenu.setBorder(null);
        B_ProfilMenu.setPreferredSize(new java.awt.Dimension(101, 45));
        B_ProfilMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_ProfilMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_ProfilMenuMouseExited(evt);
            }
        });
        B_ProfilMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ProfilMenuActionPerformed(evt);
            }
        });

        B_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Home_default.png"))); // NOI18N
        B_Home.setBorder(null);
        B_Home.setPreferredSize(new java.awt.Dimension(101, 77));
        B_Home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                B_HomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                B_HomeMouseExited(evt);
            }
        });
        B_Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_HomeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_NavbarLayout = new javax.swing.GroupLayout(Panel_Navbar);
        Panel_Navbar.setLayout(Panel_NavbarLayout);
        Panel_NavbarLayout.setHorizontalGroup(
            Panel_NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_NavbarLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(B_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 457, Short.MAX_VALUE)
                .addComponent(B_Pertanyaanku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(B_ProfilMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );
        Panel_NavbarLayout.setVerticalGroup(
            Panel_NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_NavbarLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(Panel_NavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(B_ProfilMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Pertanyaanku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(B_Home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel1.add(Panel_Navbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_ProfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_ProfilMouseEntered
        // TODO add your handling code here:
        B_ProfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil_hover.png")));
        Panel_Menu_Profil.setVisible(true);
        B_Profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil2_hover.png")));
    }//GEN-LAST:event_B_ProfilMouseEntered

    private void B_ProfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_ProfilMouseExited
        // TODO add your handling code here:
        B_ProfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil_default.png")));
        B_Profil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil2_default.png")));
    }//GEN-LAST:event_B_ProfilMouseExited

    private void B_ProfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ProfilActionPerformed
        // TODO add your handling code here:
        controller.ProfileMember();
    }//GEN-LAST:event_B_ProfilActionPerformed

    private void B_LogoutMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_LogoutMouseEntered
        // TODO add your handling code here:
        B_ProfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil_hover.png")));
        Panel_Menu_Profil.setVisible(true);
        B_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Logout_hover.png")));
    }//GEN-LAST:event_B_LogoutMouseEntered

    private void B_LogoutMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_LogoutMouseExited
        // TODO add your handling code here:
        B_ProfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil_default.png")));
        B_Logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Logout_default.png")));
    }//GEN-LAST:event_B_LogoutMouseExited

    private void B_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_LogoutActionPerformed
        // TODO add your handling code here:
        int dialogButton = JOptionPane.showConfirmDialog (null, "Anda yakin akan keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if(dialogButton == JOptionPane.YES_OPTION) {
            controller.Logout();}
        else {remove(dialogButton);}
    }//GEN-LAST:event_B_LogoutActionPerformed

    private void Panel_Menu_ProfilMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Menu_ProfilMouseEntered
        // TODO add your handling code here:
        B_ProfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil_hover.png")));
    }//GEN-LAST:event_Panel_Menu_ProfilMouseEntered

    private void Panel_Menu_ProfilMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_Menu_ProfilMouseExited
        // TODO add your handling code here:
        B_ProfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil_default.png")));
        Panel_Menu_Profil.setVisible(false);
    }//GEN-LAST:event_Panel_Menu_ProfilMouseExited

    private void B_PertanyaankuFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B_PertanyaankuFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_B_PertanyaankuFocusGained

    private void B_PertanyaankuFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_B_PertanyaankuFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_B_PertanyaankuFocusLost

    private void B_PertanyaankuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_PertanyaankuMouseEntered
        // TODO add your handling code here:
        Panel_Menu_Profil.setVisible(false);
        B_Pertanyaanku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Pertanyaanku_hover.png")));
    }//GEN-LAST:event_B_PertanyaankuMouseEntered

    private void B_PertanyaankuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_PertanyaankuMouseExited
        // TODO add your handling code here:
        B_Pertanyaanku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Pertanyaanku_default.png")));
    }//GEN-LAST:event_B_PertanyaankuMouseExited

    private void B_PertanyaankuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_PertanyaankuActionPerformed
        // TODO add your handling code here:
        controller.ShowQuestionHistory();
    }//GEN-LAST:event_B_PertanyaankuActionPerformed

    private void B_ProfilMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_ProfilMenuMouseEntered
        // TODO add your handling code here:
        B_ProfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil_hover.png")));
        Panel_Menu_Profil.setVisible(true);
    }//GEN-LAST:event_B_ProfilMenuMouseEntered

    private void B_ProfilMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_ProfilMenuMouseExited
        // TODO add your handling code here:
        B_ProfilMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Profil_default.png")));
    }//GEN-LAST:event_B_ProfilMenuMouseExited

    private void B_ProfilMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ProfilMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_B_ProfilMenuActionPerformed

    private void B_HomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_HomeMouseEntered
        // TODO add your handling code here:
        B_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Home_hover.png")));
    }//GEN-LAST:event_B_HomeMouseEntered

    private void B_HomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_B_HomeMouseExited
        // TODO add your handling code here:
        B_Home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Icon/B_Home_default.png")));
    }//GEN-LAST:event_B_HomeMouseExited

    private void B_HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_HomeActionPerformed
        // TODO add your handling code here:
        controller.Home();
    }//GEN-LAST:event_B_HomeActionPerformed

    private void Panel_NavbarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Panel_NavbarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_Panel_NavbarMouseEntered

    private void jPanel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseEntered
        // TODO add your handling code here:
        Panel_Menu_Profil.setVisible(false);
    }//GEN-LAST:event_jPanel1MouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Navbar_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Navbar_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Navbar_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Navbar_Member.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Navbar_Member().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton B_Home;
    private javax.swing.JButton B_Logout;
    private javax.swing.JButton B_Pertanyaanku;
    private javax.swing.JButton B_Profil;
    private javax.swing.JButton B_ProfilMenu;
    private javax.swing.JLabel Label_Username;
    private javax.swing.JPanel Panel_Menu_Profil;
    private javax.swing.JPanel Panel_Navbar;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
