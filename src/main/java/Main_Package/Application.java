package Main_Package;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import Main_Package.model.Cliente;
import Main_Package.repository.ClienteRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setNome("Fernando");
        cliente.setEmail("Roberto@gmail.com");
        cliente.setSenha("123");
        cliente.setDataNascimento(new Date());
        cliente.setSexo("Masculino");
        cliente.setCPF("12");
        clienteRepository.save(cliente);
    }
}
