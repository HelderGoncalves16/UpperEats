/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIandExceptions;

import java.awt.Toolkit;
import java.awt.event.WindowEvent;

/**
 *
 * @author Helder
 */
public class MenuInicial extends javax.swing.JFrame {

    /**
     * Creates new form MenuInicial
     */
    public MenuInicial() {
        initComponents();
        Repositorio.desserializar();
    }

    public void close(){
 
 WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
 Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
 
 }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotaoRegistar = new javax.swing.JButton();
        BotaoLogin = new javax.swing.JButton();
        Sair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        getContentPane().setLayout(null);

        BotaoRegistar.setBackground(java.awt.Color.darkGray);
        BotaoRegistar.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        BotaoRegistar.setForeground(java.awt.Color.white);
        BotaoRegistar.setText("Registar");
        BotaoRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoRegistarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoRegistar);
        BotaoRegistar.setBounds(320, 50, 120, 50);

        BotaoLogin.setBackground(java.awt.Color.darkGray);
        BotaoLogin.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        BotaoLogin.setForeground(java.awt.Color.white);
        BotaoLogin.setText("Login");
        BotaoLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BotaoLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoLoginActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoLogin);
        BotaoLogin.setBounds(320, 120, 120, 50);

        Sair.setBackground(java.awt.Color.darkGray);
        Sair.setFont(new java.awt.Font("Nirmala UI", 0, 14)); // NOI18N
        Sair.setForeground(java.awt.Color.white);
        Sair.setText("Sair");
        Sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SairActionPerformed(evt);
            }
        });
        getContentPane().add(Sair);
        Sair.setBounds(320, 190, 120, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/backgroundMenuInicial.jpg"))); // NOI18N
        jLabel3.setText("\n");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 500, 290);

        setSize(new java.awt.Dimension(498, 311));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void SairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SairActionPerformed
        // TODO add your handling code here:
        Repositorio.serializar();
        SairDaApp sair = new SairDaApp();
        sair.setVisible(true);
        close();
    }//GEN-LAST:event_SairActionPerformed

    private void BotaoLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoLoginActionPerformed
        // TODO add your handling code here:
        Repositorio.desserializar();
        Login logins= new Login();
        logins.setVisible(true);
        close();
    }//GEN-LAST:event_BotaoLoginActionPerformed

    private void BotaoRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoRegistarActionPerformed
        // TODO add your handling code here:
        Repositorio.desserializar();
        MenuRegistar menuRegistar = new MenuRegistar();
        menuRegistar.setVisible(true);
        close();
    }//GEN-LAST:event_BotaoRegistarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoLogin;
    private javax.swing.JButton BotaoRegistar;
    private javax.swing.JButton Sair;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
