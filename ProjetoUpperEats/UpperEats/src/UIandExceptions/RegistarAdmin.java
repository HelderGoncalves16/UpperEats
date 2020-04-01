/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIandExceptions;

import UpperEatsClasses.Admin;
import javax.swing.JOptionPane;


public class RegistarAdmin extends javax.swing.JFrame {

    
    private static Admin currentAdmin;

    
    public RegistarAdmin() {
        initComponents();
    }
    
    public void setCurrentAdmin(Admin admin){
        currentAdmin = admin;
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jTxtCC = new javax.swing.JTextField();
        jTxtTelemovel = new javax.swing.JTextField();
        jTxtMorada = new javax.swing.JTextField();
        jTxtLocalidade = new javax.swing.JTextField();
        jPassword = new javax.swing.JPasswordField();
        jVoltar = new javax.swing.JButton();
        jBRegistar = new javax.swing.JButton();
        jTxtNome = new javax.swing.JTextField();
        jTxtNif = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel7.setText("Localidade: ");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(230, 280, 75, 16);
        getContentPane().add(jTxtCC);
        jTxtCC.setBounds(320, 120, 195, 26);
        getContentPane().add(jTxtTelemovel);
        jTxtTelemovel.setBounds(320, 170, 195, 26);
        getContentPane().add(jTxtMorada);
        jTxtMorada.setBounds(320, 220, 195, 26);
        getContentPane().add(jTxtLocalidade);
        jTxtLocalidade.setBounds(320, 270, 195, 26);
        getContentPane().add(jPassword);
        jPassword.setBounds(320, 320, 195, 26);

        jVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        jVoltar.setText("Voltar");
        jVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(jVoltar);
        jVoltar.setBounds(250, 370, 120, 29);

        jBRegistar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/Registar.png"))); // NOI18N
        jBRegistar.setText("Registar");
        jBRegistar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBRegistarActionPerformed(evt);
            }
        });
        getContentPane().add(jBRegistar);
        jBRegistar.setBounds(410, 370, 120, 28);
        getContentPane().add(jTxtNome);
        jTxtNome.setBounds(320, 30, 195, 26);
        getContentPane().add(jTxtNif);
        jTxtNif.setBounds(320, 70, 195, 26);

        jLabel1.setText("Nome: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(250, 40, 45, 16);

        jLabel2.setText("Nif: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(260, 80, 27, 16);

        jLabel3.setText("Cartão de Cidadão: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(180, 130, 123, 16);

        jLabel4.setText("Telemovel:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(230, 170, 68, 16);

        jLabel5.setText("Password: ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(230, 320, 67, 16);

        jLabel6.setText("Morada: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 230, 54, 16);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/backgroundRegistarCliente.jpg"))); // NOI18N
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 0, 560, 440);

        setSize(new java.awt.Dimension(560, 460));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBRegistarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBRegistarActionPerformed
        char[] pass = jPassword.getPassword();
        String password = new String(pass);
        Admin a = new Admin(jTxtNome.getText(), Integer.parseInt(jTxtCC.getText()), Integer.parseInt(jTxtNif.getText()), Integer.parseInt(jTxtTelemovel.getText()),
            jTxtMorada.getText(), jTxtLocalidade.getText(),Repositorio.getInstance().getProximoUtilizadorId(),password);


        try {
            Repositorio.desserializar();
            Repositorio.getInstance().novoAdmin(a);
            JOptionPane.showMessageDialog(null, "Admin Criado com sucesso, ID: " + Repositorio.getInstance().getProximoUtilizadorId());
            Repositorio.getInstance().proximoUtilizador();   
            Repositorio.serializar();
            MenuAdmin fa = new MenuAdmin();
            fa.setCurrentAdmin(a);
            
        } catch (UtilizadorDuplicadoException ex) {
            JOptionPane.showMessageDialog(null, "Erro! Utilizador já existente");
        }

    }//GEN-LAST:event_jBRegistarActionPerformed

    private void jVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVoltarActionPerformed
        // TODO add your handling code here:
        MenuAdmin fa = new MenuAdmin();
        fa.setVisible(true);
        this.setVisible(false);
        fa.setCurrentAdmin(currentAdmin);
        fa.executar();  
    }//GEN-LAST:event_jVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(RegistarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistarAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBRegistar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTxtCC;
    private javax.swing.JTextField jTxtLocalidade;
    private javax.swing.JTextField jTxtMorada;
    private javax.swing.JTextField jTxtNif;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtTelemovel;
    private javax.swing.JButton jVoltar;
    // End of variables declaration//GEN-END:variables
}
