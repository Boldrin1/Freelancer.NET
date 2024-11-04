package Main_Package.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Main_Package.model.Cliente;
import Main_Package.model.Freelancer;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer,Long>{



	// FreelancerRepository
	Optional<Freelancer> findByEmailAndSenha(String email, String senha);

	


}
