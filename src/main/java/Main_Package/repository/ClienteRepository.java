package Main_Package.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Main_Package.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{



	Optional<Cliente> findByEmailAndSenha(String email, String senha);

	
}