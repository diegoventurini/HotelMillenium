/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

/**
 *
 * @author USUÁRIO
 */
public class Quarto {
    private short numQuarto;
    private byte numCamas;
    private float valor;
    private String categoria;
    private Boolean ocupado;

    public Quarto(short numQuarto, byte numCamas, float valor, String categoria) {
        this.numQuarto = numQuarto;
        this.numCamas = numCamas;
        this.valor = valor;
        this.categoria = categoria;
    }

    public Quarto() {
        this.ocupado = false;
    }

    public short getNumQuarto() {
        return numQuarto;
    }

    public void setNumQuarto(short numQuarto) {
        this.numQuarto = numQuarto;
    }

    public byte getNumCamas() {
        return numCamas;
    }

    public void setNumCamas(byte numCamas) {
        this.numCamas = numCamas;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getOcupado() {
        return ocupado;
    }

    public void setOcupado(Boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    
    
    @Override
    public String toString(){
        String str = "";
        str += "Numero do Quarto: " + this.numQuarto + "\n";
        str += "Numero de Camas: " + this.numCamas + "\n";
        str += "Categoria: " + this.categoria + "\n";
        return str;
    }
    
}
