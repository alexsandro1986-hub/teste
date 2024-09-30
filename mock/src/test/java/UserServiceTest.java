import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.User;
import com.example.UserRepository;
import com.example.UserService;

public class UserServiceTest {

    @Test
    public void testAddUser_UserDoesNotExist() {
        // Arrange
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(mockRepository);
        User user = new User("John Doe", "john.doe@example.com");

        
        Mockito.when(mockRepository.userExists(user.getEmail())).thenReturn(false);

       
        String result = userService.addUser(user);

        
        assertEquals("User added successfully.", result);
        Mockito.verify(mockRepository).addUser(user); 
    }

    @Test
    public void testAddUser_UserExists() {
        
        UserRepository mockRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(mockRepository);
        User user = new User("Jane Doe", "jane.doe@example.com");

       
        Mockito.when(mockRepository.userExists(user.getEmail())).thenReturn(true);

       
        String result = userService.addUser(user);

        
        assertEquals("User already exists.", result);
        Mockito.verify(mockRepository, Mockito.never()).addUser(user); 
    }
}
