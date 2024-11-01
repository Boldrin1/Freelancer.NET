package Main_Package.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Main_Package.model.Usuario;
import Main_Package.service.UsuarioService;

@Controller
@RequestMapping
public class UsuarioController {
   
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("/registrar")
	public String criarConta() {
		return "register";
	}
	
	@PostMapping("/save")
	public String save(Usuario usuario) {
		usuarioService.saveUsuario(usuario);
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
