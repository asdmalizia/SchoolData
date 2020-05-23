/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferLayer;

import Constantes.Tipos_Redes;

/**
 *
 * @author aless
 */
public class TO_Rede {
    private double taxa;
    private String tipo;
    
    public TO_Rede(double taxa, String tipo){
        this.tipo = tipo;
        this.taxa = taxa;
    }

    public double getTaxa (){ return this.taxa;}

    public String getTipo () {return this.tipo;}
}
