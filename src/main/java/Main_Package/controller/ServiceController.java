package Main_Package.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import Main_Package.model.Servico;
import Main_Package.service.ServicoService;


@Controller
@RequestMapping("/servico")
public class ServiceController {
	
	@Autowired
	private ServicoService servicoService;

	
	@GetMapping("/vizualizar/{id}")
	public String vizualizarServico(@PathVariable Long id,Model model) {
	Optional<Servico> servico = servicoService.encontrarServico(id);
	model.addAttribute("servico", servico);
		
	return "freelancer-Visu-Servico";
	}
}
