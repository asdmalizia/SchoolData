/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import BussinessLayer.*;

/**
 *
 * @author aless
 */
public class Project {
    public static void main(String[] args) {
        System.out.println("1) Qual é a correlação da taxa de abandono do ensino fundamental com a localização?");
        new BL_Localizacao().analisar();
        System.out.println("\n2) Qual é a correlação da taxa de abandono do ensino fundamental com o tipo de rede?");
        new BL_Rede().analisar();
        System.out.println("\n3) Qual é a correlação da taxa de abandono do ensino fundamental com a UF?");
        new BL_UF().analisar();
        System.out.println("\n4) Qual é a correlação da taxa de abandono do ensino fundamental com a região?");
        new BL_Regiao().analisar();
    }
}
