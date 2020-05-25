package DataAccessLayer;

import TransferLayer.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;

public class DA_Rede {
    private String tipo;

    public DA_Rede(String tipo) {
        this.tipo = tipo;
    }

    public TO_Rede getData(){
        HSSFSheet sheet;
        double taxa;
        try{
            sheet = getSheet();
            taxa = calculateTaxa(sheet);
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_Rede(taxa, tipo);
    }

    public double calculateTaxa(HSSFSheet sheet) throws IOException{
        double taxa = 0;
        int count = 0;
        // Estava perdendo a primeira linha. row=11
        for (int rowIndex = 10; rowIndex <= sheet.getLastRowNum(); rowIndex++){
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell cellLocalizacao = row.getCell(2);
                Cell cellRede = row.getCell(3);
                Cell cellTaxa = row.getCell(15);
                if (cellTaxa != null && Cell.CELL_TYPE_NUMERIC == cellTaxa.getCellType()) {
                    if ("Total".equals(cellLocalizacao.getStringCellValue()) && tipo.equals(cellRede.getStringCellValue())) {
                        taxa += cellTaxa.getNumericCellValue();
                        count++;
                    }
                }
            }

        }
        taxa /= count;
        return taxa;
    }

    protected HSSFSheet getSheet() throws IOException {
        InputStream fis;
        HSSFWorkbook wb;
        HSSFSheet sheet;
        fis = DA_Rede.class.getResourceAsStream("/TAXAS_APS2.xls");
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
        return sheet;
    }

}
