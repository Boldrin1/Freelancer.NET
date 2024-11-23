package Main_Package.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import Main_Package.service.ServicoService;
import ch.qos.logback.core.model.Model;

@Controller
@RequestMapping("/servico")
public class ServiceController {
	
	@Autowired
	private ServicoService servicoService;

	
	@GetMapping("/vizualizar/{id}")
	public String vizualizarServico(Model model,Long id) {
		
		
		
		return "";
	}
}
