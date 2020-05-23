/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import Constantes.Tipos_Redes;
import DataAccessLayer.*;
import TransferLayer.*;

import java.util.ArrayList;

/**
 *
 * @author aless
 */
public class BL_Rede {
    public void analisar(){
        ArrayList <TO_Rede> redes = new ArrayList<TO_Rede>();

        redes.add(new DA_Rede(Tipos_Redes.estadual).getData());
        redes.add(new DA_Rede(Tipos_Redes.federal).getData());
        redes.add(new DA_Rede(Tipos_Redes.municipal).getData());
        redes.add(new DA_Rede(Tipos_Redes.particular).getData());
        redes.add(new DA_Rede(Tipos_Redes.publica).getData());

        imprimirRedes(redes);

    }

    void imprimirRedes (ArrayList <TO_Rede> redes){

        for (TO_Rede rede: redes)
            System.out.println("Percentual da taxa de abandono média por estado, em escolas " + rede.getTipo() + ": " + rede.getTaxa());

    }
}
