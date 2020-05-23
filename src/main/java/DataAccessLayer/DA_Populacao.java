/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessLayer;

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
public class DA_Populacao {
    public Map<String, Pair<Double, Double>> estados;
   // public Map<String, Double> regioes;

    private static class DA_Populacao_Holder{
        private static final DA_Populacao INSTANCE = new DA_Populacao();
    }

    public static DA_Populacao getInstance(){
        return DA_Populacao_Holder.INSTANCE;
    }

    private DA_Populacao(){
        estados = new HashMap<String, Pair<Double, Double>>();
        try{
            lerUFS(); //lerRegioes();
        }
        catch(IOException err){
            //faz alguma coisa
        }
    }

    private void lerUFS() throws IOException{
        InputStream fis= DA_Localizacao.class.getResourceAsStream("/TAXAS_APS2.xls");
        HSSFWorkbook wb=new HSSFWorkbook(fis);
        HSSFSheet sheetUF=wb.getSheetAt(1);

        for (int rowIndex = 4; rowIndex <= sheetUF.getLastRowNum(); rowIndex++) {
            Row rowUF = sheetUF.getRow(rowIndex);
            if (rowUF == null)
                continue;

            Cell cellUF = rowUF.getCell(1);
            Cell cellLocalizacao = rowUF.getCell(2);
            Cell cellPopulacaoUF = rowUF.getCell(3);
            double rural = 0;
            double urbana = 0;

            if (cellLocalizacao != null) {
                if ("Rural".equals(cellLocalizacao.getStringCellValue())) {
                    rural = cellPopulacaoUF.getNumericCellValue();
                    Pair<Double, Double> populacao = new Pair<>(rural, urbana);
                    estados.put(cellUF.getStringCellValue(), populacao);
                }
                if ("Urbana".equals(cellLocalizacao.getStringCellValue())) {
                    urbana = cellPopulacaoUF.getNumericCellValue();
                    for(String uf : estados.keySet()){
                       if(uf == cellUF.getStringCellValue()){
                           (estados.get(uf)).second = urbana;
                       }
                    }
                }


            }

          // populacao.imprimir();
//               System.out.println(cellUF.getStringCellValue());

//               for(String uf : estados.keySet()){
//                   if(uf == cellUF.getStringCellValue()){
//                       (estados.get(uf)).second
//                   }
//               }



        }
    }

//    private void lerRegioes() throws IOException{
//        InputStream fis= DA_Localizacao.class.getResourceAsStream("/TAXAS_APS2.xls");
//        HSSFWorkbook wb=new HSSFWorkbook(fis);
//        HSSFSheet sheetRegiao=wb.getSheetAt(2);
//
//        for (int rowIndex = 5; rowIndex <= sheetRegiao.getLastRowNum(); rowIndex++) {
//            Row rowRegiao = sheetRegiao.getRow(rowIndex);
//            if (rowRegiao != null) {
//                Cell cellRegiao = rowRegiao.getCell(0);
//                Cell cellPopulacaoRegiao = rowRegiao.getCell(1);
//                regioes.put(cellRegiao.getStringCellValue(), cellPopulacaoRegiao.getNumericCellValue());
//            }
//        }
//    }

}
