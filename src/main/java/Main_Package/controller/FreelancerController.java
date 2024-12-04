package Main_Package.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Main_Package.model.AreaDeInteresse;
import Main_Package.model.Cliente;
import Main_Package.model.Curriculo;
import Main_Package.model.Freelancer;
import Main_Package.model.Proposta;
import Main_Package.model.Servico;
import Main_Package.model.ServicoCurriculo;
import Main_Package.repository.CurriculoRepository;
import Main_Package.repository.FreelancerRepository;
import Main_Package.repository.PropostaRepository;
import Main_Package.repository.ServicoCurriculoRepository;
import Main_Package.repository.ServicoRepository;
import Main_Package.service.ClienteService;
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
    
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private ClienteService clienteService;
    
    
    
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
		Optional<Curriculo> curriculo = curriculoService.mostraCurriculo(id);


		Freelancer freelancer = freelancerService.mostraFreelancer(id);
		model.addAttribute("freelancer",freelancer);
		model.addAttribute("curriculo", curriculo);
		
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
	
	@PostMapping("/{servicoId}/enviar-curriculo")
	public String enviarCurriculo(
	        @PathVariable Long servicoId,
	        @RequestParam Long freelancerId,
	        Model model) {

	    Curriculo curriculo = curriculoRepository.findByFreelancer_Id(freelancerId)
	            .orElse(null);
	    if (curriculo == null) {
	        model.addAttribute("error", "Currículo não encontrado.");
	        return "redirect:/usuario/freelancer/curriculo/" + freelancerId; 
	    }

	    Servico servico = servicoRepository.findById(servicoId)
	            .orElse(null);
	    if (servico == null) {
	        model.addAttribute("error", "Serviço não encontrado.");
	        return "freelancer-error-page"; 
	    }

	   
	    if (servicoCurriculoRepository.existsByServicoIdAndCurriculoId(servicoId, curriculo.getId())) {
	        model.addAttribute("error", "Currículo já enviado para este serviço.");
	        return "freelancer-error-page"; 
	    }

	    
	    ServicoCurriculo servicoCurriculo = new ServicoCurriculo();
	    servicoCurriculo.setServico(servico);
	    servicoCurriculo.setCurriculo(curriculo);
	    servicoCurriculoRepository.save(servicoCurriculo);

	    model.addAttribute("success", "Currículo enviado com sucesso!");
	    return "redirect:/usuario/freelancer/" + freelancerId; 
	}

	
	@GetMapping("/inbox/view-proposta/{propostaId}")
	public String freelancerViewCurriculo(@PathVariable Long propostaId,
	                                      @RequestParam Long clienteId,
	                                      Model model) {
	    Cliente cliente = clienteService.mostrarCliente(clienteId);
	    Proposta proposta = propostaRepository.findById(propostaId)
	    		.orElseThrow(() -> new RuntimeException("Freelancer não encontrado"));
	    model.addAttribute("cliente", cliente);
	    model.addAttribute("proposta", proposta);
	    return "freelancer-Visu-Proposta";
	}

	
}


/*
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */
