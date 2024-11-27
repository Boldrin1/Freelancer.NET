package Main_Package.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Main_Package.model.Freelancer;
import Main_Package.repository.FreelancerRepository;

@Service
public class FreelancerService {

	@Autowired
	private FreelancerRepository freelancerRepository;
	
	
	public Freelancer save(Freelancer freelancer) {
		Optional<Freelancer> emailExistente = freelancerRepository.findByEmail(freelancer.getEmail());
		if (emailExistente.isPresent()) {
            throw new IllegalArgumentException("O email já está cadastrado.");
        }
		return freelancerRepository.save(freelancer);
	}
	
	public Freelancer mostraFreelancer(Long id){
		return freelancerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Freelancer não encontrado"));
	}
	

	
	public Freelancer UpdateFreelancer(Long id, Freelancer freelancerAtualizado) {
	    Optional<Freelancer> freelancerOptional = freelancerRepository.findById(id);

	    if (freelancerOptional.isPresent()) {
	        Freelancer freelancerExistente = freelancerOptional.get();

	        // Atualize os campos com os valores do objeto atualizado
	        freelancerExistente.setNome(freelancerAtualizado.getNome());
	        freelancerExistente.setEmail(freelancerAtualizado.getEmail());
	        freelancerExistente.setSenha(freelancerAtualizado.getSenha());
	        freelancerExistente.setTelefone(freelancerAtualizado.getTelefone());

	        // Salve no banco de dados
	        return freelancerRepository.save(freelancerExistente);
	    } else {
	        throw new RuntimeException("Freelancer não encontrado");
	    }
	}

	
	public void deletaFreelancer(Long id) {
		freelancerRepository.deleteById(id);
	}
	
	public Optional<Freelancer> findByEmail(String email) {
        return freelancerRepository.findByEmail(email);
    }

	
	
}
