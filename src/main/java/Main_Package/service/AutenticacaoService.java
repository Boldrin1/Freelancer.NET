package Main_Package.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main_Package.model.Cliente;
import Main_Package.model.Freelancer;
import Main_Package.model.Usuario;
import Main_Package.repository.ClienteRepository;
import Main_Package.repository.FreelancerRepository;


//Serviço de Autenticação
@Service
public class AutenticacaoService {

 @Autowired
 private FreelancerRepository freelancerRepository;

 @Autowired
 private ClienteRepository clienteRepository;


 
 public Usuario autenticar(String email, String senha) {
     // Primeiro, verifica na tabela de freelancers
     Optional<Freelancer> freelancerOpt = freelancerRepository.findByEmailAndSenha(email, senha);
     if (freelancerOpt.isPresent()) {
         return freelancerOpt.get();
     }

     // Se não encontrar o freelancer, verifica na tabela de clientes
     Optional<Cliente> clienteOpt = clienteRepository.findByEmailAndSenha(email, senha);
     if (clienteOpt.isPresent()) {
         return clienteOpt.get();
     }

     // Retorna null se as credenciais forem inválidas
     return null;
 }
 
 
}

