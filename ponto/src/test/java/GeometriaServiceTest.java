import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.GeometriaService;



public class GeometriaServiceTest {

    @Test
    public void DeveCalcularAreaTriangulo() {
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularAreaTriangulo(2,2);
        geometriaService.CalcularAreaTriangulo(2, 2);
       assertEquals(2,resultado);
    }


    @Test
    public void DeveCalcularAreaQuadrado(){
        GeometriaService geometriaService = new GeometriaService();
        double resultado= geometriaService.CalcularAreadoQuadrado(2);
        assertEquals(4,resultado);
    }

    @Test
    public void DeveCalcularAreaEsfera(){
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularVolumeEsfera(2.0);
        assertEquals(33.5, resultado, 0.1);
    }

    @Test
    public void DeveCalcularAreaRetangulo(){
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularAreaRetangulo(2, 3);
        assertEquals(6, resultado);
    }

    @Test
    public void DeveCalcularAreaCirculo() {
        GeometriaService geometriaService = new GeometriaService();
        int resultado = geometriaService.CalcularAreaCirculo(2);
        int areaEsperada = (int) (Math.PI * Math.pow(2, 2));
        
        assertEquals(areaEsperada, resultado);
    }
 @Test
    public void DeveVolumeEsfera(){
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularAreaCirculo(2);
        assertEquals(12, resultado);
    }


}


