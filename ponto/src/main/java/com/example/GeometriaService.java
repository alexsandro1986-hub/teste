package com.example;

public class GeometriaService {

    public double CalcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    public double CalcularAreadoQuadrado(double lado) {
        return lado * lado;
    }

    
    public double CalcularAreaRetangulo(double base, double altura){
        
        
        return base *altura;
    }
    
    public int CalcularAreaCirculo(double raio) {
        return (int) (Math.PI * Math.pow(raio, 2));
    }
    
    public double CalcularVolumeEsfera(double raio) {
        double resultado = (4 * Math.PI * Math.pow(raio, 3)) / 3;
        return resultado;
    }

    public double CalcularVolumeCubo(double aresta) {
        double resultado =  Math.pow(aresta, 3);
        return resultado;
    }

    public double CalcularVolumeCilindro(double raio, double altura) {
        double resultado =  Math.PI * Math.pow(raio, 2) * 3;
        return resultado;
    }


    
}
