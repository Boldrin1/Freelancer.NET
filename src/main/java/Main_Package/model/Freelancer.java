package Main_Package.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Freelancer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	public Curriculo curriculo;
	
	
	public void enviarCurriculo(Curriculo curriculo) {
		//return curriculoEnviado
	}
	
	public void avaliarServico(Servico servico) {
		//return AvaliacaoRealizada
	}
	
	

	   public Freelancer() {
	}

	public Long getId() {
		   return id;
	   }
	public Curriculo getCurriculo() {
		return curriculo;
	}

	public void setCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}
	
	

}
