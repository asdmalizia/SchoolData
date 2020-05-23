package DataAccessLayer;

import TransferLayer.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;

public class DA_Rede {
    protected double taxa;
    protected InputStream fis;
    protected HSSFWorkbook wb;
    protected HSSFSheet sheet;
    protected String tipo;

    public DA_Rede(String tipo) {
        taxa = 0;
        this.tipo = tipo;
    }

    public TO_Rede getData(){
        try{
            read();
        }
        catch(IOException err){
            System.out.print(err.getMessage());
            return null;
        }
        return new TO_Rede(taxa, tipo);
    };

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
                    if ("Total".equals(cellLocalizacao.getStringCellValue()) && tipo.equals(cellRede.getStringCellValue())) {
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
