
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import alex.ContaCorrente;

public class ContaCorrentetest {

    private ContaCorrente contaMaria;
    private ContaCorrente contaJose;
    
    @BeforeEach
    public void setUp() {
        contaMaria = new ContaCorrente("Maria", 200.0);
        contaJose = new ContaCorrente("José", 100.0);
    }

    @Test
    public void testSaldoInicial() {
        assertNotNull(contaMaria, "Conta Maria não deve ser nula");
        assertNotNull(contaJose, "Conta José não deve ser nula");
        assertNotEquals(contaMaria.getSaldo(), contaJose.getSaldo(), "Os saldos iniciais devem ser diferentes");
    }

    @Test
    public void testSaqueComSaldoInsuficiente() {
        boolean resultado = contaMaria.saque(300.0);
        assertFalse(resultado, "O saque acima do saldo deve retornar false");
        assertEquals(200.0, contaMaria.getSaldo(), "O saldo da Maria não deve ter mudado");
    }

    @Test
    public void testSaqueComSaldoSuficiente() {
        boolean resultado = contaMaria.saque(100.0);
        assertTrue(resultado, "O saque com saldo suficiente deve retornar true");
        assertEquals(100.0, contaMaria.getSaldo(), "O saldo da Maria deve ser 100 após o saque");
    }

    @Test
    public void testDeposito() {
        contaJose.deposito(50.0);
        assertEquals(150.0, contaJose.getSaldo(), "O saldo de José deve ser 150 após o depósito");
    }

    @Test
    public void testSaqueEDeposito() {
        contaMaria.saque(100.0);
        contaJose.deposito(50.0);
        assertEquals(contaMaria.getSaldo(), contaJose.getSaldo(), "Após o saque e depósito, os saldos devem ser iguais");
    }
}
