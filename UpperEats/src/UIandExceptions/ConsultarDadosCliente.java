/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIandExceptions;

import javax.swing.JOptionPane;
import UpperEatsClasses.*;


public class ConsultarDadosCliente extends javax.swing.JPanel {

    
    private static Cliente currentCliente;
   
    public ConsultarDadosCliente() {
        initComponents();
    }
    
     public void setCurrentCliente(Cliente cliente){
        currentCliente = cliente;
    }
    
     public void executar(Cliente cliente){
        
       try {
            Repositorio.desserializar();
            Repositorio.getInstance().consultaDadosCliente(cliente.getNumUtilizador(), cliente);
            jTxtNome.setText(cliente.getNome());
            jTxtNif.setText(Integer.toString(cliente.getNif()));
            jTxtCC.setText(Integer.toString(cliente.getnCC()));
            jTxtMorada.setText(cliente.getMorada());
            jTxtLocalidade.setText(cliente.getLocalidade());
            jTxtTelemovel.setText(Integer.toString(cliente.getTele()));
            Repositorio.serializar();
        } catch (UtilizadorInexistenteException ex) {
            JOptionPane.showMessageDialog(null, "Erro!! Utilizador inexistente");
        } catch (AcessoRecusadoException ex) {
            JOptionPane.showMessageDialog(null, "Erro!! Acesso recusado");
        }
               
    }
     
     public void executarDono(DonoRestaurante dono){
        
       try {
            Repositorio.desserializar();
            Repositorio.getInstance().consultaDadosDonoRestaurante(dono.getNumUtilizador(), dono);
            jTxtNome.setText(dono.getNome());
            jTxtNif.setText(Integer.toString(dono.getNif()));
            jTxtCC.setText(Integer.toString(dono.getnCC()));
            jTxtMorada.setText(dono.getMorada());
            jTxtLocalidade.setText(dono.getLocalidade());
            jTxtTelemovel.setText(Integer.toString(dono.getTele()));
            Repositorio.serializar();
        } catch (UtilizadorInexistenteException ex) {
            JOptionPane.showMessageDialog(null, "Erro!! Utilizador inexistente");
        } catch (AcessoRecusadoException ex) {
            JOptionPane.showMessageDialog(null, "Erro!! Acesso recusado");
        }
               
    }
     
     public void executarMotard(Motard motard){
        
       try {
            Repositorio.desserializar();
            Repositorio.getInstance().consultaDadosMotard(motard.getNumUtilizador(), motard);
            jTxtNome.setText(motard.getNome());
            jTxtNif.setText(Integer.toString(motard.getNif()));
            jTxtCC.setText(Integer.toString(motard.getnCC()));
            jTxtMorada.setText(motard.getMorada());
            jTxtLocalidade.setText(motard.getLocalidade());
            jTxtTelemovel.setText(Integer.toString(motard.getTele()));
            Repositorio.serializar();
        } catch (UtilizadorInexistenteException ex) {
            JOptionPane.showMessageDialog(null, "Erro!! Utilizador inexistente");
        } catch (AcessoRecusadoException ex) {
            JOptionPane.showMessageDialog(null, "Erro!! Acesso recusado");
        }
               
    }
     
    

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTxtNif = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jTxtLocalidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTxtCC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTxtTelemovel = new javax.swing.JTextField();
        jTxtNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTxtMorada = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLayout(null);

        jTxtNif.setEnabled(false);
        add(jTxtNif);
        jTxtNif.setBounds(380, 120, 220, 40);

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("NOME:");
        add(jLabel1);
        jLabel1.setBounds(230, 70, 80, 20);

        jTxtLocalidade.setEnabled(false);
        add(jTxtLocalidade);
        jTxtLocalidade.setBounds(1525, 190, 160, 26);

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("NIF:");
        add(jLabel2);
        jLabel2.setBounds(230, 130, 70, 20);

        jLabel7.setText("Localidade: ");
        add(jLabel7);
        jLabel7.setBounds(1395, 200, 75, 16);

        jTxtCC.setEnabled(false);
        add(jTxtCC);
        jTxtCC.setBounds(380, 180, 220, 40);

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Cartão de Cidadão: ");
        add(jLabel3);
        jLabel3.setBounds(230, 190, 140, 20);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("TELEMÓVEL:");
        add(jLabel4);
        jLabel4.setBounds(230, 250, 100, 20);

        jTxtTelemovel.setEnabled(false);
        jTxtTelemovel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTxtTelemovelActionPerformed(evt);
            }
        });
        add(jTxtTelemovel);
        jTxtTelemovel.setBounds(380, 240, 220, 40);

        jTxtNome.setEnabled(false);
        add(jTxtNome);
        jTxtNome.setBounds(380, 60, 220, 40);

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("MORADA:");
        add(jLabel6);
        jLabel6.setBounds(230, 310, 70, 21);

        jTxtMorada.setEnabled(false);
        add(jTxtMorada);
        jTxtMorada.setBounds(380, 300, 220, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/background.jpg"))); // NOI18N
        add(jLabel5);
        jLabel5.setBounds(-10, 0, 680, 410);
    }// </editor-fold>//GEN-END:initComponents

    private void jTxtTelemovelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTxtTelemovelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTxtTelemovelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField jTxtCC;
    private javax.swing.JTextField jTxtLocalidade;
    private javax.swing.JTextField jTxtMorada;
    private javax.swing.JTextField jTxtNif;
    private javax.swing.JTextField jTxtNome;
    private javax.swing.JTextField jTxtTelemovel;
    // End of variables declaration//GEN-END:variables
}
