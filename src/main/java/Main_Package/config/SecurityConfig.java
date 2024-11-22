package Main_Package.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authorize) ->
                authorize
                    .requestMatchers("/login", "/register","/css/**", "/js/**", "/img/**").permitAll()  // Permite acesso às páginas de login e registro
                    .anyRequest().authenticated()  // Requer autenticação para qualquer outra página
            )
            .formLogin((form) ->
                form
                    .loginPage("/login")  // Define a página de login personalizada
                    .loginProcessingUrl("/login-verificar")  // Define o URL de processamento do login
                    .defaultSuccessUrl("/home", true)  // Redireciona para /home após login bem-sucedido
                    .permitAll()
            )
            .logout((logout) ->
                logout
                    .logoutUrl("/logout")  // URL para logout
                    .logoutSuccessUrl("/login?logout")  // Redireciona para a página de login após o logout
                    .invalidateHttpSession(true)  // Invalida a sessão
                    .deleteCookies("JSESSIONID")  // Exclui o cookie de sessão
                    .permitAll()
            );

        return http.build();
    }
}
