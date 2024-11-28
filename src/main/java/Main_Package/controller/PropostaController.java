package Main_Package.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import Main_Package.model.Proposta;
import Main_Package.service.PropostaService;

@Controller
@RequestMapping("/proposta")
public class PropostaController {

	    @Autowired
	    private PropostaService propostaService;
	    

	    @PostMapping("/enviar/{clienteId}/{freelancerId}")
	    public String enviarProposta(@PathVariable Long clienteId,
	                                 @PathVariable Long freelancerId,
	                                 @RequestParam String propostaText,
	                                 RedirectAttributes redirectAttributes) {
	        Proposta proposta = propostaService.enviarProposta(clienteId, freelancerId, propostaText);

	        // Mensagem de sucesso para a próxima página (opcional)
	        redirectAttributes.addFlashAttribute("mensagem", "Proposta enviada com sucesso!");

	        return "redirect:/usuario/cliente/" + clienteId;
	    }

	    
	    
	    @GetMapping("/freelancer/{freelancerId}")
	    public String listarPropostasFreelancer(@PathVariable Long freelancerId, Model model) {
	        List<Proposta> propostas = propostaService.listarPropostasFreelancer(freelancerId);
	        model.addAttribute("propostas", propostas);
	        return "freelancer-inbox";
	    }




	}