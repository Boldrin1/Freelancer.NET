package Main_Package.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Main_Package.model.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta,Long> {

	List<Proposta> findByCliente_Id(Long clienteId);

	List<Proposta> findByFreelancer_Id(Long freelancerId);


}
