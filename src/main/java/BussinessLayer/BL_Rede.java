/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import DataAccessLayer.*;
import TransferLayer.*;

/**
 *
 * @author aless
 */
public class BL_Rede {
    public void analisar(){
        TO_Rede_Estadual obj_estadual =   new DA_Rede_Estadual().getData();
        TO_Rede_Federal obj_federal = new  DA_Rede_Federal().getData();
        TO_Rede_Municipal obj_municipal = new DA_Rede_Municipal().getData();
        TO_Rede_Particular obj_particular = new DA_Rede_Particular().getData();
        TO_Rede_Publica obj_publico =  new DA_Rede_Publica().getData();

        System.out.println("Percentual da taxa de abandono média por estado, em escolas públicas: " + obj_publico.taxa);
        System.out.println("Percentual da taxa de abandono média por estado, em escolas particulares: " + obj_particular.taxa);
        System.out.println("Percentual da taxa de abandono média por estado, em escolas municipais: " + obj_municipal.taxa);
        System.out.println("Percentual da taxa de abandono média por estado, em escolas estaduais: " + obj_estadual.taxa);
        System.out.println("Percentual da taxa de abandono média por estado, em escolas federais: " + obj_federal.taxa);
    }
}
