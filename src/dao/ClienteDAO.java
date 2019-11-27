/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Cliente;
import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class ClienteDAO {
   
    private ArrayList<Cliente> list;

    public ClienteDAO() {
        this.list = new ArrayList<>();
    }
    
    public void adicionarCliente(Cliente c){
        this.list.add(c);
    }
    
    public Cliente buscarCliente(String cpf){
        for (Cliente c: this.list){
            if (cpf.equals(c.getCpf())){
                return c;
            }
        }
        return null;
    }
    
    public void alterarCliente(Cliente cliente){
        Cliente c = this.buscarCliente(cliente.getCpf());
        if (c != null){
            int index = this.list.indexOf(c);
            this.list.set(index, cliente);
        }
    }
    
    public void removerCliente(String cpf){
        Cliente c = this.buscarCliente(cpf);
        
        if (c != null)
            this.list.remove(c);
    }

    public ArrayList<Cliente> getList() {
        return list;
    }
}
