package Main_Package.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main_Package.model.Cliente;
import Main_Package.model.Curriculo;
import Main_Package.model.Freelancer;
import Main_Package.model.Proposta;
import Main_Package.repository.ClienteRepository;
import Main_Package.repository.CurriculoRepository;
import Main_Package.repository.FreelancerRepository;
import Main_Package.repository.PropostaRepository;

@Service
public class PropostaService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private FreelancerRepository freelancerRepository;
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private CurriculoRepository curriculoRepository;

	public Proposta enviarProposta(Long clienteId, Long freelancerId, String propostaText) {
	    Cliente cliente = clienteRepository.findById(clienteId)
	            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
	    Freelancer freelancer = freelancerRepository.findById(freelancerId)
	            .orElseThrow(() -> new RuntimeException("Freelancer não encontrado"));

	    Curriculo curriculo = curriculoRepository.findByFreelancerId(freelancerId)
	            .orElseThrow(() -> new RuntimeException("Currículo não encontrado"));

	    Proposta proposta = new Proposta();
	    proposta.setCliente(cliente);
	    proposta.setFreelancer(freelancer);
	    proposta.setCurriculo(curriculo); // Preencha o campo `curriculo`
	    proposta.setPropostaText(propostaText);

	    return propostaRepository.save(proposta);
	}



    public List<Proposta> listarPropostasFreelancer(Long freelancerId) {
    	 List<Proposta> propostas = propostaRepository.findByFreelancer_Id(freelancerId);
    	    propostas.forEach(proposta -> {
    	        proposta.getCliente().getNome(); 
    	    });

    	    return propostas;
    }

    public List<Proposta> listarPropostasCliente(Long clienteId) {
        return propostaRepository.findByCliente_Id(clienteId);
    }

}