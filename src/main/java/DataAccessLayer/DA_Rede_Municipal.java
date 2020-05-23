package DataAccessLayer;

import TransferLayer.TO_Rede;

import java.io.IOException;

public class DA_Rede_Municipal extends DA_Rede {

    public DA_Rede_Municipal() {
        super();
        strategy = "Municipal";
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
        return new TO_Rede_Municipal (taxa);
    }

}
