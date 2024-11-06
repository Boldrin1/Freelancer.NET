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
import Main_Package.model.Usuario;
import Main_Package.repository.CurriculoRepository;
import Main_Package.repository.FreelancerRepository;
import Main_Package.service.CurriculoService;
import Main_Package.service.FreelancerService;
import Main_Package.service.ServicoService;
import jakarta.servlet.http.HttpSession;

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
    Optional<Curriculo> curriculoOpt = curriculoService.mostraCurriculo(id);
    if (curriculoOpt.isPresent()) {
        Curriculo curriculo = curriculoOpt.get();
        Long freelancerId = curriculo.getFreelancer() != null ? curriculo.getFreelancer().getId() : null;
        System.out.println("freelancerId recuperado do currículo: " + freelancerId);
        
        if (freelancerId != null) {
            model.addAttribute("curriculo", curriculo);  // Adicionando o curriculo ao modelo
            return "curriculo"; // Retorna a página curriculo
        } else {
            return "redirect:/erro"; // Página de erro caso freelancerId seja nulo
        }
    } else {
        return "redirect:/usuario/freelancer/curriculo/novo"; // Redireciona se o currículo não for encontrado
    }
}


@GetMapping("/curriculo/novo/{id}")
public String criarCurriculoForm(@PathVariable Long id, Model model) {
    // Procurar o Freelancer pelo ID
    Optional<Freelancer> freelancerOpt = freelancerRepository.findById(id);
    
    if (freelancerOpt.isPresent()) {
        // Verificar se já existe um Curriculo associado ao Freelancer
        Optional<Curriculo> curriculoOpt = curriculoRepository.findByFreelancerId(id);
        
        if (curriculoOpt.isPresent()) {
            // Se já existe, redireciona para a página do currículo
            model.addAttribute("curriculo", curriculoOpt.get());  // Passa o currículo existente para o modelo
            return "curriculo";  // Página do currículo
        } else {
            // Se não existir, cria um novo Curriculo
            model.addAttribute("freelancer", freelancerOpt.get());  // Passa o Freelancer para o modelo
            model.addAttribute("curriculo", new Curriculo());  // Cria um novo Curriculo
            return "criar-curriculo";  // Página para criar o currículo
        }
    } else {
        // Se o Freelancer não for encontrado, redireciona para uma página de erro ou página inicial
        return "redirect:/usuario/freelancer/" + id;  // Redireciona para a página inicial do freelancer
    }
}



    @PostMapping("/curriculo/salvar")
    public String salvarCurriculo(@ModelAttribute Curriculo curriculo, @RequestParam Long freelancerId) {
        Optional<Freelancer> freelancerOpt = freelancerRepository.findById(freelancerId);
        if (freelancerOpt.isPresent()) {
            curriculo.setFreelancer(freelancerOpt.get()); // Associa o freelancer ao currículo
            Curriculo savedCurriculo = curriculoService.save(curriculo); // Salva o currículo com o freelancer associado
            return "redirect:/usuario/freelancer/curriculo/" + savedCurriculo.getId();
        } else {
            return "redirect:/erro"; // Redireciona para uma página de erro se o freelancer não for encontrado
        }
    }


	
    @GetMapping("/curriculo/editar/{id}")
    public String editarCurriculo(@PathVariable Long id, Model model) {
       curriculoService.editaCurriculo(id);
        return "editar-curriculo"; // Nome do template
    }
	
    @PutMapping("/curriculo/editar/salvar/{id}")
    public String salvarEdit(@PathVariable Long id, @ModelAttribute Curriculo curriculo) {
        // Definir o ID no objeto Curriculo, caso ele precise ser atualizado antes de salvar
        curriculo.setId(id);
        
        // Salvar o currículo no serviço
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
