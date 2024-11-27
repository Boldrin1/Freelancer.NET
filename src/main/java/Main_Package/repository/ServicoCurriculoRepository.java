package Main_Package.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Main_Package.model.ServicoCurriculo;

public interface ServicoCurriculoRepository extends JpaRepository<ServicoCurriculo,Long>{

	boolean existsByServicoIdAndCurriculoId(Long servicoId, Long id);

}
