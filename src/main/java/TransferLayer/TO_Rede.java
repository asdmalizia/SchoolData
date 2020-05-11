/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransferLayer;

/**
 *
 * @author aless
 */
public class TO_Rede {
    public double publico;
    public double particular;
    public double municipal;
    public double estadual;
    public double federal;
    
    public TO_Rede(double publico, double particular, double municipal, double estadual, double federal){
        this.publico = publico;
        this.particular = particular;
        this.municipal = municipal;
        this.estadual = estadual;
        this.federal = federal;
    }    
}
