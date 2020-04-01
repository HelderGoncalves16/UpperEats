/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpperEatsClasses;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author helder
 */
public class Restaurante implements Serializable{

    private int codRestaurante;
    private String nomeRestaurante;
    private String nTelefone;
    private String morada;
    private String tipoCozinha;
    private DonoRestaurante dono; 
    private String localidade;
    
    //Coleção Map que liga o numeroId das Reservas à respetiva Encomenda
    private HashMap<Integer, Encomenda> encomendas;
    
    private HashMap<Integer, Refeicao> refeicoes;

    public Restaurante(int codRestaurante, String nomeRestaurante, String morada, String tipocozinha, DonoRestaurante dono, String nTelefone, String localidade){
        this.codRestaurante = codRestaurante;
        this.morada = morada;
        this.dono = dono;
        this.nTelefone = nTelefone;
        this.tipoCozinha = tipocozinha;
        this.nomeRestaurante = nomeRestaurante;
        this.localidade = localidade;
        this.encomendas = new HashMap<>();
        this.refeicoes = new HashMap<>();
    }
    
    public Restaurante(){
        this.codRestaurante = 0;
        this.morada = null;
        this.nTelefone = null;
        this.nomeRestaurante = null;
        this.tipoCozinha = null;
    }
   
    public boolean existeEncomenda(LocalDate data,int hora) {
        
              Iterator iter = encomendas.entrySet().iterator();
        
        while(iter.hasNext()){
            Map.Entry pair = (Map.Entry)iter.next();
            Encomenda enc = (Encomenda)pair.getValue();
            if(enc.getData().equals(data) && enc.getHora() == hora){ 
                return true;
            }
        }
        return false;
        
    }

    public int getCodRestaurante() {
        return codRestaurante;
    }

    
    //Adicionar nova encomenda
    public void novaEncomenda(Encomenda enc){
        this.encomendas.put(enc.getNumReserva(), enc);
    }
     
    public String getNomeRestaurante() {
        return nomeRestaurante;
    }

    public void setNomeRestaurante(String nomeRestaurante) {
        this.nomeRestaurante = nomeRestaurante;
    }
    
    public String getnTelefone() {
        return nTelefone;
    }

    public void setnTelefone(String nTelefone) {
        this.nTelefone = nTelefone;
    }

    public String getTipoCozinha() {
        return tipoCozinha;
    }

    public void setTipoCozinha(String tipoCozinha) {
        this.tipoCozinha = tipoCozinha;
    }
    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public DonoRestaurante getDono() {
        return dono;
    }

    public void setDono(DonoRestaurante dono) {
        this.dono = dono;
    }

    public HashMap<Integer, Encomenda> getEncomendas() {
        return encomendas;
    }

    public void setEncomendas(HashMap<Integer, Encomenda> encomendas) {
        this.encomendas = encomendas;
    }

    public HashMap<Integer, Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(HashMap<Integer, Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
    
    
}
