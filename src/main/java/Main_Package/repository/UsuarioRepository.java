package Main_Package.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Main_Package.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{

	Usuario findByEmail(String email);




}
