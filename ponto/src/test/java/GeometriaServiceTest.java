import static org.junit.jupiter.api.Assertions.assertEquals;

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
    public void DeveAreadoCirculo(){
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularAreaCirculo(2);
        assertEquals(6, resultado);
    }
 @Test
    public void DeveVolumeEsfera(){
        GeometriaService geometriaService = new GeometriaService();
        double resultado = geometriaService.CalcularAreaCirculo(2);
        assertEquals(6, resultado);
    }


}


