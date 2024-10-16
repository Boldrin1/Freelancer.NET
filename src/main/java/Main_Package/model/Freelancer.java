package Main_Package.model;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

@Entity
public class Freelancer extends Usuario{
    
    
    @OneToOne
	private Curriculo curriculo;
	
	
	public void enviarCurriculo(Curriculo curriculo) {
		//return curriculoEnviado
	}
	
	public void avaliarServico(Servico servico) {
		//return AvaliacaoRealizada
	}
	
	

	   public Freelancer(Curriculo curriculo) {
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
