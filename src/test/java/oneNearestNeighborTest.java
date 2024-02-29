import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class oneNearestNeighborTest {
    @Test
    void distanciaEuclidea(){
        oneNearestNeighbor onn = new oneNearestNeighbor();
        List<Double> l11 = new LinkedList<>(); l11.add(6.3); l11.add(3.3); l11.add(6.0); l11.add(2.5);
        List<Double> l12 = new LinkedList<>(); l12.add(4.7); l12.add(2.9); l12.add(1.4); l12.add(0.1);
        System.out.println("Comprobamos que la distancia euclidea sea la misma:\nLínea 100 -> (6.3,3.3,6.0,2.5), con (4.7,2.9,1.4,0.1)\nEsperado (redondeado a 4 decimales) -> 5.4442\nObtenido -> "+onn.euclidea(l11,l12));
        assertEquals(5.4442,onn.euclidea(l11,l12),0.0001);

        List<Double> l21 = new LinkedList<>(); l21.add(7.0); l21.add(3.2); l21.add(4.7); l21.add(1.4);
        List<Double> l22 = new LinkedList<>(); l22.add(4.6); l22.add(2.8); l22.add(2.7); l22.add(2.5);
        System.out.println("\nLínea 50 -> (7.0,3.2,4.7,1.4) con (4.6,2.8,2.7,2.5)\nEsperado(redondeado a 4 decimales) -> 3.3361\nObtenido -> "+onn.euclidea(l21,l22));
        assertEquals(3.3361,onn.euclidea(l21,l22),0.0001);

        List<Double> l31 = new LinkedList<>(); l31.add(7.0); l31.add(3.2); l31.add(4.7); l31.add(1.4);
        List<Double> l32 = new LinkedList<>(); l32.add(7.0); l32.add(3.2); l32.add(4.7); l32.add(1.4);
        System.out.println("\nLínea 50 -> (7.0,3.2,4.7,1.4) consigo misma\nEsperado -> 0\nObtenido -> "+onn.euclidea(l31,l32));
        assertEquals(0,onn.euclidea(l31,l32));
    }

    @Test
    void estimateTest() throws IOException {
        CSV csv = new CSV();
        oneNearestNeighbor onn = new oneNearestNeighbor();
        onn.train(csv.readTableWithLabel("src/files/iris.csv"));
        List<Double> l1 = new LinkedList<>(); l1.add(5.1); l1.add(3.5); l1.add(1.5); l1.add(0.2);
        System.out.println("Comprobamos que estimate funciona correctamente:\nLista (5.1,3.5,1.5,0.2)\nEsperado -> 0\nObtenido -> "+ onn.estimate(l1));
        assertEquals(0,onn.estimate(l1));

        List<Double> l2 = new LinkedList<>(); l2.add(5.8); l2.add(2.7); l2.add(4.0); l2.add(1.2);
        System.out.println("\nLista (5.8,2.7,4.0,1.2)\nEsperado -> 1\nObtenido -> "+onn.estimate(l2));
        assertEquals(1,onn.estimate(l2));
    }

}