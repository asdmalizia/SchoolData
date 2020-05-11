/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import DataAccessLayer.DA_Rede;
import TransferLayer.TO_Rede;

/**
 *
 * @author aless
 */
public class BL_Rede {
    public void analisar(){
        TO_Rede obj = new DA_Rede().getData();
        System.out.println("Percentual da taxa de abandono média por estado, em escolas públicas: " + obj.publico);
        System.out.println("Percentual da taxa de abandono média por estado, em escolas particulares: " + obj.particular);
        System.out.println("Percentual da taxa de abandono média por estado, em escolas municipais: " + obj.municipal);
        System.out.println("Percentual da taxa de abandono média por estado, em escolas estaduais: " + obj.estadual);
        System.out.println("Percentual da taxa de abandono média por estado, em escolas federais: " + obj.federal);
    }
}
