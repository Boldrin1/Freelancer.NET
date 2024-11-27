package Main_Package.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import Main_Package.model.Freelancer;

@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer,Long>{

	Optional<Freelancer> findByEmailAndSenha(String email, String senha);

	@Query("SELECT f FROM Freelancer f WHERE f.email = :email")
	Optional<Freelancer> findByEmail(@Param("email") String email);



}
