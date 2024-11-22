package Main_Package.config;

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

import java.io.IOException;
import java.util.Optional;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private FreelancerService freelancerService;

    @Autowired
    private ClienteService clienteService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        String username = authentication.getName(); 

        Optional<Freelancer> freelancerOptional = freelancerService.findByEmail(username);
        if (freelancerOptional.isPresent()) {
            Freelancer freelancer = freelancerOptional.get();
            System.out.println("Freelancer encontrado: " + freelancer.getNome());
            response.sendRedirect("/usuario/freelancer/" + freelancer.getId());  
            return;
        }

        // Verifica se o usuário é cliente
        Optional<Cliente> clienteOptional = clienteService.findByEmail(username);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            System.out.println("Cliente encontrado: " + cliente.getNome());
            response.sendRedirect("/usuario/cliente/" + cliente.getId()); 
            return;
        }

    }
}