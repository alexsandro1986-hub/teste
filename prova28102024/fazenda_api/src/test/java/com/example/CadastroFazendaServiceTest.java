package com.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CadastroFazendaServiceTest {
    private FazendaApiService fazendaApiService;
    private CadastroFazendaService cadastroFazendaService;

    @BeforeEach
    void setUp() {
        fazendaApiService = mock(FazendaApiService.class);
        cadastroFazendaService = new CadastroFazendaService(fazendaApiService);
    }

    @Test
    void testCadastroFazendaSucesso() {
        String codigo = "12345";
        String nome = "Fazenda Teste";
        double latitude = 12.34;
        double longitude = 56.78;
        double areaAgricultavel = 100.0;
        double areaNaoAgricultavel = 200.0;
        String cpf = "12345678901";

        when(fazendaApiService.getLatitude(codigo)).thenReturn(latitude);
        when(fazendaApiService.getLongitude(codigo)).thenReturn(longitude);
        when(fazendaApiService.getAreaAgricultavel(codigo)).thenReturn(areaAgricultavel);
        when(fazendaApiService.getAreaNaoAgricultavel(codigo)).thenReturn(areaNaoAgricultavel);
        when(fazendaApiService.getCpfProprietario(codigo)).thenReturn(cpf);

        Fazenda fazenda = cadastroFazendaService.cadastrarFazenda(codigo, nome);

        assertNotNull(fazenda);
        assertEquals(nome, fazenda.getNome());
        assertEquals(codigo, fazenda.getCodigo());
        assertEquals(latitude, fazenda.getLatitude());
        assertEquals(longitude, fazenda.getLongitude());
        assertEquals(areaAgricultavel, fazenda.getAreaAgricultavel());
        assertEquals(areaNaoAgricultavel, fazenda.getAreaNaoAgricultavel());
        assertEquals(cpf, fazenda.getCpfProprietario());
        assertEquals(areaAgricultavel + areaNaoAgricultavel, fazenda.getAreaTotal());
    }

    @Test
    void testCadastroFazendaErroRecuperarLatitude() {
        String codigo = "12345";
        String nome = "Fazenda Teste";

        when(fazendaApiService.getLatitude(codigo)).thenThrow(new RuntimeException("Erro ao recuperar latitude"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            cadastroFazendaService.cadastrarFazenda(codigo, nome);
        });

        assertEquals("Erro ao recuperar latitude", exception.getMessage());
    }

    @Test
    void testCadastroFazendaErroRecuperarLongitude() {
        String codigo = "12345";
        String nome = "Fazenda Teste";

        when(fazendaApiService.getLongitude(codigo)).thenThrow(new RuntimeException("Erro ao recuperar longitude"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            cadastroFazendaService.cadastrarFazenda(codigo, nome);
        });

        assertEquals("Erro ao recuperar longitude", exception.getMessage());
    }

    @Test
    void testCadastroFazendaErroRecuperarAreaAgricultavel() {
        String codigo = "12345";
        String nome = "Fazenda Teste";

        when(fazendaApiService.getAreaAgricultavel(codigo)).thenThrow(new RuntimeException("Erro ao recuperar área agricultável"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            cadastroFazendaService.cadastrarFazenda(codigo, nome);
        });

        assertEquals("Erro ao recuperar área agricultável", exception.getMessage());
    }

    @Test
    void testCadastroFazendaErroRecuperarAreaNaoAgricultavel() {
        String codigo = "12345";
        String nome = "Fazenda Teste";

        when(fazendaApiService.getAreaNaoAgricultavel(codigo)).thenThrow(new RuntimeException("Erro ao recuperar área não agricultável"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            cadastroFazendaService.cadastrarFazenda(codigo, nome);
        });

        assertEquals("Erro ao recuperar área não agricultável", exception.getMessage());
    }

    @Test
    void testCadastroFazendaErroRecuperarCpfProprietario() {
        String codigo = "12345";
        String nome = "Fazenda Teste";

        when(fazendaApiService.getCpfProprietario(codigo)).thenThrow(new RuntimeException("Erro ao recuperar CPF do proprietário"));

        Exception exception = assertThrows(RuntimeException.class, () -> {
            cadastroFazendaService.cadastrarFazenda(codigo, nome);
        });

        assertEquals("Erro ao recuperar CPF do proprietário", exception.getMessage());
    }
}
