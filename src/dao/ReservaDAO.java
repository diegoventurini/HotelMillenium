/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import classes.Reserva;
import java.util.ArrayList;

/**
 *
 * @author Octávio
 */
public class ReservaDAO {
    private ArrayList<Reserva> list;

    public ReservaDAO() {
        this.list = new ArrayList<>();
    }
    
    public void adicionarReserva(Reserva reserva){
        this.list.add(reserva);
    }
    
    public Reserva buscarReserva(short id){
        for (Reserva r: this.list){
            if(r.getId() == id){
                return r;
            }
        }
        return null;
    }
    
    public void atualizarReserva(Reserva reserva){
        Reserva r = this.buscarReserva(reserva.getId());
        if (r != null){
            int ind = this.list.indexOf(r);
            this.list.set(ind, reserva);
        }
    }
    
    public void removerReserva(short id){
        Reserva r = buscarReserva(id);
        if (r!= null){
            list.remove(r);
            this.corrigeId();
        }
    }

    public ArrayList<Reserva> getList() {
        return list;
    }
    
    private void corrigeId(){
       for (int i = 0; i < this.list.size(); i++){
           this.list.get(i).setId((short) (i + 1));
       }
    }
}
