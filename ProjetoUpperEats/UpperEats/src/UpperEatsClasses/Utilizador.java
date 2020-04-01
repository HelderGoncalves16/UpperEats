/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpperEatsClasses;

import java.io.Serializable;


public abstract class Utilizador implements Serializable{
    private String nome;
    private int nCC;
    private int nif;
    private int tele;
    private String morada;
    private String localidade;
    private int numUtilizador;
    private String password;
    
    public Utilizador(String nome, int nCC, int nif, int tele, String morada, String localidade, int numUtilizador, String password){
        this.nome = nome;
        this.nCC = nCC;
        this.nif = nif;
        this.tele = tele;
        this.morada = morada;
        this.localidade = localidade;
        this.numUtilizador = numUtilizador;
        this.password = password;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getnCC() {
        return nCC;
    }

    public void setnCC(int nCC) {
        this.nCC = nCC;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public int getTele() {
        return tele;
    }

    public void setTele(int tele) {
        this.tele = tele;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getNumUtilizador(){
        return numUtilizador;
    }
    
    @Override
    public String toString(){
        return "(" + this.localidade + "," + this.morada + "," + this.nome + "," + this.password + "," + this.nCC + "," + this.nif + "," + this.numUtilizador + "," + this.tele + ")" ;
    }
}
