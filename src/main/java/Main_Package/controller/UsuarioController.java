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
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping
public class UsuarioController {


    @Autowired
    private FreelancerService freelancerService;
    
    @Autowired
    private ClienteService clienteService;

    @PostMapping("/save")
	public String save(@ModelAttribute Usuario usuario) {
    if (usuario.getRole() == role.FREELANCER) {
        Freelancer freelancer = new Freelancer();
        freelancer.setNome(usuario.getNome());
        freelancer.setEmail(usuario.getEmail());
        freelancer.setSenha(usuario.getSenha());
        freelancer.setDataNascimento(usuario.getDataNascimento());
        freelancer.setSexo(usuario.getSexo());
        freelancer.setCpf(usuario.getCpf());
        freelancer.setTelefone(usuario.getTelefone());
        freelancer.setRole(usuario.getRole());
        System.out.println("Salvando freelancer: " + freelancer.getEmail());
        freelancerService.save(freelancer);
    } else if (usuario.getRole() == role.CLIENTE) {
        Cliente cliente = new Cliente();
        cliente.setNome(usuario.getNome());
        cliente.setEmail(usuario.getEmail());
        cliente.setSenha(usuario.getSenha());
        cliente.setDataNascimento(usuario.getDataNascimento());
        cliente.setSexo(usuario.getSexo());
        cliente.setCpf(usuario.getCpf());
        cliente.setTelefone(usuario.getTelefone());
        cliente.setRole(usuario.getRole());
        clienteService.save(cliente);
    }
    return "redirect:/login";
}
	@GetMapping("/login")
	public String entrarConta() {
		return "login";
	}

	    public Usuario getUsuarioAutenticado(HttpSession session) {
	        return (Usuario) session.getAttribute("usuarioAutenticado");
	    }
		@GetMapping("/register")
		public String criarConta(Model modelo) {
		    modelo.addAttribute("usuario", new Usuario());
		    return "register";
		}


	}
/*
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */
