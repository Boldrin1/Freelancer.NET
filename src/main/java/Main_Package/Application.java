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

   

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

   /* @Autowired
    private ClienteRepository clienteRepository;
    @Override
    public void run(String... args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setCPF("12");
        cliente.setDataNascimento(new Date());
        cliente.setEmail("Roberto@gmail.com");
        cliente.setNome("Fernando");
        cliente.setSenha("123");
        cliente.setSexo("Masculino");              
        cliente.setTelefone("44 99909393");
        clienteRepository.save(cliente);
    }*/
}
