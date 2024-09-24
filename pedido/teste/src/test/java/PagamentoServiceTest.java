import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.never;

import org.junit.jupiter.api.Test;
import org.mockito.verification.VerificationMode;

import com.example.NotificacaoService;
import com.example.Pedido;
import com.example.PagamentoService;
import com.example.PedidoService;

public class PagamentoServiceTest {

    @Test
    public void testProcessarPedidoComsucesso() {
        // Givem
        Pedido pedidoDumy = new Pedido("nome", 2.5);
        PagamentoService pagService = mock(PagamentoService.class);
        NotificacaoService notService = mock(NotificacaoService.class);
        PedidoService pedidoService = new PedidoService(pagService, notService);

        // when

        when(pagService.processarPagamento(pedidoDumy)).thenReturn(true);
        boolean resultado = pedidoService.processarPedido(pedidoDumy);

        // then
        verify(notService,atLeast(1)).enviarConfirmacao(pedidoDumy);
        assertTrue(resultado);
    }

    @Test
    public void testProcessarPedidoComFalha() {
        // Givem
        Pedido pedidoDumy = new Pedido("nome", 2.5);
        PagamentoService pagService = mock(PagamentoService.class);

        NotificacaoService notService = mock(NotificacaoService.class);
        PedidoService pedidoService = new PedidoService(pagService, notService);

        // when
        when(pagService.processarPagamento(pedidoDumy)).thenReturn(false);
        boolean resultado = pedidoService.processarPedido(pedidoDumy);

        // then
        verify(notService, never()).enviarConfirmacao(pedidoDumy);
        assertFalse(resultado);
    }
}
