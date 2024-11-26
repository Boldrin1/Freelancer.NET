package Main_Package.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Main_Package.model.Cliente;
import Main_Package.model.Freelancer;
import Main_Package.model.Proposta;
import Main_Package.repository.PropostaRepository;

@Service
public class PropostaService {

	@Autowired
	private PropostaRepository propostaRepository;

	public Proposta enviarProposta(Long clienteId, Long freelancerId, String conteudoProposta) {
        Proposta proposta = new Proposta();
        proposta.setPropostaText(conteudoProposta);
        proposta.setCliente(new Cliente(clienteId)); // Instancie o cliente pelo ID
        proposta.setFreelancer(new Freelancer(freelancerId)); // Instancie o freelancer pelo ID
        return propostaRepository.save(proposta);
    }

    public List<Proposta> listarPropostasFreelancer(Long freelancerId) {
        return propostaRepository.findByFreelancer_Id(freelancerId);
    }

    public List<Proposta> listarPropostasCliente(Long clienteId) {
        return propostaRepository.findByCliente_Id(clienteId);
    }

}