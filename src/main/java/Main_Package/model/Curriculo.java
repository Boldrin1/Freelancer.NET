package Main_Package.model;


import java.util.Date;

import jakarta.persistence.Column;
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

    
    private String nome;
    private String telefone;
    private String email;

        @Column(name = "experiencias")
        private String experiencias;

        @Column(name = "formacao_academica")
        private String formacaoAcademica;

        @Column(name = "competencias")
        private String competencias;

        // Getters e Setters
    

    @Enumerated(EnumType.STRING)
    private AreaDeInteresse area;
    
    private String status;
    
      @ManyToOne // ou @OneToOne, dependendo da sua lógica
      @JoinColumn(name = "freelancer_id")
      private Freelancer freelancer;
    
      @ManyToOne
      @JoinColumn(name = "servico_id")
      private Servico servico;

      
      public void alterarCurriculo(Experiencias experiencias,FormacaoAcademica formacaoAcademica,Competencias competencias) {
    	 // return curriculoAlterado;
      }


	public void setServico(Servico servico) {
		// TODO Auto-generated method stub
		
	}


	public Curriculo(Long id, String nome, String telefone, String email, String experiencias, String formacaoAcademica,
			String competencias, AreaDeInteresse area, String status, Freelancer freelancer, Servico servico) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
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


	public String getCompetencias() {
		return competencias;
	}


	public void setCompetencias(String competencias) {
		this.competencias = competencias;
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


	public Freelancer getFreelancer() {
		return freelancer;
	}


	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}


	public Servico getServico() {
		return servico;
	}


	


	  

}
