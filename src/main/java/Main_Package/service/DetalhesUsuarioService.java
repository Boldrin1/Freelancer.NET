package Main_Package.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Main_Package.model.Cliente;
import Main_Package.model.Freelancer;
import Main_Package.repository.ClienteRepository;
import Main_Package.repository.FreelancerRepository;

@Service
public class DetalhesUsuarioService implements UserDetailsService {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Freelancer> freelancer = freelancerRepository.findByEmail(email);
        if (freelancer.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                freelancer.get().getEmail(), // username
                freelancer.get().getSenha(), // password
                new ArrayList<>()  // Authorities/roles (se houver)
            );
        }

        // Tentando buscar cliente pelo email
        Optional<Cliente> cliente = clienteRepository.findByEmail(email);
        if (cliente.isPresent()) {
            return new org.springframework.security.core.userdetails.User(
                cliente.get().getEmail(), // username
                cliente.get().getSenha(), // password
                new ArrayList<>()  // Authorities/roles (se houver)
            );
        }

        // Se não encontrar o usuário, lança a exceção
        throw new UsernameNotFoundException("Usuário não encontrado com email: " + email);
    }
}