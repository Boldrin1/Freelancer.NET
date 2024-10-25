package Main_Package.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Main_Package.model.Contrato;
import Main_Package.service.ContratoService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@RestController
public class ContratoController {

    private final ContratoService contratoService;

    public ContratoController(ContratoService contratoService) {
        this.contratoService = contratoService;
    }

    @GetMapping("/contratos/{id}/gerar")
    public ResponseEntity<byte[]> gerarContrato(@PathVariable Long id) {
        try {
            Contrato contrato = contratoService.buscarContratoPorId(id);  // Método para buscar o contrato
            contratoService.gerarContrato(contrato);
            
            Path path = Paths.get("contrato_" + id + ".pdf");
            byte[] pdf = Files.readAllBytes(path);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "inline; filename=contrato_" + id + ".pdf");

            return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    
    @PostMapping("/contratos/{id}/assinar")
    public ResponseEntity<String> assinarContrato(@PathVariable Long id, @RequestParam String papel) {
        try {
            Contrato contrato = contratoService.buscarContratoPorId(id);

            if ("freelancer".equals(papel)) {
                contrato.setFreelancerAssinou(true);
            } else if ("cliente".equals(papel)) {
                contrato.setClienteAssinou(true);
            }

            

            contratoService.salvarContrato(contrato);

            return new ResponseEntity<>("Contrato assinado com sucesso.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao assinar o contrato.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
