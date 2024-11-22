package Main_Package.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import Main_Package.model.Cliente;
import Main_Package.repository.ClienteRepository;

@Service
public class ClienteService {
  
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente save(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Cliente mostrarCliente(Long id){
		return clienteRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Cliente não encontrado "));
	}
	
    public Cliente UpdateCliente(Long id){
		
		Optional<Cliente> cliente = clienteRepository.findById(id);
		
		if(cliente.isPresent()){
			Cliente clienteAtualizado = cliente.get();
			clienteAtualizado.setNome(clienteAtualizado.getNome());
			clienteAtualizado.setEmail(clienteAtualizado.getEmail());
			clienteAtualizado.setSenha(clienteAtualizado.getSenha());
			clienteAtualizado.setTelefone(clienteAtualizado.getTelefone());
			return clienteRepository.save(clienteAtualizado);
		}else {
			throw new RuntimeException("Cliente não encontrado");
		}
		
	}
	
    public void deleteCliente(Long id){
    	clienteRepository.deleteById(id);
    }


        public Cliente findByEmail(String email) {
            return clienteRepository.findByEmail(email)
                    .orElseThrow(() -> new UsernameNotFoundException("Cliente com email " + email + " não encontrado"));
        }
    }

		