package techsupportbot.config;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.techsupportbot.config.PasswordEncoderUtil;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordEncoderUtilTest {

    @Test
    public void testEncodePassword() {
        String rawPassword = "password";
        String encodedPassword = PasswordEncoderUtil.encodePassword(rawPassword);

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        assertTrue(passwordEncoder.matches(rawPassword, encodedPassword));
    }

    @Test
    public void testMatches() {
        String rawPassword = "password";
        String encodedPassword = PasswordEncoderUtil.encodePassword(rawPassword);

        assertTrue(PasswordEncoderUtil.matches(rawPassword, encodedPassword));
    }
}
