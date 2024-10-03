package Main_Package.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Curriculo {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
      public Experiencias experiencias;
      public FormacaoAcademica formacaoAcademica;
      public Competencias competencias;
      public String AreaDeInteresse;
      
      
      public void alterarCurriculo(Experiencias experiencias,FormacaoAcademica formacaoAcademica,Competencias competencias) {
    	 // return curriculoAlterado;
      }


	public Curriculo(Experiencias experiencias, FormacaoAcademica formacaoAcademica, Competencias competencias,
			String areaDeInteresse) {
		this.experiencias = experiencias;
		this.formacaoAcademica = formacaoAcademica;
		this.competencias = competencias;
		AreaDeInteresse = areaDeInteresse;
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


	public String getAreaDeInteresse() {
		return AreaDeInteresse;
	}


	public void setAreaDeInteresse(String areaDeInteresse) {
		AreaDeInteresse = areaDeInteresse;
	}
      
      
      
      
}
