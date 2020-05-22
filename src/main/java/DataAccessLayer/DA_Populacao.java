/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author aless
 */
public class DA_Populacao {
    public Map<String, Pair<Double, Double>> estados;
    public Map<String, Double> regioes;
    
    private static class DA_Populacao_Holder{
        private static final DA_Populacao INSTANCE = new DA_Populacao();
    }
    
    public static DA_Populacao getInstance(){
        return DA_Populacao_Holder.INSTANCE;
    }
    
    private DA_Populacao(){
        estados = new HashMap<String, Pair<Double, Double>>();
        try{
            lerUFS(); lerRegioes();
        }
        catch(IOException err){
            //faz alguma coisa
        }
    }
    
    private void lerUFS() throws IOException{
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\aless\\Downloads\\TAXAS_APS2.xls"));
        HSSFWorkbook wb=new HSSFWorkbook(fis);  
        HSSFSheet sheetUF=wb.getSheetAt(1);
        
        for (int rowIndex = 5; rowIndex <= sheetUF.getLastRowNum(); rowIndex++) {
            Row rowUF = sheetUF.getRow(rowIndex);            
            if (rowUF != null) {
                Cell cellUF = rowUF.getCell(1);
                Cell cellLocalizacao = rowUF.getCell(2);
                Cell cellPopulacaoUF = rowUF.getCell(3);                
                if("Total".equals(cellLocalizacao.getStringCellValue())){
                    double rural = cellPopulacaoUF.getNumericCellValue(); //corrigir a linha
                    double urbana = cellPopulacaoUF.getNumericCellValue();
                    
                    Pair<Double, Double> populacao = new Pair<>(rural, urbana);                    
                    estados.put(cellUF.getStringCellValue(), populacao);                    
                }                
            }    
        }
    }
    
    private void lerRegioes() throws IOException{
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\aless\\Downloads\\TAXAS_APS2.xls"));
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheetRegiao=wb.getSheetAt(2);        
        
        for (int rowIndex = 5; rowIndex <= sheetRegiao.getLastRowNum(); rowIndex++) {            
            Row rowRegiao = sheetRegiao.getRow(rowIndex);
            if (rowRegiao != null) {
                Cell cellRegiao = rowRegiao.getCell(0);
                Cell cellPopulacaoRegiao = rowRegiao.getCell(1);
                regioes.put(cellRegiao.getStringCellValue(), cellPopulacaoRegiao.getNumericCellValue());
            }            
        }
    }
    
}
