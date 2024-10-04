package Main_Package.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class HistoricoDeServicos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 @ManyToOne
     public Freelancer freelancer;
     public Date DateDeInicio;
     public Date DateDeFim;
     @ManyToOne
     public Servico servico;
     
     public void verificarStatus(OrdemDeServico ordem) {
    	 //return status
     }

	public HistoricoDeServicos(Freelancer freelancer, Date dateDeInicio, Date dateDeFim, Servico servico) {
		this.freelancer = freelancer;
		DateDeInicio = dateDeInicio;
		DateDeFim = dateDeFim;
		this.servico = servico;
	}
	
	
	   public HistoricoDeServicos() {
	}

	public Long getId() {
		   return id;
	   }
	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	public Date getDateDeInicio() {
		return DateDeInicio;
	}

	public void setDateDeInicio(Date dateDeInicio) {
		DateDeInicio = dateDeInicio;
	}

	public Date getDateDeFim() {
		return DateDeFim;
	}

	public void setDateDeFim(Date dateDeFim) {
		DateDeFim = dateDeFim;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}
     
     
	
}
