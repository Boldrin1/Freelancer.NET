package Main_Package.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Main_Package.model.Usuario;
import Main_Package.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
   
	
	private UsuarioService usuarioService;
	
	@PostMapping("/create-count")
	public String criarConta(Usuario usuario) {
		usuarioService.saveUsuario(usuario);
		return "Pagina de Registro";
	}
	
	
}





/*
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */
