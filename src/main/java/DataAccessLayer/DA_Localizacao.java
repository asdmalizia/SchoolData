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
        //inicializar o objPopulacao
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
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\aless\\OneDrive\\Documentos\\NetBeansProjects\\SchoolData\\src\\main\\java\\DataSource\\TAXAS_APS2.xls"));
        HSSFWorkbook wb=new HSSFWorkbook(fis);  
        HSSFSheet sheet=wb.getSheetAt(0);
        
        int count=0;        
        for (int rowIndex = 11; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
              Cell cellLocalizacao = row.getCell(2);
              Cell cellRede = row.getCell(3);
              Cell cellTaxa = row.getCell(15);
              if (cellTaxa != null) {
                if("Urbana".equals(cellLocalizacao.getStringCellValue()) && "Total".equals(cellRede.getStringCellValue())){
                    urbana+=cellTaxa.getNumericCellValue();
                    //par = objPopulacao.estados.get("UF")
                    //pop_urbana = par.second
                    count++;
                    //somar em pop_urbana total
                }
                else if("Rural".equals(cellLocalizacao.getStringCellValue()) && "Total".equals(cellRede.getStringCellValue())){
                    rural+=cellTaxa.getNumericCellValue();
                }
              }
            }
        }        
        rural/=count; //dividir pela pop_rural total
        urbana/=count;
    }    
      
}
