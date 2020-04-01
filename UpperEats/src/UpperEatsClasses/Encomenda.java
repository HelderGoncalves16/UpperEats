/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UpperEatsClasses;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Helder
 */
public class Encomenda implements Serializable{
    
    public enum Estado{
        ENTREGUE,
        POR_ENTREGAR;
    }
    private Estado estado;
    private int numReserva;
    private int nMotards;
    private int numCliente;
    private Date data;
    private boolean paga;
    private int hora;
    private ArrayList<Refeicao> ref;
    private float precoPagar;
    
    public Encomenda(int numReserva,int numCliente, Date data, int hora, Boolean paga, ArrayList<Refeicao> ref, int nMotards, float precoPagar, Estado estado) {
        this.numReserva = numReserva;
        this.numCliente = numCliente;
        this.data = data;
        this.paga = paga;
        this.hora = hora;
        this.ref = new ArrayList<>();
        this.nMotards = nMotards;
        this.precoPagar = precoPagar;
        this.estado = estado.POR_ENTREGAR;
    }

    public float getPrecoPagar() {
        return precoPagar;
    }

    public void setPrecoPagar(float precoPagar) {
        this.precoPagar = precoPagar;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
    public int getNumReserva() {
        return numReserva;
    }

    public int getnMotards() {
        return nMotards;
    }

    
    public void setnMotards(int nMotards) {
        this.nMotards = nMotards;
    }

    public int getNumCliente() {
        return numCliente;
    }

    public void setNumCliente(int numCliente) {
        this.numCliente = numCliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    public boolean isPaga() {
        return paga;
    }

    public void setPaga(boolean paga) {
        this.paga = paga;
    }

    public ArrayList<Refeicao> getRef() {
        return ref;
    }

    public void setRef(ArrayList<Refeicao> ref) {
        this.ref = ref;
    }     
    
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
