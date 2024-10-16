package Main_Package.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Main_Package.model.Servico;
import Main_Package.service.ServicoService;

@Controller
@RequestMapping("/usuario/cliente")
public class ServicoController {
	
	private ServicoService servicoService;

	@GetMapping("/servicos")
	public String listarServicos(Servico servico){
		servicoService.listarServico(servico);
		return "Pagina de servicos do cliente";
	}
	
	@PostMapping("/servicos/newServico")
	public String criarServico(Servico servico) {
		servicoService.criarServico(servico);
		return "Pagina de Criar um novo serciço";
	}
	
	@DeleteMapping("/{id}")
	public String deletaServico(Long id) {
		servicoService.deletarServico(id);
		return "redirect:/servicos";
	}
	
}


/*
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */
