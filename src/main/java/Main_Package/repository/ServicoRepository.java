package Main_Package.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Main_Package.model.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico,Long>{

}
