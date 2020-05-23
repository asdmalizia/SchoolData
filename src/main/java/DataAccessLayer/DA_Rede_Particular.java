package DataAccessLayer;

import TransferLayer.TO_Rede;
import TransferLayer.TO_Rede_Particular;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;

public class DA_Rede_Particular extends DA_Rede{

    public DA_Rede_Particular() {
        super();
        strategy = "Particular";
    }

    @Override
    public TO_Rede_Particular getData() {
        try{
            read();
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_Rede_Particular(taxa);
    }


}
