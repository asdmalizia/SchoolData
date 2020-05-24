package DataAcessLayerTest;

import Constantes.Tipos_Redes;
import DataAccessLayer.DA_Rede;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

class DA_RedeTest {

    ArrayList <DA_Redes_Mock> da_redes = new ArrayList<>();

    @BeforeEach
    void setUp() {
        da_redes.add(new DA_Redes_Mock(Tipos_Redes.municipal));
        da_redes.add(new DA_Redes_Mock(Tipos_Redes.estadual));
        da_redes.add(new DA_Redes_Mock(Tipos_Redes.federal));
        da_redes.add(new DA_Redes_Mock(Tipos_Redes.publica));
        da_redes.add(new DA_Redes_Mock(Tipos_Redes.particular));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void name() {

    }

    @Test
    void getData() {

    }

    @Test
    void read() throws IOException {

    }

    @Test
    void leitura() {

    }

}