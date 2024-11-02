package Main_Package.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Main_Package.model.Cliente;
import Main_Package.model.Freelancer;
import Main_Package.model.Usuario;
import Main_Package.model.role;
import Main_Package.service.ClienteService;
import Main_Package.service.FreelancerService;


@Controller
@RequestMapping
public class UsuarioController {
   

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private FreelancerService frelancerSerivce;
	
	@GetMapping("/registrar")
	public String criarConta(Model modelo) {
		modelo.addAttribute("usuario",new Usuario());
		return "register";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Usuario usuario,Freelancer freelancer,Cliente cliente) {
		  if (usuario.getRole() == role.FREELANCER) {
			  frelancerSerivce.save(freelancer);
		    } else if (usuario.getRole() == role.CLIENTE) {
		    	clienteService.save(cliente);
		    }

		    // Salve o usuário no banco
		    return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String entrarConta() {
		return "login";
	}
	
}





/*
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */
