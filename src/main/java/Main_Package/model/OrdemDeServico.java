package Main_Package.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrdemDeServico {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	  @ManyToOne
      public Servico servico;
      @ManyToOne
      public Cliente cliente;
      @ManyToOne
      public Freelancer freelancer;
      @ManyToOne
      public Contrato contrato;
      
      public void criarOrdem(Servico servico, Usuario usuario, Freelancer freelancer,Contrato contrato){
    	  //return ordemCriada
      }
      
      public void verificarStatus(Contrato contrato) {
    	 //return status
      }

	public OrdemDeServico(Servico servico, Cliente cliente, Freelancer freelancer, Contrato contrato) {
		this.servico = servico;
		this.cliente = cliente;
		this.freelancer = freelancer;
		this.contrato = contrato;
	}
	
	

	   public OrdemDeServico() {
	}

	public Long getId() {
		   return id;
	   }
	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Freelancer getFreelancer() {
		return freelancer;
	}

	public void setFreelancer(Freelancer freelancer) {
		this.freelancer = freelancer;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}
      
      
      
}
