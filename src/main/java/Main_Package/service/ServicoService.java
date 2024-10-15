package Main_Package.service;

import java.util.List;

import org.springframework.stereotype.Service;

import Main_Package.model.Servico;
import Main_Package.repository.ServicoRepository;

@Service
public class ServicoService {

	private ServicoRepository servicoRepository;
	
	
	public Servico criarServico(Servico servico) {
		return servicoRepository.save(servico);
	}
	
	public List<Servico> listarServico(Servico servico) {
		return servicoRepository.findAll();
	}
	
	public void deletarServico(Long id) {
		servicoRepository.deleteById(id);
	}
}
