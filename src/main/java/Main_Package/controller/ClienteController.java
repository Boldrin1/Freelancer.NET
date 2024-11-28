package Main_Package.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import Main_Package.model.Cliente;
import Main_Package.model.Curriculo;
import Main_Package.model.Freelancer;
import Main_Package.model.Proposta;
import Main_Package.model.Servico;
import Main_Package.model.ServicoCurriculo;
import Main_Package.repository.ClienteRepository;
import Main_Package.repository.FreelancerRepository;
import Main_Package.repository.PropostaRepository;
import Main_Package.repository.ServicoCurriculoRepository;
import Main_Package.service.ClienteService;
import Main_Package.service.CurriculoService;
import Main_Package.service.ServicoService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;


@Controller
@RequestMapping("/usuario/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	
	@Autowired
	private CurriculoService curriculoService;
	
	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private FreelancerRepository freelancerRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PropostaRepository propostaRepository;
	
	@Autowired
	private ServicoCurriculoRepository servicoCurriculoRepository;
	
	   public ClienteController(ServicoCurriculoRepository servicoCurriculoRepository) {
	        this.servicoCurriculoRepository = servicoCurriculoRepository;
	    }
	
	@GetMapping("/{id}")
	public String paginaInicial_Cliente(@PathVariable Long id, Model model, Curriculo curriculo) {
	    Cliente cliente = clienteService.mostrarCliente(id);
	    List<Curriculo> curriculos = curriculoService.listarCurriculo(curriculo);

	    model.addAttribute("cliente", cliente);
	    model.addAttribute("curriculo", curriculos);

	    return "cliente-home";
	}

	
	@GetMapping("/view-curriculo/{curriculoId}")
	public String viewCurriculo(
	    @PathVariable Long curriculoId, 
	    @RequestParam Long clienteId, 
	    Model model) {
	    
	    Optional<Curriculo> curriculo = curriculoService.mostraCurriculo(curriculoId);
	    Cliente cliente = clienteService.mostrarCliente(clienteId);

	    if (curriculo.isPresent()) {
	        Curriculo curriculo2 = curriculo.get();

	        model.addAttribute("cliente", cliente);
	        System.out.println(cliente);
	        model.addAttribute("curriculo", curriculo2);
	        System.out.println(curriculo2);
	        return "curriculo-view";
	    } else {
	        return "erro"; 
	    }
	}

	
	@GetMapping("/servicos/{id}")
	public String listServico(@PathVariable Long id, Model model){
	    List<Servico> servicos = servicoService.listarPorCliente(id);
		model.addAttribute("servicos", servicos);
		return "cliente-servicos";
	}
	
	
	@GetMapping("/perfil/{id}")
	public String mostrarCliente(@PathVariable Long id,Model model) {
		Cliente cliente = clienteService.mostrarCliente(id);
		clienteService.mostrarCliente(id);
		model.addAttribute("cliente",cliente);
		return "cliente-perfil";
	}
	
	@GetMapping("/perfil/editar/{id}")
	public String editarDados(@PathVariable Long id,Model model){
		Cliente cliente = clienteService.mostrarCliente(id);
		model.addAttribute("cliente", cliente);
		return "cliente-editar";
	}
	
	@PostMapping("/perfil/editar/salvar/{id}")
	public String salvarEditar(@PathVariable Long id, @ModelAttribute Cliente clienteAtualizado) {
	    clienteService.updateCliente(id, clienteAtualizado); 
	    return "redirect:/usuario/cliente/perfil/" + id; 
	}
	
	
	@GetMapping("/proposta/enviar/{clienteId}/{curriculoId}")
	public String enviarProposta(
	        @PathVariable Long clienteId,
	        @PathVariable Long curriculoId,
	        Model model) {
	    Optional<Curriculo> curriculo = curriculoService.mostraCurriculo(curriculoId);
	    Cliente cliente = clienteService.mostrarCliente(clienteId);
	    
	    if (curriculo.isEmpty()) {
	        throw new RuntimeException("Currículo não encontrado!");
	    }

	    model.addAttribute("curriculo", curriculo.get());
	    model.addAttribute("cliente", cliente);
	    return "cliente-proposta";
	}

	

	@PostMapping("/{freelancerId}/enviar-proposta")
	public ResponseEntity<?> enviarProposta(
	        @PathVariable Long freelancerId,
	        @RequestParam Long clienteId,
	        @RequestBody String descricao) {

	    Freelancer freelancer = freelancerRepository.findById(freelancerId)
	            .orElseThrow(() -> new RuntimeException("Freelancer não encontrado"));

	    Cliente cliente = clienteRepository.findById(clienteId)
	            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

	    Proposta proposta = new Proposta();
	    proposta.setPropostaText(descricao);
	    proposta.setCliente(cliente);
	    proposta.setFreelancer(freelancer);

	    propostaRepository.save(proposta);

	    // Redireciona para a página do cliente após enviar a proposta
	    String redirecionarUrl = "/usuario/cliente/home/" + clienteId;
	    return ResponseEntity.status(HttpStatus.FOUND)
	            .header(HttpHeaders.LOCATION, redirecionarUrl)
	            .build();
	}

	
	@DeleteMapping("/perfil/{id}")
	public String excluirCliente(Long id) {
		return "redirect:/create-count";
	}
	
	
	
	@GetMapping("/inbox/{id}")
	public String clienteInbox(@PathVariable("id") Long clienteId, Model model) {
	    // Busca a lista de currículos relacionados ao cliente
	    List<ServicoCurriculo> servicosCurriculos = servicoCurriculoRepository.findByServico_Cliente_Id(clienteId);
	    
	    // Garante que a lista não será nula
	    if (servicosCurriculos == null) {
	        servicosCurriculos = new ArrayList<>();
	    }

	    // Adiciona a lista no modelo
	    model.addAttribute("servicosCurriculos", servicosCurriculos);
	    return "cliente-inbox";
	}




}


/*
 * 	O cliente vai ver serviços e o freelancer vai ver trabalhos disponiveis
 * 
 *  @GetMapping: Mapeia requisições HTTP GET para recuperar todos os usuários ou um usuário por ID.
 *  @PostMapping: Mapeia requisições HTTP POST para criar um novo usuário.
 *  @PutMapping: Mapeia requisições HTTP PUT para atualizar um usuário existente.
 *  @DeleteMapping: Mapeia requisições HTTP DELETE para excluir um usuário por ID.
 *  
 */