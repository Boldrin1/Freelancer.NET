package Main_Package.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Main_Package.model.AreaDeInteresse;
import Main_Package.model.Curriculo;
import Main_Package.model.Freelancer;
import Main_Package.model.Servico;
import Main_Package.model.ServicoCurriculo;
import Main_Package.repository.CurriculoRepository;
import Main_Package.repository.FreelancerRepository;
import Main_Package.repository.ServicoCurriculoRepository;
import Main_Package.repository.ServicoRepository;
import Main_Package.service.CurriculoService;
import Main_Package.service.FreelancerService;
import Main_Package.service.ServicoService;

@Controller
@RequestMapping("/usuario/freelancer")
public class FreelancerController {

    @Autowired
    private FreelancerService freelancerService;
    
    @Autowired
    private ServicoService servicoService;
    
    @Autowired
    private CurriculoService curriculoService;
    
    @Autowired
    private FreelancerRepository freelancerRepository;
    
    @Autowired
    private CurriculoRepository curriculoRepository;
    
    @Autowired
    private  ServicoCurriculoRepository servicoCurriculoRepository;
    
    @Autowired
    private ServicoRepository servicoRepository;
    
    
    
    @GetMapping("/{id}")
    public String paginaInicial_Free(@PathVariable Long id, Model model) {
            Optional<Freelancer> freelancerOpt = freelancerRepository.findById(id);
            if (freelancerOpt.isPresent()) {
            	List<Servico> servicos = servicoService.listarServico(); 
                model.addAttribute("servicos", servicos); 
                model.addAttribute("freelancer", freelancerOpt.get()); 
                return "freelancer-home";
            } else {
                return "redirect:/erro"; 
            }
        }


    @GetMapping("/curriculo/{id}")
    public String criarCurriculoForm(@PathVariable Long id, Model model) {
        Optional<Freelancer> freelancerOpt = freelancerRepository.findById(id);
        if (freelancerOpt.isPresent()) {
            Freelancer freelancer = freelancerOpt.get();
            model.addAttribute("freelancer", freelancer); 
            
            Optional<Curriculo> curriculoOpt = curriculoRepository.findByFreelancerId(id);
            if (curriculoOpt.isPresent()) {
                model.addAttribute("curriculo", curriculoOpt.get());
                return "curriculo";
            } else {
                Curriculo curriculo = new Curriculo();
                curriculo.setFreelancer(freelancer);
                model.addAttribute("curriculo", curriculo);
                model.addAttribute("areasDeInteresse", AreaDeInteresse.values());
                return "curriculo-criar";
            }
        } else {
            return "redirect:/usuario/freelancer/" + id;
        }
    }

    
    @PostMapping("/curriculo/salvar")
    public String salvarCurriculo(@ModelAttribute Curriculo curriculo, @RequestParam Long freelancerId,Model model) {
         Optional<Freelancer> freelancerOpt = freelancerRepository.findById(freelancerId);
         if (freelancerOpt.isPresent()) {
             curriculo.setFreelancer(freelancerOpt.get()); 
             Curriculo savedCurriculo = curriculoService.save(curriculo);

             return "redirect:/usuario/freelancer/curriculo/" + savedCurriculo.getId();
         } else {
             return "redirect:/erro";
         }
    }

    @GetMapping("/curriculo/editar/{id}")
    public String editarCurriculo(@PathVariable Long id, Model model) {
        Optional<Curriculo> curriculoOpt = curriculoService.mostraCurriculo(id);
        AreaDeInteresse[] areasDeInteresse = AreaDeInteresse.values(); 

        if (curriculoOpt.isPresent()) {
            model.addAttribute("curriculo", curriculoOpt.get());
            model.addAttribute("areasDeInteresse", areasDeInteresse);
            return "curriculo-editar";
        } else {
            return "redirect:/erro";
        }
    }


    @PostMapping("/curriculo/editar/salvar/{id}")
    public String salvarEdit(@PathVariable Long id, @ModelAttribute Curriculo curriculo) {
         curriculo.setId(id);
         curriculoService.save(curriculo);
         return "redirect:/usuario/freelancer/curriculo/" + id;
    }
	
	@GetMapping("/perfil/{id}")
	public String mostrarPerfil(@PathVariable Long id,Model model){
		Freelancer freelancer = freelancerService.mostraFreelancer(id);
		model.addAttribute("freelancer",freelancer);
	 	return "freelancer-perfil";
	}
		
	@GetMapping("/perfil/editar/{id}")
	public String editarFreelancer(@PathVariable Long id,Model model){
		Freelancer freelancer = freelancerService.mostraFreelancer(id);
	 	model.addAttribute("freelancer", freelancer);
	 	return "freelancer-editar";
	}
	
	@PostMapping("/perfil/editar/salvar/{id}")
	public String salvarEditar(@PathVariable Long id, @ModelAttribute Freelancer freelancerAtualizado ) {
		freelancerService.UpdateFreelancer(id,freelancerAtualizado);
		return "redirect:/usuario/freelancer/perfil/" + freelancerAtualizado.getId();
	}
	

	
	@DeleteMapping("/perfil/{id}")
	public String deletarFreelancer(Long id){
	 	freelancerService.deletaFreelancer(id);
	 	return "redirect:/create-count";
	}
	
	
	
	@PostMapping("/{servicoId}/enviar-curriculo")
    public ResponseEntity<?> enviarCurriculo(
            @PathVariable Long servicoId,
            @RequestParam Long freelancerId) {

        Curriculo curriculo = curriculoRepository.findByFreelancer_Id(freelancerId)
                .orElseThrow(() -> new RuntimeException("Currículo não encontrado"));

        Servico servico = servicoRepository.findById(servicoId)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado"));

        ServicoCurriculo servicoCurriculo = new ServicoCurriculo();
        servicoCurriculo.setServico(servico);
        servicoCurriculo.setCurriculo(curriculo);

        servicoCurriculoRepository.save(servicoCurriculo);

        return ResponseEntity.ok("Currículo enviado com sucesso!");
    }
	
	
}


/*
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */
