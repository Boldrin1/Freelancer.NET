package Main_Package.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Main_Package.repository.ClienteRepository;
import Main_Package.repository.FreelancerRepository;

@RestController
@RequestMapping("/api/usuarios")
public class Validacao {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/check-email")
    public ResponseEntity<Boolean> checkEmail(@RequestParam String email) {
        boolean emailExists = freelancerRepository.findByEmail(email).isPresent() ||
                              clienteRepository.findByEmail(email).isPresent();
        return ResponseEntity.ok(emailExists);
    }
}
