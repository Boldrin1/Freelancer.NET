package Main_Package.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import Main_Package.model.Curriculo;

public interface CurriculoRepository extends JpaRepository<Curriculo,Long>{

	Optional<Curriculo> findByFreelancerId(Long id);

}
