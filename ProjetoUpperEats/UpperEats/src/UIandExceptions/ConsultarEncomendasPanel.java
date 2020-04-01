/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UIandExceptions;

import UpperEatsClasses.Cliente;
import UpperEatsClasses.Encomenda;
import UpperEatsClasses.Motard;
import UpperEatsClasses.Refeicao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author helder
 */
public class ConsultarEncomendasPanel extends javax.swing.JPanel {

    /**
     * Creates new form ConsultarEncomendasPanel
     */
    String nomePratos;
    
    public ConsultarEncomendasPanel() {
        initComponents();
    }
    
    public void listarEncomendas(Cliente cliente){
        Repositorio.desserializar();
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        tabela.setRowCount(0);
        ArrayList<Encomenda> pesquisa = Repositorio.getInstance().pesquisarEncomendas();
        
        for(Encomenda r : pesquisa){
            if(r.getNumCliente()== cliente.getNumUtilizador()){
                
                SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                String data = formatar.format(r.getData());
                StringBuilder sb = new StringBuilder();       
                for(Refeicao re : r.getRef()){
                    nomePratos = re.getNome();
                }
         
                tabela.addRow(new Object[]{r.getNumReserva(), nomePratos, data, r.isPaga(), r.getHora(), r.getPrecoPagar(), 0,r.getEstado().name()});
            }
        }
    }
    
   public void listarEncomendasAdmin(){
        Repositorio.desserializar();
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        tabela.setRowCount(0);
        ArrayList<Encomenda> pesquisa = Repositorio.getInstance().pesquisarEncomendas();
        
        for(Encomenda r : pesquisa){
                
                SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                String data = formatar.format(r.getData());
                StringBuilder sb = new StringBuilder();       
                for(Refeicao re : r.getRef()){
                    nomePratos = re.getNome();
                }
            
                tabela.addRow(new Object[]{r.getNumReserva(), nomePratos, data, r.isPaga(), r.getHora(), r.getPrecoPagar(), r.getnMotards(),r.getEstado().name()});
            }
        
    }
   
   public void listarEncomendasMotards(Motard m){
       
        Repositorio.desserializar();
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        tabela.setRowCount(0);
        ArrayList<Encomenda> pesquisa = Repositorio.getInstance().pesquisarEncomendas();
        
        for(Encomenda r : pesquisa){
              if(r.getnMotards() == m.getNumUtilizador()){ 
                
                  SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
                String data = formatar.format(r.getData());
                StringBuilder sb = new StringBuilder();       
                for(Refeicao re : r.getRef()){
                    nomePratos = re.getNome();
                }
            
                tabela.addRow(new Object[]{r.getNumReserva(), nomePratos, data, r.isPaga(), r.getHora(), r.getPrecoPagar(), r.getnMotards(),r.getEstado().name()});
            }
        
    }
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nº Encomenda", "Nome", "Data & Hora", "Pago / Não Pago", "Hora Entrega", "Preço Total", "Motard ID", "ESTADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class, java.lang.Integer.class, java.lang.Float.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
