/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Quarto;
import java.util.ArrayList;

/**
 *
 * @author USUÁRIO
 */
public class QuartoDAO {
    private ArrayList<Quarto> list;

    public QuartoDAO() {
        this.list = new ArrayList<>();
    }
    
    public void adicionarQuarto(Quarto quarto){
        this.list.add(quarto);
    }
    
    public Quarto buscarQuarto(short numQuarto){
        for (Quarto q: this.list){
            if (numQuarto == q.getNumQuarto()){
                return q;
            }
        }
        return null;
    }
    
    public void atualizarQuarto(Quarto quart){
        Quarto q = this.buscarQuarto(quart.getNumQuarto());
        if (q != null){
            int ind = this.list.indexOf(q);
            this.list.set(ind, quart);
        }
    }
    
    public void removerQuarto(short numQuarto){
        Quarto q = this.buscarQuarto(numQuarto);
        
        if (q != null)
            this.list.remove(q);
    }

    public ArrayList<Quarto> getList() {
        return list;
    }
    
    
}
