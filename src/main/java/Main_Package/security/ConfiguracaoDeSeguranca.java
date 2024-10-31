package Main_Package.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.RequestMatcher;

import Main_Package.service.DetalhesUsuarioService;



@Configuration
@EnableWebSecurity
public class ConfiguracaoDeSeguranca {

	private final DetalhesUsuarioService detalhesUsuarioService;
	
	
	public ConfiguracaoSeguranca(DetalhesUsuarioService detalhesUsuarioService) {
		this.detalhesUsuarioService = detalhesUsuarioService;
	}
	
	@Bean
	public BCryptPasswordEncoder encoderSenha() {
		return new BCryptPasswordEncoder();
	}



	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((authorize)->
				authorize
					.requestMatchers("/login", "/registrar").permitAll()
					.requestMatchers("css/**").permitAll()
					.anyRequest().authenticated()
					)
			.formLogin((form)->
				form
					.loginPage("/login")
					.defaultSuccessUrl("/home", true)
					.permitAll()
					)
			.logout((logout) ->
				logout
					.logoutUrl("/logout")
					.logoutSuccessUrl("/login?logout")
					.invalidateHttpSession(true)
					.deleteCookies("JSESSIONID")
					.permitAll()
					);
		
		return http.build();
	}
}