import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    @Test
    void longitud() throws IOException {
        CSV csv = new CSV();
        TableWithLabels tableIris = csv.readTableWithLabels("src/files/iris.csv");
        System.out.println("VALOR DE ROW EN IRIS"+ tableIris.getRowAt(1));
        int num_filas = tableIris.readRows();
        System.out.println("Comprobamos que la cantidad de filas leídas:\n 'iris.csv'\n Esperado -> 150\n Obtenido -> " + num_filas);
        assertEquals(150,num_filas);
        Table tableDollars = csv.readTable("src/files/miles_dollars.csv");
        num_filas = tableDollars.readRows();
        System.out.println("'miles_dollars.csv' \n Esperado -> 25 \n Obtenido ->" + num_filas);
        assertEquals(25,num_filas);
    }
}