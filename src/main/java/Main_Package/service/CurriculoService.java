package Main_Package.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import Main_Package.model.Curriculo;
import Main_Package.model.Freelancer;
import Main_Package.model.Servico;
import Main_Package.repository.CurriculoRepository;
import Main_Package.repository.FreelancerRepository;
import Main_Package.repository.ServicoRepository;

@Service
public class CurriculoService {

	@Autowired
	private CurriculoRepository curriculoRepository;
	
    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private ServicoRepository servicoRepository;

	
	public Optional<Curriculo> mostraCurriculo(Long id) {
		return curriculoRepository.findById(id);
	}
	
	public Curriculo editaCurriculo(Long id){
		Optional<Curriculo> curriculo = curriculoRepository.findById(id);
		
		if(curriculo.isPresent()) {
			Curriculo curriculoAtualizado = curriculo.get();
			curriculoAtualizado.setCompetencias(curriculoAtualizado.getCompetencias()); 
			curriculoAtualizado.setExperiencias(curriculoAtualizado.getExperiencias());
			curriculoAtualizado.setFormacaoAcademica(curriculoAtualizado.getFormacaoAcademica());
			return curriculoRepository.save(curriculoAtualizado);
		}else {
			throw new RuntimeException("Curriculo não encontrado");
		}
	}
	
    public ResponseEntity<String> enviarCurriculo(@RequestParam Long freelancerId, @RequestParam Long servicoId, @RequestBody Curriculo curriculo) {
        // Encontrar o freelancer e o serviço pelos IDs
        Freelancer freelancer = freelancerRepository.findById(freelancerId)
        	.orElseThrow(() -> new RuntimeException("Freelancer não encontrado"));
        Servico servico = servicoRepository.findById(servicoId)
        	.orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        // Associar o currículo ao freelancer e ao serviço
        curriculo.setFreelancer(freelancer);
        curriculo.setServico(servico);

        // Salvar o currículo no banco de dados
        curriculoRepository.save(curriculo);

        return ResponseEntity.ok("Currículo enviado com sucesso!");
    }
}