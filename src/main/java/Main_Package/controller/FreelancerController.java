package Main_Package.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Main_Package.model.Curriculo;
import Main_Package.model.Freelancer;
import Main_Package.model.Servico;
import Main_Package.repository.CurriculoRepository;
import Main_Package.repository.FreelancerRepository;
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
    
    @GetMapping("/{id}")
        public String paginaInicial_Free(@PathVariable Long id, Model model,Servico servico) {
            Optional<Freelancer> freelancerOpt = freelancerRepository.findById(id);
            if (freelancerOpt.isPresent()) {
            	List<Servico> servicos = servicoService.listarServico(servico); 
                model.addAttribute("servicos", servicos); 
                model.addAttribute("freelancer", freelancerOpt.get()); // Passando freelancer para o modelo
                return "freelancer-home";
            } else {
                return "redirect:/erro"; // Ou qualquer outra página caso o freelancer não seja encontrado
            }
        }


    @GetMapping("/curriculo/{id}")
    public String mostrarCurriculo(@PathVariable Long id, Model model) {
         Optional<Curriculo> curriculoOpt = curriculoService.mostraCurriculo(id); // Busca pelo mesmo ID do Freelancer
         if (curriculoOpt.isPresent()) {
             Curriculo curriculo = curriculoOpt.get();
             model.addAttribute("curriculo", curriculo);  // Adiciona o currículo ao modelo
             return "curriculo"; // Retorna a página do currículo
         } else {
             return "redirect:/curriculo/novo/" + id; // Redireciona se o currículo não for encontrado
         }
    }
    @GetMapping("/curriculo/novo/{id}")
    public String criarCurriculoForm(@PathVariable Long id, Model model) {
         Optional<Freelancer> freelancerOpt = freelancerRepository.findById(id);
         if (freelancerOpt.isPresent()) {
             Optional<Curriculo> curriculoOpt = curriculoRepository.findByFreelancerId(id);
             
             if (curriculoOpt.isPresent()) {
                 model.addAttribute("curriculo", curriculoOpt.get());  // Currículo existente
                 return "curriculo";
             } else {
                 Curriculo curriculo = new Curriculo();
                 curriculo.setFreelancer(freelancerOpt.get());  // Associa o Freelancer ao novo Currículo
                 model.addAttribute("freelancer", freelancerOpt.get());
                 model.addAttribute("curriculo", curriculo); // Passa o novo currículo
                 return "criar-curriculo";
             }
         } else {
             return "redirect:/usuario/freelancer/" + id;
         }
    }
    
    
    @PostMapping("/curriculo/salvar")
    public String salvarCurriculo(@ModelAttribute Curriculo curriculo, @RequestParam Long freelancerId) {
         Optional<Freelancer> freelancerOpt = freelancerRepository.findById(freelancerId);
         if (freelancerOpt.isPresent()) {
             curriculo.setFreelancer(freelancerOpt.get()); // Associa o freelancer ao currículo
             Curriculo savedCurriculo = curriculoService.save(curriculo);
             return "redirect:/curriculo/" + savedCurriculo.getId();
         } else {
             return "redirect:/erro";
         }
    }

    @GetMapping("/curriculo/editar/{id}")
    public String editarCurriculo(@PathVariable Long id, Model model) {
         Optional<Curriculo> curriculoOpt = curriculoService.mostraCurriculo(id);
         if (curriculoOpt.isPresent()) {
             model.addAttribute("curriculo", curriculoOpt.get());
             return "editar-curriculo";
         } else {
             return "redirect:/erro";
         }
    }

    @PostMapping("/curriculo/editar/salvar/{id}")
    public String salvarEdit(@PathVariable Long id, @ModelAttribute Curriculo curriculo) {
         curriculo.setId(id); // Define o ID do currículo como o ID do Freelancer
         curriculoService.save(curriculo);
         return "redirect:/usuario/freelancer/curriculo/" + id;
    }

	@PostMapping("/enviarCurriculo")
	public String enviarCurriculo(Long id){
	 	curriculoService.editaCurriculo(id);
	 	return "redirect:/usuario/freelancer";
	}

	
	@GetMapping("/perfil/{id}")
	public String mostrarPerfil(@PathVariable Long id){
	 	freelancerService.mostraFreelancer(id);
	 	return "perfil-freelancer";
	}
		
	@PutMapping("/perfil/editar/{id}")
	public String editarFreelancer(Long id){
	 	freelancerService.UpdateFreelancer(id);
	 	return "Pagina de editar freelancer";
	}
	
	@DeleteMapping("/perfil/{id}")
	public String deletarFreelancer(Long id){
	 	freelancerService.deletaFreelancer(id);
	 	return "redirect:/create-count";
	}
}


/*
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */
