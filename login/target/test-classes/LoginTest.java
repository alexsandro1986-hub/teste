
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.example.Login;

public class LoginTest {
    
   Login LoginWill = new Login("will@gmail.com", "123123");
   Login LoginElle = new Login("elle@gmail.com", "123" );

  @Test
  public void objectNotNullTest(){
    assertNotNull(LoginWill);
  }

  @Test 
  public void confirmPasswordEqualsPassword_shouldReturnTrue(){
    assertTrue(LoginWill.getPassword() == "123123");
  }

  @Test
  public void confirmPasswordNotEqualToPassword_shouldReturnFalse(){
    assertFalse(LoginElle.getPassword() == "123123");
  }

  @Test 
  public void LogOnWithCorrectEmail_shouldReturnTrue(){
    assertTrue(LoginWill.LogOn("will@gmail.com", "123123"));
  }

}
