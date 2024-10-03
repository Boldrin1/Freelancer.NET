package Main_Package.model;

import java.util.Date;

public class HistoricoDeServicos {
     public Freelancer freelancer;
     public Date DateDeInicio;
     public Date DateDeFim;
     public Servico servico;
     
     public void verificarStatus(OrdemDeServico ordem) {
    	 //return status
     }

	public HistoricoDeServicos(Freelancer freelancer, Date dateDeInicio, Date dateDeFim, Servico servico) {
		super();
		this.freelancer = freelancer;
		DateDeInicio = dateDeInicio;
		DateDeFim = dateDeFim;
		this.servico = servico;
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
