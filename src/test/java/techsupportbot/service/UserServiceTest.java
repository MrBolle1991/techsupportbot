package techsupportbot.service;

import com.example.techsupportbot.model.UserEntity;
import com.example.techsupportbot.repository.UserRepository;
import com.example.techsupportbot.service.UserService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSaveUser() {
        UserEntity user = new UserEntity();
        user.setUsername("testuser");
        user.setPassword("password");

        when(passwordEncoder.encode(anyString())).thenReturn("encodedPassword");
        when(userRepository.save(any(UserEntity.class))).thenReturn(user);

        UserEntity savedUser = userService.save(user);

        verify(passwordEncoder, times(1)).encode("password");
        verify(userRepository, times(1)).save(user);
        assertEquals("encodedPassword", savedUser.getPassword());
    }

    @Test
    public void testUsernameExists() {
        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(new UserEntity()));

        boolean exists = userService.usernameExists("testuser");

        verify(userRepository, times(1)).findByUsername("testuser");
        assertTrue(exists);
    }

    @Test
    public void testFindByUsername() {
        UserEntity user = new UserEntity();
        user.setUsername("testuser");

        when(userRepository.findByUsername(anyString())).thenReturn(Optional.of(user));

        Optional<UserEntity> foundUser = userService.findByUsername("testuser");

        verify(userRepository, times(1)).findByUsername("testuser");
        assertTrue(foundUser.isPresent());
        assertEquals("testuser", foundUser.get().getUsername());
    }
}
