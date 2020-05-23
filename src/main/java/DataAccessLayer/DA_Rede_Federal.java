package DataAccessLayer;

import TransferLayer.TO_Rede;
import TransferLayer.TO_Rede_Federal;

import java.io.IOException;

public class DA_Rede_Federal extends DA_Rede{
    public DA_Rede_Federal() {
        super();
        strategy = "Federal";
    }

    @Override
    public TO_Rede_Federal getData() {
        try{
            read();
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_Rede_Federal(taxa);
    }
}