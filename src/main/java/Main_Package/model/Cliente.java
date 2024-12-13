package Main_Package.model;

import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;



@Entity
@Table(name = "cliente")
public class Cliente extends Usuario{
	
    @OneToMany(mappedBy = "cliente")
    private List<Servico> servicos; 


	public Cliente(Long id, String nome, String email, String senha, Date dataNascimento, String sexo, String cpf,
			String telefone, Main_Package.model.role role) {
		super(id, nome, email, senha, dataNascimento, sexo, cpf, telefone, role);
	}
	
	public Cliente() {}
	
    public Cliente(Long clienteId) {
        this.id = clienteId;
    }


}

