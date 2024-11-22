package Main_Package.config;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import Main_Package.model.Cliente;
import Main_Package.model.Freelancer;
import Main_Package.service.ClienteService;
import Main_Package.service.FreelancerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private FreelancerService freelancerService;

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Implementação personalizada que não codifica a senha
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();  // Não faz nada com a senha
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);  // Compara a senha diretamente
            }
        };
    }
    

    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String username = authentication.getName(); 
        // Busca no FreelancerService
        Optional<Freelancer> freelancerOptional = freelancerService.findByEmail(username);
        // Busca no ClienteService
        Optional<Cliente> clienteOptional = clienteService.findByEmail(username);

        // Verifica se o Freelancer foi encontrado
        if (freelancerOptional.isPresent()) {
            Freelancer freelancer = freelancerOptional.get(); 
            response.sendRedirect("/usuario/freelancer/" + freelancer.getId()); 
        } 
        // Verifica se o Cliente foi encontrado
        else if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();  
            response.sendRedirect("/usuario/cliente/" + cliente.getId());  
        } 
        // Caso o usuário não seja encontrado
        else {
            response.sendRedirect("/home");
        }
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/login", "/register", "/css/**", "/js/**", "/img/**", "/save").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .loginProcessingUrl("/login-verificar")
                .successHandler(customAuthenticationSuccessHandler)  // Usando o handler personalizado
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );

        return http.build();
    }
}