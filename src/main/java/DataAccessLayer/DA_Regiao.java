/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import TransferLayer.TO_Regiao;
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
public class DA_Regiao {
    public Map<String, Double> regioes;

    public DA_Regiao(){

        regioes = new HashMap<String, Double>();
        
    }
    
    public TO_Regiao getData(){
        try{
            read();
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_Regiao(regioes.get("NORTE"), regioes.get("NORDESTE"), regioes.get("SUL"), regioes.get("SUDESTE"), regioes.get("CENTRO-OESTE"));
    }  
    
    private void read() throws IOException{
        InputStream fis= DA_Localizacao.class.getResourceAsStream("/TAXAS_APS2_REGIOES.xls");
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheet=wb.getSheetAt(0);

        for (int rowIndex = 10; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
              Cell cellRegiao = row.getCell(1);
              Cell cellLocalizacao = row.getCell(2);
              Cell cellRede = row.getCell(3);
              Cell cellTaxa = row.getCell(15);
              if (cellTaxa != null) {
                  if("Total".equals(cellLocalizacao.getStringCellValue()) && "Total".equals(cellRede.getStringCellValue())){
                      regioes.put(cellRegiao.getStringCellValue(), cellTaxa.getNumericCellValue());
                  }
              }
            }
        }        

    }
}
