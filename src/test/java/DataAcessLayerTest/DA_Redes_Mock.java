package DataAcessLayerTest;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;
import java.io.InputStream;

public class DA_Redes_Mock {
    protected InputStream fis;
    protected HSSFWorkbook wb;
    protected HSSFSheet sheet;
    protected double taxa;
    private String tipo;


    public DA_Redes_Mock(String tipo) {
        taxa = 0;
        this.tipo = tipo;
    }

    protected void readMock () throws IOException {
        fis = DA_Redes_Mock.class.getResourceAsStream("/TAXAS_APS2_TESTE.xls");
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);

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

    protected void leituraMock() throws IOException {
        fis = DA_Redes_Mock.class.getResourceAsStream("/TAXAS_APS2_TESTE.xls");
        wb = new HSSFWorkbook(fis);
        sheet = wb.getSheetAt(0);
    }


}
