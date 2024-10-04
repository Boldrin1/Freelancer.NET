package Main_Package.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

	@Value("${projeto.jwtSecret}")
	private String jwtSecret;
	
	@Value("${projeto.jweExpirationMs}")
	private int jwtExpirationMs;
	
	public String generateTokenFromUserDetailsImpl(UserDetailsImpl userData) {
		
	}
}
