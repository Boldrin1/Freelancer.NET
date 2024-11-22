package Main_Package.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import Main_Package.model.Cliente;
import Main_Package.model.Freelancer;
import Main_Package.service.ClienteService;
import Main_Package.service.FreelancerService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler{

	 @Autowired
	    private FreelancerService freelancerService;

	    @Autowired
	    private ClienteService clienteService;

	    @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
	            throws IOException, ServletException {
	        String username = authentication.getName();  // Obtém o nome de usuário (email)

	        // Verifica o tipo de usuário (Cliente ou Freelancer)
	        if (username.startsWith("freelancer")) {
	            Freelancer freelancer = freelancerService.findByEmail(username);
	            response.sendRedirect("/usuario/freelancer/" + freelancer.getId());  // Redireciona para o perfil do freelancer
	        } else if (username.startsWith("cliente")) {
	            Cliente cliente = clienteService.findByEmail(username);
	            response.sendRedirect("/usuario/cliente/" + cliente.getId());  // Redireciona para o perfil do cliente
	        } else {
	            response.sendRedirect("/home");  // Redireciona para a página padrão caso o tipo não seja identificado
	        }
	    }
}
