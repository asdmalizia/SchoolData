package DataAccessLayer;

import TransferLayer.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;

public class DA_Rede_Publica extends DA_Rede {

    public DA_Rede_Publica(){
        super();
        strategy = "Publico";
    }

    @Override
    public TO_Rede_Publica getData() {
        try{
            read();
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_Rede_Publica (taxa);
    }

}
