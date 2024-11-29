package Main_Package.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/validate")
public class ValidationController {

    @PostMapping("/telefone")
    public ResponseEntity<String> validatePhone(@RequestParam String telefone) {
        if (Validacao.isValidPhone(telefone)) {
            return ResponseEntity.ok("Telefone válido!");
        } else {
            return ResponseEntity.badRequest().body("Telefone inválido!");
        }
    }

    @PostMapping("/cpf")
    public ResponseEntity<String> validateCPF(@RequestParam String cpf) {
        if (Validacao.isValidCPF(cpf)) {
            return ResponseEntity.ok("CPF válido!");
        } else {
            return ResponseEntity.badRequest().body("CPF inválido!");
        }
    }
}