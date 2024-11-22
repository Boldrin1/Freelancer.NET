package Main_Package.model;
import java.util.Date;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "freelancer")
public class Freelancer extends Usuario{
    
    

    
    @OneToOne(mappedBy = "freelancer", cascade = CascadeType.ALL)
    private Curriculo curriculo;

	public Freelancer(Long id, String nome, String email, String senha, Date dataNascimento, String sexo, String cpf,
			String telefone, Main_Package.model.role role, Curriculo curriculo) {
		super(id, nome, email, senha, dataNascimento, sexo, cpf, telefone, role);
		this.curriculo = curriculo;
	}

	public Freelancer() {
	}

	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}
	

}
