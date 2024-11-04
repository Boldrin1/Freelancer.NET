package Main_Package.model;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Curriculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "experiencias_id") // Nome da coluna de referência
    private Experiencias experiencias;

    @ManyToOne
    @JoinColumn(name = "formacao_academica_id") // Nome da coluna de referência
    private FormacaoAcademica formacaoAcademica;

    @ManyToOne
    @JoinColumn(name = "competencias_id") // Nome da coluna de referência
    private Competencias competencias;

    @Enumerated(EnumType.STRING)
    private AreaDeInteresse area;
    
    // Adicione os getters e setters, se necessário


      
      private String status;

      @ManyToOne
      @JoinColumn(name = "freelancer_id")
      private Freelancer freelancer;

      @ManyToOne
      @JoinColumn(name = "servico_id")
      private Servico servico;

      
      public void alterarCurriculo(Experiencias experiencias,FormacaoAcademica formacaoAcademica,Competencias competencias) {
    	 // return curriculoAlterado;
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


	public Curriculo(Long id, Experiencias experiencias, FormacaoAcademica formacaoAcademica, Competencias competencias,
			AreaDeInteresse area, String status, Freelancer freelancer, Servico servico) {
		this.id = id;
		this.experiencias = experiencias;
		this.formacaoAcademica = formacaoAcademica;
		this.competencias = competencias;
		this.area = area;
		this.status = status;
		this.freelancer = freelancer;
		this.servico = servico;
	}


	public Curriculo() {
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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


	public AreaDeInteresse getArea() {
		return area;
	}


	public void setArea(AreaDeInteresse area) {
		this.area = area;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Competencias getCompetencias() {
		return competencias;
	}


	public Freelancer getFreelancer() {
		return freelancer;
	}


	public Servico getServico() {
		return servico;
	}

      
}
