/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpperEatsClasses;

import java.io.Serializable;
/**
 *
 * @author helder
 */
public class Admin extends Utilizador implements Serializable {
   public Admin (String nome, int nCC, int nif, int tele, String morada, String localidade, int numUtilizador, String password){
       super(nome, nCC, nif, tele, morada,localidade, numUtilizador, password);    
   }
}
