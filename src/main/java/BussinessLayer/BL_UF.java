/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import DataAccessLayer.DA_UF;
import TransferLayer.TO_UF;
import java.util.Map;

/**
 *
 * @author aless
 */
public class BL_UF {
    public void analisar(){
        TO_UF obj = new DA_UF().getData();
        for (Map.Entry<String,Double> entry : obj.estados.entrySet())  
            System.out.println("Percentual da taxa de abandono média no estado " + entry.getKey() + ": " + entry.getValue());
    }
}
