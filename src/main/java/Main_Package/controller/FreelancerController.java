package Main_Package.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Main_Package.model.Servico;
import Main_Package.service.CurriculoService;
import Main_Package.service.FreelancerService;
import Main_Package.service.ServicoService;

@Controller
@RequestMapping("/usuario/freelancer")
public class FreelancerController {
   
	private FreelancerService freelancerService;
	
	private ServicoService servicoService;
	
	private CurriculoService curriculoService;
	
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
	
	@GetMapping
	public String paginaInicial_Free(Servico servico){
		servicoService.listarServico(servico);
		return "Pagina inicial dos freelancers que lista os serviços disponiveis";
	}
	
	@GetMapping("/curriculo/{id}")
	public String mostrarCurriculo(Long id) {
		curriculoService.mostraCurriculo(id);
		return "Pagina de curriculo";
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
}


/*
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */
