package Main_Package.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Main_Package.model.Cliente;
import Main_Package.model.Proposta;
import Main_Package.repository.PropostaRepository;
import Main_Package.service.ClienteService;
import Main_Package.service.PropostaService;

@Controller
@RequestMapping("/proposta")
public class PropostaController {

	    @Autowired
	    private PropostaService propostaService;
	    
	    @Autowired
	    private ClienteService clienteService;

	    // Endpoint para enviar proposta
	    @PostMapping("/enviar")
	    public ResponseEntity<Proposta> enviarProposta(@RequestParam Long clienteId,
	                                                   @RequestParam Long freelancerId,
	                                                   @RequestParam String conteudoProposta) {
	        Proposta proposta = propostaService.enviarProposta(clienteId, freelancerId, conteudoProposta);
	        return ResponseEntity.ok(proposta);
	    }

	    @GetMapping("/freelancer/{freelancerId}")
	    public String listarPropostasFreelancer(@PathVariable Long freelancerId, Model model,Long clienteId) {
	        List<Proposta> propostas = propostaService.listarPropostasFreelancer(freelancerId);
	        Cliente cliente = clienteService.mostrarCliente(clienteId);
	        model.addAttribute("cliente", cliente);
	        model.addAttribute("propostas", propostas); 
	        return "freelancer-inbox";
	    }

	    @GetMapping("/cliente/{clienteId}")
	    public String listarPropostasCliente(@PathVariable Long clienteId, Model model) {
	        List<Proposta> propostas = propostaService.listarPropostasCliente(clienteId);
	        model.addAttribute("propostas", propostas); // Adiciona as propostas ao modelo
	        return "cliente-inbox"; // Nome do template HTML para a inbox do cliente
	    }

	}