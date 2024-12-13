package Main_Package.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import Main_Package.model.Cliente;
import Main_Package.model.Freelancer;
import Main_Package.model.Servico;
import Main_Package.service.ClienteService;
import Main_Package.service.FreelancerService;
import Main_Package.service.ServicoService;


@Controller
@RequestMapping("/servico")
public class ServiceController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private FreelancerService freelancerService;

	@GetMapping("/freelancer/visualizar/{id}")
	public String vizualizarServico(@PathVariable Long id, Model model, Principal principal) {
	    Optional<Servico> servicoOptional = servicoService.encontrarServico(id);

	    if (servicoOptional.isPresent()) {
	        Servico servico = servicoOptional.get();

	        // Buscar o freelancer logado pelo e-mail (modificado para usar o e-mail)
	        Freelancer freelancer = freelancerService.mostraFreelancer(principal.getName()); // Passa o e-mail aqui

	        model.addAttribute("servico", servico);
	        model.addAttribute("freelancer", freelancer);

	        return "freelancer-Visu-Servico";
	    } else {
	        return "redirect:/erro/servico-nao-encontrado";
	    }
	}


	
	@GetMapping("/cliente/visualizar/{id}")
	public String vizualizarClienteServico(@PathVariable Long id, Model model) {
	    Optional<Servico> servicoOptional = servicoService.encontrarServico(id);
	    
	    if (servicoOptional.isPresent()) {
	        Servico servico = servicoOptional.get();
	        model.addAttribute("servico", servico); 
	        return "cliente-vizu-servico";
	    } else {
	        return "redirect:/erro"; 
	    }
	}

	
	@GetMapping("/novo/{id}")
	public String novoServico(@PathVariable Long id, Model model) {
	    Cliente cliente = clienteService.mostrarCliente(id);
	    Servico servico = new Servico();
	    servico.setCliente(cliente);
	    model.addAttribute("servico", servico);
	    model.addAttribute("clienteId", id); // Adiciona o ID ao modelo
	    return "servico-novo";
	}

	
	@PostMapping("/salvar/{id}")
	public String salvarServico(@PathVariable Long id, Servico servico2) {
	    Cliente cliente = clienteService.mostrarCliente(id);

	    servico2.setCliente(cliente);
	    
	    servicoService.criarServico(servico2);
	    
	    return "redirect:/usuario/cliente/servicos/" + cliente.getId();
	}

	
	@GetMapping("/excluir/{id}")
	public String excluirServico(@PathVariable Long id) {
	    // Busca o serviço pelo ID
	    Optional<Servico> servicoOptional = servicoService.encontrarServico(id);
	    
	    if (servicoOptional.isPresent()) {
	        Servico servico = servicoOptional.get();
	        Cliente cliente = servico.getCliente(); 
	        servicoService.deletarServico(id); 
	        return "redirect:/usuario/cliente/servicos/" + cliente.getId(); 
	    } else {
	        throw new RuntimeException("Serviço não encontrado."); 
	    }
	}


	
}


/*
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */

