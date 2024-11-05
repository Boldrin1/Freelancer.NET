package Main_Package.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Main_Package.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{



	List<Cliente> findByEmail(String email);

	Optional<Cliente> findByEmailAndSenha(String email, String senha);

	
}