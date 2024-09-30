

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.example.ResultadoValidacao;
import com.example.Usuario;

public class UsuarioTest {

    @Test
    public void testCadastroComCamposValidos() {
        Usuario usuario = new Usuario("João Silva", "joao.silva@example.com", "Senha123", "Senha123", "123.456.789-09", "12345-678");
        ResultadoValidacao resultado = usuario.salvarUsuario();
        assertTrue(resultado.isSucesso());
        assertEquals("Usuário salvo com sucesso!", resultado.getMensagemErro());
    }

    @Test
    public void testFaltaDeNome() {
        Usuario usuario = new Usuario("", "joao.silva@example.com", "Senha123", "Senha123", "123.456.789-09", "12345-678");
        ResultadoValidacao resultado = usuario.salvarUsuario();
        assertFalse(resultado.isSucesso());
        assertEquals("Erro ao salvar o usuário: O nome é obrigatório.", resultado.getMensagemErro());
    }

    @Test
    public void testEmailInvalido() {
        Usuario usuario = new Usuario("João Silva", "joao.silva@.com", "Senha123", "Senha123", "123.456.789-09", "12345-678");
        ResultadoValidacao resultado = usuario.salvarUsuario();
        assertFalse(resultado.isSucesso());
        assertEquals("Erro ao salvar o usuário: O e-mail fornecido é inválido.", resultado.getMensagemErro());
    }

    @Test
    public void testSenhaMuitoCurta() {
        Usuario usuario = new Usuario("João Silva", "joao.silva@example.com", "123", "123", "123.456.789-09", "12345-678");
        ResultadoValidacao resultado = usuario.salvarUsuario();
        assertFalse(resultado.isSucesso());
        assertEquals("Erro ao salvar o usuário: A senha deve ter no mínimo 8 caracteres.", resultado.getMensagemErro());
    }

    @Test
    public void testSenhasNaoCorrespondem() {
        Usuario usuario = new Usuario("João Silva", "joao.silva@example.com", "Senha123", "Senha456", "123.456.789-09", "12345-678");
        ResultadoValidacao resultado = usuario.salvarUsuario();
        assertFalse(resultado.isSucesso());
        assertEquals("Erro ao salvar o usuário: A senha e a confirmação de senha não correspondem.", resultado.getMensagemErro());
    }

    @Test
    public void testCpfOuCnpjInvalido() {
        Usuario usuario = new Usuario("João Silva", "joao.silva@example.com", "Senha123", "Senha123", "123456789", "12345-678");
        ResultadoValidacao resultado = usuario.salvarUsuario();
        assertFalse(resultado.isSucesso());
        assertEquals("Erro ao salvar o usuário: O CPF ou CNPJ fornecido é inválido.", resultado.getMensagemErro());
    }

    @Test
    public void testFaltaDeCep() {
        Usuario usuario = new Usuario("João Silva", "joao.silva@example.com", "Senha123", "Senha123", "123.456.789-09", "");
        ResultadoValidacao resultado = usuario.salvarUsuario();
        assertFalse(resultado.isSucesso());
        assertEquals("Erro ao salvar o usuário: O CEP é obrigatório.", resultado.getMensagemErro());
    }
}
