/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataAccessLayer;

import TransferLayer.*;
import java.io.File;  
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author aless
 */
public class DA_Localizacao{
    
    private double rural;
    private double urbana;
    private DA_Populacao objPopulacao;
    
    public DA_Localizacao(){
        rural=0;
        urbana=0;
        objPopulacao = DA_Populacao.getInstance();
    }
    
    public TO_Localizacao getData(){
        try{
            read();
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_Localizacao(rural, urbana);
    }  
    
    private void read() throws IOException{
        InputStream fis= DA_Localizacao.class.getResourceAsStream("/TAXAS_APS2.xls");
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheet=wb.getSheetAt(0);
        double pop_urbana = 0;
        double pop_rural = 0;
        double pop;

        for (int rowIndex = 11; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell cellUF = row.getCell(1);
                Cell cellLocalizacao = row.getCell(2);
              Cell cellRede = row.getCell(3);
              Cell cellTaxa = row.getCell(15);
              if (cellTaxa != null) {
                  String regiao = cellUF.getStringCellValue();
                if("Urbana".equals(cellLocalizacao.getStringCellValue()) && "Total".equals(cellRede.getStringCellValue())){
                    pop = (objPopulacao.estados.get(regiao)).second;
                    urbana+=(cellTaxa.getNumericCellValue()*pop);
                    pop_urbana += pop;
//                    urbana+=cellTaxa.getNumericCellValue();
//                    pop_urbana += 1;
                }
                else if("Rural".equals(cellLocalizacao.getStringCellValue()) && "Total".equals(cellRede.getStringCellValue())){
                    pop = (objPopulacao.estados.get(regiao)).first;
                    rural+=(cellTaxa.getNumericCellValue()*pop);
                    pop_rural += pop;
//                    rural+=cellTaxa.getNumericCellValue();
//                    pop_rural += 1;
                }
              }
            }
        }        
        rural/=pop_rural;
        urbana/=pop_urbana;
    }    
      
}
