package Main_Package.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Main_Package.model.Cliente;
import Main_Package.model.Curriculo;
import Main_Package.service.ClienteService;
import Main_Package.service.CurriculoService;
import Main_Package.service.FreelancerService;


@Controller
@RequestMapping("/usuario/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	@Autowired
	private CurriculoService curriculoService;
	
	@GetMapping("/{id}")
	public String paginaInicial_Cliente(@PathVariable Long id, Model model, Curriculo curriculo) {
	    Cliente cliente = clienteService.mostrarCliente(id);
	    List<Curriculo> curriculos = curriculoService.listarCurriculo(curriculo);

	    // Adicione o objeto completo "cliente" ao modelo
	    model.addAttribute("cliente", cliente);
	    model.addAttribute("curriculo", curriculos);

	    return "cliente-home";
	}

	
	@GetMapping("/view-curriculo/{id}")
	public String viewCurriculo(@PathVariable Long id, Model model) {
	    Optional<Curriculo> curriculo = curriculoService.mostraCurriculo(id);
	    if (curriculo.isPresent()) {
	        Curriculo curriculo2 = curriculo.get();

	        model.addAttribute("curriculo", curriculo2);
	        return "view-curriculo";
	    } else {
	        return "erro"; 
	    }
	}



	
	@GetMapping("/perfil/{id}")
	public String mostrarCliente(Long id) {
		clienteService.mostrarCliente(id);
		return "vizualizar perfil do Cliente";
	}
	
	@PutMapping("/perfil/editar/{id}")
	public String editarDados(Long id) {
		clienteService.UpdateCliente(id);
		return "Pagina de editar dados do Cliente";
	}
	
	@DeleteMapping("/perfil/{id}")
	public String excluirCliente(Long id) {
		return "redirect:/create-count";
	}
	

}


/*
 * 	O cliente vai ver serviços e o freelancer vai ver trabalhos disponiveis
 * 
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */