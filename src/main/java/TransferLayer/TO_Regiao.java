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
public class TO_Regiao {
    public double norte;
    public double nordeste;
    public double sul;
    public double sudeste;
    public double centroOeste;
    
    public TO_Regiao(double norte, double nordeste, double sul, double sudeste, double centroOeste){
        this.norte = norte;
        this.nordeste = nordeste;
        this.sul = sul;
        this.sudeste = sudeste;
        this.centroOeste = centroOeste;
    }
}
