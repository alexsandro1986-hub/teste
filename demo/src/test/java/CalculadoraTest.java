import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import alex.Calculadora;

public class CalculadoraTest {
   @Test
    public void testesoma(){
        Calculadora calc = new Calculadora();
        Integer result = calc.soma(2, 2);
        assertEquals(4, result);
    }

    public void testesubrtracao(){
        Calculadora calc = new Calculadora();
        Integer result = calc.subtracao(3, 5);
        assertEquals(2, result);
    }

    public void testemultiplicacao(){
        Calculadora calc = new Calculadora();
        Integer result = calc.multiplicacao(3, 2);
        assertEquals(6, result);
    }

    public void testedivisao(){
        Calculadora calc = new Calculadora();
        Integer result = calc.divisao(9, 3);
        assertEquals(3, result);
    }
}
