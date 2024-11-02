package Main_Package.model;
import java.util.Date;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "freelancer")
public class Freelancer extends Usuario{
    
    
	// Um freelancer pode enviar varios curriculos para serviços diferentes
    @OneToMany(mappedBy = "freelancer")
	private List<Curriculo> curriculo;
	
    
	
	public Freelancer(Long id, String nome, String email, String senha, Date dataNascimento, String sexo, String cpf,
			String telefone, Main_Package.model.role role, List<Curriculo> curriculo) {
		super(id, nome, email, senha, dataNascimento, sexo, cpf, telefone, role);
		this.curriculo = curriculo;
	}
	
	public void enviarCurriculo(Curriculo curriculo) {
		//return curriculoEnviado
	}
	
	public void avaliarServico(Servico servico) {
		//return AvaliacaoRealizada
	}
	
	

	   public Freelancer(List<Curriculo> curriculo) {
		this.curriculo = curriculo;
	}

	public Freelancer() {
	}


	public Freelancer(Usuario usuario) {
		// TODO Auto-generated constructor stub
	}


	public List<Curriculo> getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(List<Curriculo> curriculo) {
		this.curriculo = curriculo;
	}
	
	

}
