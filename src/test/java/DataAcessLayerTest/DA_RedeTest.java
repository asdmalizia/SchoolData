package DataAcessLayerTest;

import Constantes.Tipos_Redes;
import DataAccessLayer.DA_Rede;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DA_RedeTest {

    ArrayList <DA_Rede> da_redes = new ArrayList<>();

    @BeforeEach
    void setUp() {
        da_redes.add(new DA_Rede(Tipos_Redes.estadual));
        da_redes.add(new DA_Rede(Tipos_Redes.federal));
        da_redes.add(new DA_Rede(Tipos_Redes.municipal));
        da_redes.add(new DA_Rede(Tipos_Redes.particular));
        da_redes.add(new DA_Rede(Tipos_Redes.publico));
    }

    @Test
    void calculateTaxa() throws IOException {
        HSSFSheet sheet = getSheetMock();
        Collection<Object[]> massaDeTeste = Arrays.asList( new Object[][]{
                {da_redes.get(0).calculateTaxa(sheet), 3.9},
                {da_redes.get(1).calculateTaxa(sheet), 0.1},
                {da_redes.get(2).calculateTaxa(sheet), 3.0},
                {da_redes.get(3).calculateTaxa(sheet), 0.1},
                {da_redes.get(4).calculateTaxa(sheet), 3.5},
        });

        for ( Object[] teste : massaDeTeste){
            assertEquals(teste[0], teste[1]);
        }
    }

    @Test
    void getSheet() throws IOException {
        int rowIndex = 10;
        HSSFSheet sheetResult = getSheetMock();
        List<String> expected = Arrays.asList(
                "Estadual",
                "Federal",
                "Municipal",
                "Particular",
                "Publico",
                "Total");
        for (String expectedCell : expected){
            Row row = sheetResult.getRow(rowIndex);
            Cell cell = row.getCell(3);
            assertEquals(expectedCell, cell.toString());
            rowIndex++;
        }
    }

    protected HSSFSheet getSheetMock() throws IOException{
        InputStream fis = DA_RedeTest.class.getResourceAsStream("/TAXAS_APS2_TESTE.xls");
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        return sheet;
    }

}