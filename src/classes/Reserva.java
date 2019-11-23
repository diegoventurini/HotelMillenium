/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author diego
 */
public class Reserva {
    private short id;
    private Cliente cliente;
    private Quarto quarto;
    private Date dataInicio;
    private short diasHospedagem;

    public Reserva(short id, Cliente cliente, Quarto quarto, Date dataInicio, short diasHospedagem) {
        this.id = id;
        this.cliente = cliente;
        this.quarto = quarto;
        this.dataInicio = dataInicio;
        this.diasHospedagem = diasHospedagem;
    }

    public Reserva() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Quarto getQuarto() {
        return quarto;
    }

    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public short getDiasHospedagem() {
        return diasHospedagem;
    }

    public void setDiasHospedagem(short diasHospedagem) {
        this.diasHospedagem = diasHospedagem;
    }
    
    public Date calcularDataSaida(){
        Calendar c =  Calendar.getInstance();
        c.setTime(this.dataInicio);
        c.add(Calendar.DATE, this.diasHospedagem);
        return c.getTime();
    }
    
    @Override
    public String toString(){
        String str = "";
        str += "ID: " + this.id + "\n";
        
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        str += "Data de Inicio: " + df.format(dataInicio) + "\n";
        str += "Dias de Hospedagem: " + this.diasHospedagem + "\n";
        str += "Valor: " + this.quarto.getValor() * this.diasHospedagem + "\n";
        return str;
    }
}
