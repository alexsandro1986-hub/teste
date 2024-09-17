package com.example;

public class GeometriaService {

    public double CalcularAreaTriangulo(double base, double altura) {
        return (base * altura) / 2;
    }

    public double CalcularAreadoQuadrado(double lado) {
        return lado * lado;
    }

    public double CalcularVolumeEsfera(double raio) {
        double resultado = (4 * Math.PI * Math.pow(raio, 3)) / 3;
        return resultado;
    }

    public double CalcularAreaRetangulo(double base, double altura){
            
        
        return base *altura;
    }
}
