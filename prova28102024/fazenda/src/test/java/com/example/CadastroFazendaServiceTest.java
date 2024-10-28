package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CadastroFazendaServiceTest {

    private final CadastroFazendaService service = new CadastroFazendaService();

    // Testes para validação do nome da fazenda
    @Test
    void testNomeValido() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, "12345678901", 100, 200, 30.0, 50.0);
        assertTrue(service.validarFazenda(fazenda));
    }

    @Test
    void testNomeVazio() {
        Fazenda fazenda = new Fazenda("", 300, "12345678901", 100, 200, 30.0, 50.0);
        assertFalse(service.validarFazenda(fazenda));
    }

    @Test
    void testNomeNulo() {
        Fazenda fazenda = new Fazenda(null, 300, "12345678901", 100, 200, 30.0, 50.0);
        assertFalse(service.validarFazenda(fazenda));
    }

    // Testes para validação da área da fazenda
    @Test
    void testAreaValida() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, "12345678901", 100, 200, 30.0, 50.0);
        assertTrue(service.validarFazenda(fazenda));
    }

    @Test
    void testAreaNegativa() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", -100, "12345678901", 100, 200, 30.0, 50.0);
        assertFalse(service.validarFazenda(fazenda));
    }

    // Testes para validação do CPF
    @Test
    void testCpfValido() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, "12345678901", 100, 200, 30.0, 50.0);
        assertTrue(service.validarFazenda(fazenda));
    }

    @Test
    void testCpfInvalidoMenosDigitos() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, "123456789", 100, 200, 30.0, 50.0);
        assertFalse(service.validarFazenda(fazenda));
    }

    @Test
    void testCpfNulo() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, null, 100, 200, 30.0, 50.0);
        assertFalse(service.validarFazenda(fazenda));
    }

    @Test
    void testCpfComCaracteresInvalidos() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, "12345abc901", 100, 200, 30.0, 50.0);
        assertFalse(service.validarFazenda(fazenda));
    }

    // Testes para validação da latitude
    @Test
    void testLatitudeValida() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, "12345678901", 100, 200, 30.0, 50.0);
        assertTrue(service.validarFazenda(fazenda));
    }

    @Test
    void testLatitudeForaDoIntervalo() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, "12345678901", 100, 200, 100.0, 50.0);
        assertFalse(service.validarFazenda(fazenda));
    }

    // Testes para validação da longitude
    @Test
    void testLongitudeValida() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, "12345678901", 100, 200, 30.0, 50.0);
        assertTrue(service.validarFazenda(fazenda));
    }

    @Test
    void testLongitudeForaDoIntervalo() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 300, "12345678901", 100, 200, 30.0, 200.0);
        assertFalse(service.validarFazenda(fazenda));
    }

    // Testes para validação das áreas da fazenda
    @Test
    void testAreasValidas() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 200, "12345678901", 100, 100, 30.0, 50.0);
        assertTrue(service.validarFazenda(fazenda));
    }

    @Test
    void testAreasInvalidas() {
        Fazenda fazenda = new Fazenda("Fazenda Teste", 200, "12345678901", 150, 150, 30.0, 50.0);
        assertFalse(service.validarFazenda(fazenda));
    }
}
