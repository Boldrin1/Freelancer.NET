package Main_Package.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
@Entity
public class Curriculo {
	@Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Freelancer freelancer;
    
    private String nome;
    private String telefone;
    private String email;
    private String competencias;
    private String experiencias;
    private String formacaoAcademica;
        
    

    @Enumerated(EnumType.STRING)
    private AreaDeInteresse areaDeInteresse;
    
    private String status;
    
    
      /*@ManyToOne
      @JoinColumn(name = "servico_id")
      private Servico servico;*/



	public void setServico(Servico servico) {
		// TODO Auto-generated method stub
		
	}

	public Curriculo() {
	}

	public Curriculo(Long id, Freelancer freelancer, String nome, String telefone, String email, String competencias,
			String experiencias, String formacaoAcademica, AreaDeInteresse areaDeInteresse, String status) {
		this.id = id;
		this.freelancer = freelancer;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.competencias = competencias;
		this.experiencias = experiencias;
		this.formacaoAcademica = formacaoAcademica;
		this.areaDeInteresse = areaDeInteresse;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompetencias() {
		return competencias;
	}

	public void setCompetencias(String competencias) {
		this.competencias = competencias;
	}

	public String getExperiencias() {
		return experiencias;
	}

	public void setExperiencias(String experiencias) {
		this.experiencias = experiencias;
	}

	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}

	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}

	public AreaDeInteresse getAreaDeInteresse() {
		return areaDeInteresse;
	}

	public void setAreaDeInteresse(AreaDeInteresse areaDeInteresse) {
		this.areaDeInteresse = areaDeInteresse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

}
