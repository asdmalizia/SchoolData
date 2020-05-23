package DataAccessLayer;

import TransferLayer.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;

public abstract class DA_Rede {
    protected double taxa;
    protected InputStream fis;
    protected HSSFWorkbook wb;
    protected HSSFSheet sheet;
    protected String strategy;

    public DA_Rede() {
        taxa = 0;
    }

    public abstract TO_Rede getData();

    protected void read() throws IOException{
        leitura();

        int count = 0;

        for (int rowIndex = 11; rowIndex <= sheet.getLastRowNum(); rowIndex++){
            Row row = sheet.getRow(rowIndex);
            if (row != null) {
                Cell cellLocalizacao = row.getCell(2);
                Cell cellRede = row.getCell(3);
                Cell cellTaxa = row.getCell(15);
                if (cellTaxa != null && Cell.CELL_TYPE_NUMERIC == cellTaxa.getCellType()) {
                    if ("Total".equals(cellLocalizacao.getStringCellValue()) && strategy.equals(cellRede.getStringCellValue())) {
                        taxa += cellTaxa.getNumericCellValue();
                        count++;
                    }
                }
            }

        }
        taxa /= count;
    }

    public double getTaxa() {return taxa;}

    protected void leitura() throws IOException {
        fis = DA_Localizacao.class.getResourceAsStream("/TAXAS_APS2.xls");
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
    }

}
