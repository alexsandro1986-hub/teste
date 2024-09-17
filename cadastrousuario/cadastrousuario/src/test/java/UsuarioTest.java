import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.Usuario;

public class UsuarioTest {
    public void DevCadastrarComSucesso(){
        Usuario usuarioValido = new Usuario("nome", "email.@com", "123456789", "123456789", null, "123");

        usuarioValido.salvarUsuario();
        Resultado resultado = usuarioValido.salvarUsuario();
        assertEquals(resultado.getMensagemErro(), "Usuario salvo");
       // assertEquals("getMensagemErro()", "usuarioValido");
        assertTrue(resultado.isSucesso);


    }
}
