package Main_Package.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/validate")
public class ValidationController {

	  public static boolean isValidPhone(String phone) {
	        return phone != null && phone.matches("\\(\\d{2}\\) \\d{5}-\\d{4}");
	    }

	  public static boolean isValidCPF(String cpf) {
		    if (cpf == null || cpf.isEmpty()) return false;

		    // Remove caracteres não numéricos
		    cpf = cpf.replaceAll("\\D", "");

		    // Verifica se tem 11 dígitos e não é uma sequência repetida (ex: 111.111.111-11)
		    if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) return false;

		    try {
		        // Cálculo do primeiro dígito verificador
		        int soma = 0;
		        for (int i = 0; i < 9; i++) {
		            soma += (cpf.charAt(i) - '0') * (10 - i);
		        }
		        int resto = 11 - (soma % 11);
		        int dig1 = (resto == 10 || resto == 11) ? 0 : resto;

		        // Cálculo do segundo dígito verificador
		        soma = 0;
		        for (int i = 0; i < 10; i++) {
		            soma += (cpf.charAt(i) - '0') * (11 - i);
		        }
		        resto = 11 - (soma % 11);
		        int dig2 = (resto == 10 || resto == 11) ? 0 : resto;

		        // Verifica se os dígitos calculados correspondem aos dígitos informados
		        return cpf.charAt(9) - '0' == dig1 && cpf.charAt(10) - '0' == dig2;
		    } catch (Exception e) {
		        return false;
		    }
		}


	    @PostMapping("/telefone")
    public ResponseEntity<String> validatePhone(@RequestParam String telefone) {
    	System.out.println("Validando telefone: " + telefone);
        if (isValidPhone(telefone)) {
            return ResponseEntity.ok("Telefone válido!");
        } else {
            return ResponseEntity.badRequest().body("Telefone inválido!");
        }
    }

    @PostMapping("/cpf")
    public ResponseEntity<String> validateCPF(@RequestParam String cpf) {
    	System.out.println("Validando CPF: " + cpf);
        if (isValidCPF(cpf)) {
            return ResponseEntity.ok("CPF válido!");
        } else {
            return ResponseEntity.badRequest().body("CPF inválido!");
        }
    }
}