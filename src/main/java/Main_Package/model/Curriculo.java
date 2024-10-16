package Main_Package.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Curriculo {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
	  @ManyToOne
      public Experiencias experiencias;
	  @ManyToOne
      public FormacaoAcademica formacaoAcademica;
      @ManyToOne
      public Competencias competencias;
      @Enumerated(EnumType.STRING)
      public AreaDeInteresse area;
      
      
      public void alterarCurriculo(Experiencias experiencias,FormacaoAcademica formacaoAcademica,Competencias competencias) {
    	 // return curriculoAlterado;
      }


	public Curriculo(Experiencias experiencias, FormacaoAcademica formacaoAcademica, Competencias competencias) {
		this.experiencias = experiencias;
		this.formacaoAcademica = formacaoAcademica;
		this.competencias = competencias;
	}
	
	

	   public Curriculo() {
	}


	public Long getId() {
		   return id;
	   }
	public Experiencias getExperiencias() {
		return experiencias;
	}


	public void setExperiencias(Experiencias experiencias) {
		this.experiencias = experiencias;
	}


	public FormacaoAcademica getFormacaoAcademica() {
		return formacaoAcademica;
	}


	public void setFormacaoAcademica(FormacaoAcademica formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}


	public Competencias getCompetencias() {
		return competencias;
	}


	public void setCompetencias(Competencias competencias) {
		this.competencias = competencias;
	}


	public void setFreelancer(Freelancer freelancer) {
		// TODO Auto-generated method stub
		
	}


	public void setServico(Servico servico) {
		// TODO Auto-generated method stub
		
	}


      
      
      
}
