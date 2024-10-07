import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Address;
import com.example.AddressController;
import com.example.AddressService;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class AddressControllerTest {

    private AddressService addressServiceMock; // Mock do serviço de endereço
    private AddressController addressController; // Controlador de endereço

    // Configuração inicial antes de cada teste
    @BeforeEach
    public void setUp() {
        addressServiceMock = mock(AddressService.class); // Cria um mock do AddressService
        addressController = new AddressController(addressServiceMock); // Inicializa o AddressController com o mock
    }

    // Testa o cenário em que um CEP válido é fornecido
    @Test
    public void testGetAddress_ValidCep() {
        // Arrange
        String validCep = "12345678"; // CEP válido para o teste
        Address expectedAddress = new Address("Rua Exemplo", "Cidade Exemplo", "Estado Exemplo"); // Endereço esperado
        
        // Configura o comportamento do mock para retornar o endereço esperado quando o CEP válido é solicitado
        when(addressServiceMock.getAddressByCep(validCep)).thenReturn(expectedAddress);

        // Act
        Address actualAddress = addressController.getAddress(validCep); // Chama o método do controlador

        // Assert
        assertNotNull(actualAddress); // Verifica se o endereço retornado não é nulo
        assertEquals(expectedAddress.getStreet(), actualAddress.getStreet()); // Verifica se a rua é a esperada
        assertEquals(expectedAddress.getCity(), actualAddress.getCity()); // Verifica se a cidade é a esperada
        assertEquals(expectedAddress.getState(), actualAddress.getState()); // Verifica se o estado é o esperado
        verify(addressServiceMock).getAddressByCep(validCep); // Verifica se o método do mock foi chamado com o CEP correto
    }

    // Testa o cenário em que um CEP inválido é fornecido
    @Test
    public void testGetAddress_InvalidCep() {
        // Arrange
        String invalidCep = "00000000"; // CEP inválido para o teste
        
        // Configura o comportamento do mock para retornar null quando um CEP inválido é solicitado
        when(addressServiceMock.getAddressByCep(invalidCep)).thenReturn(null);

        // Act
        Address actualAddress = addressController.getAddress(invalidCep); // Chama o método do controlador

        // Assert
        assertNull(actualAddress); // Verifica se o endereço retornado é nulo
        verify(addressServiceMock).getAddressByCep(invalidCep); // Verifica se o método do mock foi chamado com o CEP inválido
    }
}
