/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpperEatsClasses;

import java.io.Serializable;

public class Refeicao implements Serializable {
    
    private int codRefeicao;
    private String nome;
    private float precoDose;
    private float precoMeiaDose;
    private Restaurante res;
    
    
    public Refeicao(){
        this.precoDose = 0.0f;
        this.precoMeiaDose = 0.0f;
        this.nome = null;
        this.res = null;
        this.codRefeicao = 0;
    }
    
    public Refeicao(int codRefeicao, String nome, float precoDose, float precoMeiaDose, Restaurante res){
        this.codRefeicao = codRefeicao;
        this.nome = nome;
        this.precoDose = precoDose;
        this.precoMeiaDose = precoMeiaDose;
        this.res = res;
    }

    public int getCodRefeicao() {
        return codRefeicao;
    }

    public void setCodRefeicao(int codRefeicao) {
        this.codRefeicao = codRefeicao;
    }

    public Restaurante getRes() {
        return res;
    }

    public void setRes(Restaurante res) {
        this.res = res;
    }
   
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPrecoDose() {
        return precoDose;
    }
      
    public void setPrecoDose(float precoDose) {
        this.precoDose = precoDose;
    }

    public double getPrecoMeiaDose() {
        return precoMeiaDose;
    }

    public void setPrecoMeiaDose(float precoMeiaDose) {
        this.precoMeiaDose = precoMeiaDose;
    }
    
}
