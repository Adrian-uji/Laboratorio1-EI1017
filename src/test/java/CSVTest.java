import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @Test
    void cantidadFilas() throws IOException {
        CSV csv= new CSV();
        Table tableDollars = csv.readTable("src/files/miles_dollars.csv");
        System.out.println("Comprobamos que tenga el número de filas correcto en diferentes archivos:\n'miles_dollars.csv':\nEsperado -> 25\nObtenido-> "+ tableDollars.getSize());
        assertEquals(25,tableDollars.getSize());
        TableWithLabels tableIris = csv.readTableWithLabel("src/files/iris.csv");
        System.out.println("\n'iris.csv'\nEsperado -> 150\nObtenido -> "+tableIris.getSize());
        assertEquals(150,tableIris.getSize());
    }

    @Test
    void cantidadColumnas() throws IOException {
        CSV csv= new CSV();
        Table tableDollars = csv.readTable("src/files/miles_dollars.csv");
        System.out.println("Comprobamos que tenga el número de columnas es correcto en diferentes archivos:\n'miles_dollars.csv':\nEsperado -> 2\nObtenido-> "+ tableDollars.getColumnSize());
        assertEquals(2,tableDollars.getColumnSize());
        TableWithLabels tableIris = csv.readTableWithLabel("src/files/iris.csv");
        System.out.println("\n'iris.csv'\nEsperado -> 4\nObtenido -> "+tableIris.getColumnSize());
        assertEquals(4,tableIris.getColumnSize());
    }

    @Test
    void nombreEtiquetas() throws IOException {
        CSV csv = new CSV();
        TableWithLabels tableIris = csv.readTableWithLabel("src/files/iris.csv");
        Set<String> labels = tableIris.getLabels();
        System.out.println("Comprobamos que el nombre de las etiquetas es el correcto:\nEstá Iris-setosa?\nEsperado -> true\nObtenido -> " + labels.contains("Iris-setosa"));
        assertTrue(labels.contains("Iris-setosa"));
        System.out.println("\nEstá Iris-confucia?\nEsperado -> false\nObtenido -> "+labels.contains("Iris-confucia"));
        assertFalse(labels.contains("Iris-confucia"));
        System.out.println("\nEstá Iris-versicolor?\nEsperado -> true\nObtenido -> "+labels.contains("Iris-versicolor"));
        assertTrue(labels.contains("Iris-versicolor"));
        System.out.println("\nEstá Iris-virginica?\nEsperado -> true\nObtenido -> "+labels.contains("Iris-virginica"));
        assertTrue(labels.contains("Iris-virginica"));
        System.out.println("\nEstá Iris-roja?\nEsperado -> false\nObtenido -> "+labels.contains("Iris-roja"));
        assertFalse(labels.contains("Iris-roja"));
    }

    @Test
    void recuperarValores() throws IOException {
        CSV csv = new CSV();
        Table tableDollars = csv.readTable("src/files/miles_dollars.csv");
        TableWithLabels tableIris = csv.readTableWithLabel("src/files/iris.csv");
        Row l1 = tableDollars.getRowAt(3);
        System.out.println("Comprobamos que podemos conseguir recuperar los datos introducidos:\nmiles_dollars fila 3:\nEsperado -> [1687.0, 2511.0]\nObtenido -> " + l1.getData());
        assertEquals(l1.getData().get(0), 1687.0);
        assertEquals(l1.getData().get(1), 2511.0);
        Row l2 = tableDollars.getRowAt(15);
        System.out.println("\n miles dollars fila 15: \nEsperado -> [3643,5298]\nObtenido -> "+l2.getData());
        assertEquals(l2.getData().get(0), 3643.0);
        assertEquals(l2.getData().get(1), 5298.0);

        Row l3 = tableDollars.getRowAt(17);
        System.out.println("\n miles dollars fila 17: \nEsperado -> [4033,5147]\nObtenido -> "+l3.getData());
        assertEquals(l3.getData().get(0), 4033);
        assertEquals(l3.getData().get(1), 5147);

        RowWhithLabel l4 = (RowWhithLabel) tableIris.getRowAt(5);
        System.out.println("\n iris fila 5: \nEsperado -> [5.4,3.9,1.7,0.4] Clase -> 0\nObtenido -> "+l4.getData()+ " Clase -> "+l4.getNumberClass());
        assertEquals(l4.getData().get(0), 5.4);
        assertEquals(l4.getData().get(1), 3.9);
        assertEquals(l4.getData().get(2), 1.7);
        assertEquals(l4.getData().get(3), 0.4);
        assertEquals(l4.getNumberClass(), 0);

        RowWhithLabel l5 = (RowWhithLabel) tableIris.getRowAt(50);
        System.out.println("\n iris fila 50: \nEsperado -> [7.0,3.2,4.7,1.4] Clase -> 0\nObtenido -> "+l5.getData()+ " Clase -> "+l5.getNumberClass());
        assertEquals(l5.getData().get(0), 7.0);
        assertEquals(l5.getData().get(1), 3.2);
        assertEquals(l5.getData().get(2), 4.7);
        assertEquals(l5.getData().get(3), 1.4);
        assertEquals(l5.getNumberClass(), 1);


    }

    @Test
    void excepcionesRecuperarValor() throws IOException {
        CSV csv = new CSV();
        Table tableDollars = csv.readTable("src/files/miles_dollars.csv");
        //assertThrows(IndexOutOfBoundsException,tableDollars.getRowAt(300));

    }
    /*4*/

}