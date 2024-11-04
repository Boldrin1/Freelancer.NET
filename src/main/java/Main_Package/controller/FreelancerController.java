package Main_Package.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Main_Package.model.Curriculo;
import Main_Package.model.Servico;
import Main_Package.model.Usuario;
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


    @GetMapping("/{id}")
    public String paginaInicial_Free(@PathVariable Long id, Model model,Servico servico) {
        List<Servico> servicos = servicoService.listarServico(servico); 
        model.addAttribute("servicos", servicos); 
        model.addAttribute("freelancerId", id); 
        return "freelancer-home"; 
    }


    @GetMapping("/curriculo/{id}")
    public String mostrarCurriculo(@PathVariable Long id, Model model) {
        System.out.println("ID recebido: " + id);
        Optional<Curriculo> curriculoOpt = curriculoService.mostraCurriculo(id);

        if (curriculoOpt.isPresent()) {
            model.addAttribute("freelancerCurriculo", curriculoOpt.get());
            return "curriculo"; 
        } else {
            System.out.println("Currículo não encontrado para o ID: " + id);
            return "redirect:/usuario/freelancer/curriculo/novo"; 
        }
    }
    
    @GetMapping("/curriculo/novo")
    public String criarCurriculoForm(Model model) {
        model.addAttribute("freelancerCurriculo", new Curriculo()); 
        return "criar-curriculo"; 
    }

    @PostMapping("/curriculo/salvar")
    public String salvarCurriculo(Curriculo curriculo) {
    	curriculoService.save(curriculo);
    	return "redirect:/usuario/freelancer/curriculo/{id}";
    }

	@GetMapping("/curriculo/editar/{id}")
	public String editaCurriculo(Long id){
	    curriculoService.editaCurriculo(id);
		return "Pagina de editar curriculo";
	}
	
	@PostMapping("/enviarCurriculo")
	public String enviarCurriculo(Long id){
		curriculoService.editaCurriculo(id);
		return "redirect:/usuario/freelancer";
	}
	
	@GetMapping("/perfil/{id}")
	public String mostrarPerfil(Long id){
		freelancerService.mostraFreelancer(id);
		return "Perfil do Freelancer";
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
