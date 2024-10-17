package Main_Package.model;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Freelancer extends Usuario{
    
    
	// Um freelancer pode enviar varios curriculos para serviços diferentes
    @OneToMany(mappedBy = "freelancer")
	private List<Curriculo> curriculo;
	
	
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


	public List<Curriculo> getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(List<Curriculo> curriculo) {
		this.curriculo = curriculo;
	}
	
	

}
