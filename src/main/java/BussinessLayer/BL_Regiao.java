/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BussinessLayer;

import DataAccessLayer.DA_Regiao;
import TransferLayer.TO_Regiao;
import java.util.Map;

/**
 *
 * @author aless
 */
public class BL_Regiao {
    public void analisar(){
        TO_Regiao obj = new DA_Regiao().getData();
        System.out.println("Percentual da taxa de abandono média na região Norte: " + obj.norte);
        System.out.println("Percentual da taxa de abandono média na região Nordeste: " + obj.nordeste);
        System.out.println("Percentual da taxa de abandono média na região Sul: " + obj.sul);
        System.out.println("Percentual da taxa de abandono média na região Sudeste: " + obj.sudeste);
        System.out.println("Percentual da taxa de abandono média na região Centro-Oeste: " + obj.centroOeste);
    }
}
