package Main_Package.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	public Cliente updateCliente(Long id, Cliente novosDados) {
	    Optional<Cliente> clienteExistente = clienteRepository.findById(id);
	    
	    if (clienteExistente.isPresent()) {
	        Cliente clienteAtualizado = clienteExistente.get();
	        // Atualize os campos com os novos dados
	        clienteAtualizado.setNome(novosDados.getNome());
	        clienteAtualizado.setEmail(novosDados.getEmail());
	        clienteAtualizado.setSenha(novosDados.getSenha());
	        clienteAtualizado.setTelefone(novosDados.getTelefone());
	        
	        return clienteRepository.save(clienteAtualizado); // Salve as alterações
	    } else {
	        throw new RuntimeException("Cliente não encontrado");
	    }
	}

	
    public void deleteCliente(Long id){
    	clienteRepository.deleteById(id);
    }

    public Optional<Cliente> findByEmail(String email) {
        return clienteRepository.findByEmail(email);
    }


        
    }

		