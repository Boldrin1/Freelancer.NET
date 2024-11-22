package Main_Package.config;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import Main_Package.model.Cliente;
import Main_Package.model.Freelancer;
import Main_Package.service.ClienteService;
import Main_Package.service.FreelancerService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private FreelancerService freelancerService;

	@Autowired
	private ClienteService clienteService;

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

    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = 
            http.getSharedObject(AuthenticationManagerBuilder.class);
        
        authenticationManagerBuilder
            .userDetailsService(email -> {
                if (email.startsWith("freelancer")) {
                    Freelancer freelancer = freelancerService.findByEmail(email);
                    return new User(freelancer.getEmail(), freelancer.getSenha(), new ArrayList<>());
                } else if (email.startsWith("cliente")) {
                    Cliente cliente = clienteService.findByEmail(email);
                    return new User(cliente.getEmail(), cliente.getSenha(), new ArrayList<>());
                }
                throw new UsernameNotFoundException("Usuário não encontrado: " + email);
            })
            .passwordEncoder(passwordEncoder());  // Usando o password encoder

        return authenticationManagerBuilder.build();  // Retorna a instância do AuthenticationManager
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