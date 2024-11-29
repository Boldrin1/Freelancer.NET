package Main_Package.config;

import java.util.InputMismatchException;

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
    
    
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("\\(\\d{2}\\) \\d{5}-\\d{4}");
    }

    // Validação de CPF
    public static boolean isValidCPF(String cpf) {
        if (cpf == null || cpf.isEmpty()) return false;

        // Remove caracteres especiais
        cpf = cpf.replaceAll("\\D", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

        try {
            // Validação do dígito verificador
            char dig10 = calculateDigit(cpf, 10);
            char dig11 = calculateDigit(cpf, 11);

            return cpf.charAt(9) == dig10 && cpf.charAt(10) == dig11;
        } catch (InputMismatchException e) {
            return false;
        }
    }

    private static char calculateDigit(String cpf, int peso) {
        int soma = 0;

        for (int i = 0; i < peso - 1; i++) {
            int num = cpf.charAt(i) - '0';
            soma += num * (peso - i);
        }

        int resto = 11 - (soma % 11);
        return (resto == 10 || resto == 11) ? '0' : (char) (resto + '0');
    }
}
