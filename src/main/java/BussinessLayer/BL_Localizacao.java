/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import DataAccessLayer.DA_Localizacao;
import TransferLayer.TO_Localizacao;

/**
 *
 * @author aless
 */
public class BL_Localizacao {
    public void analisar(){
        TO_Localizacao obj = new DA_Localizacao().getData();
        System.out.println("Percentual da taxa de abandono média por estado, em áreas rurais: " + obj.rural);
        System.out.println("Percentual da taxa de abandono média por estado, em áreas urbanas: " + obj.urbana);
    }
}
