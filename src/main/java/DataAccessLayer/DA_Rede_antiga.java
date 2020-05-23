///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package DataAccessLayer;
//
//import TransferLayer.*;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.Row;
//
///**
// *
// * @author aless
// */
//public class DA_Rede_antiga {
//    public double publico;
//    public double particular;
//    public double municipal;
//    public double estadual;
//    public double federal;
//
//    public DA_Rede_antiga(){
//        publico = particular = municipal = estadual = federal = 0;
//    }
//
//    public TO_Rede getData(){
//        try{
//            read();
//        }
//        catch(IOException err){
//            System.out.print(err.getMessage());
//            return null;
//        }
//        return new TO_Rede(publico, particular, municipal, estadual, federal);
//    }
//
//    private void read() throws IOException{
//        InputStream fis= DA_Localizacao.class.getResourceAsStream("/TAXAS_APS2.xls");
//        HSSFWorkbook wb=new HSSFWorkbook(fis);
//        HSSFSheet sheet=wb.getSheetAt(0);
//
//        int countEst=0, countMun=0, countFed=0, countPub=0, countPart=0;
//        for (int rowIndex = 11; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
//            Row row = sheet.getRow(rowIndex);
//            if (row != null) {
//              Cell cellLocalizacao = row.getCell(2);
//              Cell cellRede = row.getCell(3);
//              Cell cellTaxa = row.getCell(15);
//              if (cellTaxa != null && Cell.CELL_TYPE_NUMERIC == cellTaxa.getCellType()) {
//                if("Total".equals(cellLocalizacao.getStringCellValue()) && "Estadual".equals(cellRede.getStringCellValue())){
//                    estadual+=cellTaxa.getNumericCellValue();
//                    countEst++;
//                }
//                else if("Total".equals(cellLocalizacao.getStringCellValue()) && "Municipal".equals(cellRede.getStringCellValue())){
//                    municipal+=cellTaxa.getNumericCellValue();
//                    countMun++;
//                }
//                else if("Total".equals(cellLocalizacao.getStringCellValue()) && "Federal".equals(cellRede.getStringCellValue())){
//                    federal+=cellTaxa.getNumericCellValue();
//                    countFed++;
//                }
//                else if("Total".equals(cellLocalizacao.getStringCellValue()) && "Publico".equals(cellRede.getStringCellValue())){
//                    publico+=cellTaxa.getNumericCellValue();
//                    countPub++;
//                }
//                else if("Total".equals(cellLocalizacao.getStringCellValue()) && "Particular".equals(cellRede.getStringCellValue())){
//                    particular+=cellTaxa.getNumericCellValue();
//                    countPart++;
//                }
//              }
//            }
//        }
//        estadual/=countEst;
//        municipal/=countMun;
//        federal/=countFed;
//        publico/=countPub;
//        particular/=countPart;
//    }
//
//}
