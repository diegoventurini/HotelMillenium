/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Octávio
 */
public class Cliente {
    private String nome;
    private String telefone;
    private String cpf;
    private Boolean sexo;
    private String email;
    private Date dataNascimento;

    public Cliente(String nome, String telefone, String cpf, Boolean sexo, String email, Date dataNascimento) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.sexo = sexo;
        this.email = email;
        this.dataNascimento = dataNascimento;
    }

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Boolean getSexo() {
        return sexo;
    }

    public void setSexo(Boolean sexo) {
        this.sexo = sexo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    @Override
    public String toString(){
        SimpleDateFormat fm = new SimpleDateFormat("dd/MM/yyyy");
        String str = "";
        str += "Nome: " + this.nome + "\n";
        str += "CPF: " + this.cpf + "\n";
        str += "Sexo: ";
        str += (this.sexo) ? "Masculino" + "\n" : "Feminino" + "\n";
        str += "Data de Nascimento: " + fm.format(this.dataNascimento) + "\n";
        str += "Telefone: " + this.telefone + "\n";
        str += "Email: " + this.email + "\n";
        return str;
    }
}
