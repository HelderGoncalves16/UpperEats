/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIandExceptions;

import java.util.List;

/**
 *
 * @author helder
 */
public class ConsultarAdmin extends javax.swing.JPanel {

    /**
     * Creates new form ConsultarAdmin
     */
    
    public ConsultarAdmin() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tipoCozinha = new javax.swing.JTextArea();
        localidade = new javax.swing.JTextArea();

        setLayout(null);

        jLabel1.setText("TIPOS DE COZINHA");
        add(jLabel1);
        jLabel1.setBounds(143, 34, 121, 16);

        jLabel2.setText("LOCALIDADES");
        add(jLabel2);
        jLabel2.setBounds(148, 160, 89, 16);

        tipoCozinha.setColumns(20);
        tipoCozinha.setRows(5);
        add(tipoCozinha);
        tipoCozinha.setBounds(78, 62, 240, 80);

        localidade.setColumns(20);
        localidade.setRows(5);
        add(localidade);
        localidade.setBounds(78, 188, 240, 80);
    }// </editor-fold>//GEN-END:initComponents

    void executar(){
        Repositorio.desserializar();
        List<String> localidades = Repositorio.getInstance().getLocalidades();
        List<String> tipocozinha = Repositorio.getInstance().getTipoCozinha();
        
        for(String nome : localidades) {
            localidade.setText(nome+"\n");
        }
        for(String nome: tipocozinha){
            tipoCozinha.setText(nome+"\n");
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextArea localidade;
    private javax.swing.JTextArea tipoCozinha;
    // End of variables declaration//GEN-END:variables
}
