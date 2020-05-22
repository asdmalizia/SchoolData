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
    public Map<String, Double> counter;
    public Map<String, String> estados;
    private DA_Populacao objPopulacao;
    
    public DA_Regiao(){
//        objPopulacao = DA_Populacao.getInstance();
        
        regioes = new HashMap<String, Double>();
        regioes.put("NE", 0.);
        regioes.put("N", 0.);
        regioes.put("SE", 0.);
        regioes.put("S", 0.);
        regioes.put("CO", 0.);
        
        counter = new HashMap<String, Double>();
        counter.put("NE", 0.);
        counter.put("N", 0.);
        counter.put("SE", 0.);
        counter.put("S", 0.);
        counter.put("CO", 0.);
        
        estados = new HashMap<String, String>();
        estados.put("RJ", "SE");
        estados.put("SP", "SE");
        estados.put("MG", "SE");
        estados.put("ES", "SE");
        estados.put("RO", "N");
        estados.put("TO", "N");
        estados.put("RR", "N");
        estados.put("AM", "N");
        estados.put("PA", "N");
        estados.put("AP", "N");
        estados.put("AC", "N");
        estados.put("SC", "S");
        estados.put("RS", "S");
        estados.put("PR", "S");
        estados.put("MT", "CO");
        estados.put("MS", "CO");
        estados.put("DF", "CO");
        estados.put("GO", "CO");
        estados.put("BA", "NE");
        estados.put("MA", "NE");
        estados.put("PE", "NE");
        estados.put("PB", "NE");
        estados.put("AL", "NE");
        estados.put("SE", "NE");
        estados.put("RN", "NE");
        estados.put("CE", "NE");
        estados.put("PI", "NE");
        
    }
    
    public TO_Regiao getData(){
        try{
            read();
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_Regiao(regioes.get("N"), regioes.get("NE"), regioes.get("S"), regioes.get("SE"), regioes.get("CO"));
    }  
    
    private void read() throws IOException{
        FileInputStream fis=new FileInputStream(new File("C:\\Users\\aless\\Downloads\\TAXAS_APS2.xls"));
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
                    String regiao = estados.get(cellUF.getStringCellValue());
                    double taxa = regioes.get(regiao);
                    regioes.put(regiao, taxa + cellTaxa.getNumericCellValue());
                    
                    double count = counter.get(regiao);
                    counter.put(regiao, count+1);
                }
              }
            }
        }        
        double norte = regioes.get("N");
        double count = counter.get("N");
        norte/=count;
        regioes.put("N", norte);
        
        double nordeste = regioes.get("NE");
        count = counter.get("NE");
        nordeste/=count;
        regioes.put("NE", nordeste);
        
        double sul = regioes.get("S");
        count = counter.get("S");
        sul/=count;
        regioes.put("S", sul);
        
        double sudeste = regioes.get("SE");
        count = counter.get("SE");
        sudeste/=count;
        regioes.put("SE", sudeste);
        
        double centroOeste = regioes.get("CO");
        count = counter.get("CO");
        centroOeste/=count;
        regioes.put("CO", centroOeste);
    }
}
