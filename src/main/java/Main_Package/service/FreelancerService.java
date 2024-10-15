package Main_Package.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import Main_Package.model.Freelancer;
import Main_Package.repository.FreelancerRepository;

@Service
public class FreelancerService {

	private FreelancerRepository freelancerRepository;
	
	public Optional<Freelancer> mostraFreelancer(Long id){
		return freelancerRepository.findById(id);
	}
	
	public Freelancer UpdateFreelancer(Long id){
		Optional<Freelancer> freelancer = freelancerRepository.findById(id);
		
		if(freelancer.isPresent()) {
			//a variavel FreelancerAtualizado esta com os parametros(variaveis) da classe Freelancer, idai ela ta recebendo os valores que o Optional<Freelancer> freelancer achou relacionado ao id
			Freelancer freelancerAtualizado = freelancer.get();
			freelancerAtualizado.setNome(freelancerAtualizado.getNome());
			freelancerAtualizado.setEmail(freelancerAtualizado.getEmail());
			freelancerAtualizado.setSenha(freelancerAtualizado.getSenha());
			freelancerAtualizado.setTelefone(freelancerAtualizado.getTelefone());
			return freelancerRepository.save(freelancerAtualizado);
		}else {
			throw new RuntimeException("Cliente não encontrado");
		}
	}
	
	public void deletaFreelancer(Long id) {
		freelancerRepository.deleteById(id);
	}
}
