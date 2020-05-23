/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import TransferLayer.TO_UF;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author aless
 */
public class DA_UF {
    public Map<String,Double> estados;

    public DA_UF(){
        estados = new HashMap<String, Double>();
    }
    
    public TO_UF getData(){
        try{
            read();
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_UF(estados);
    }  
    
    private void read() throws IOException{
        InputStream fis= DA_Localizacao.class.getResourceAsStream("/TAXAS_APS2.xls");
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheet=wb.getSheetAt(0);        
                
        for (int rowIndex = 11; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
              Cell cellUF = row.getCell(1);
              Cell cellLocalizacao = row.getCell(2);
              Cell cellRede = row.getCell(3);
              Cell cellTaxa = row.getCell(15);
              if (cellTaxa != null) {
                if("Total".equals(cellLocalizacao.getStringCellValue()) && "Total".equals(cellRede.getStringCellValue())){
                    estados.put(cellUF.getStringCellValue(), cellTaxa.getNumericCellValue());                    
                }
              }
            }
        }
    }
}
