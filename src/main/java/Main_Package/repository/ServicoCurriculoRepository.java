package Main_Package.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import Main_Package.model.ServicoCurriculo;

public interface ServicoCurriculoRepository extends JpaRepository<ServicoCurriculo,Long>{

	boolean existsByServicoIdAndCurriculoId(Long servicoId, Long id);

	@Query("SELECT sc FROM ServicoCurriculo sc WHERE sc.servico.cliente.email = :email")
	List<ServicoCurriculo> findByServicoClienteEmail(@Param("email") String email);

	List<ServicoCurriculo> findByClienteId(Long id);

	    List<ServicoCurriculo> findByServico_Cliente_Id(Long clienteId);
	


}
