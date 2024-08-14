package techsupportbot.config;

import com.example.techsupportbot.TechSupportBotApplication; // Ensure this import points to your main application class
import com.example.techsupportbot.config.SecurityConfig;
import com.example.techsupportbot.service.CustomUserDetailsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@SpringBootTest(classes = TechSupportBotApplication.class)
public class SecurityConfigTest {

    @Mock
    private CustomUserDetailsService customUserDetailsService;

    @InjectMocks
    private SecurityConfig securityConfig;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticationProvider() {
        DaoAuthenticationProvider provider = securityConfig.authenticationProvider();
        assert provider != null;
        verify(customUserDetailsService, never()).loadUserByUsername(anyString());
    }
}
