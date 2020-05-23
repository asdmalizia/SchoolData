package DataAccessLayer;

import TransferLayer.TO_Rede;

import java.io.IOException;

public class DA_Rede_Estadual extends DA_Rede{

    public DA_Rede_Estadual() {
        super();
        strategy = "Estadual";
    }

    @Override
    public TO_Rede getData() {
        try{
            read();
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_Rede_Estadual (taxa);
    }

}
