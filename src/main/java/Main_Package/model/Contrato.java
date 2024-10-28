package Main_Package.model;

import java.time.LocalDate;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Contrato {
   	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
   	 private Long id;
   	 
   	@OneToOne
   	 private Freelancer freelancer;
   	 @OneToOne
   	 private Cliente cliente;
   	private LocalDate dataInicio;
   	private LocalDate dataFim;
   	private boolean FreelancerAssinou;
   	private boolean ClienteAssinou;

	private String Termos;
     
     public void validarContrato(Date DateInico,Date DateFim,int Valor) {
    	 //return resulta 
     }
     
     public void exibirStatus(Date DataInicio, Date DateFim){
    	 //return status
     }

	

	

	public boolean isFreelancerAssinou() {
		return FreelancerAssinou;
	}

	public void setFreelancerAssinou(boolean freelancerAssinou) {
		FreelancerAssinou = freelancerAssinou;
	}

	

	public Contrato(Long id, Freelancer freelancer, Cliente cliente, LocalDate dataInicio, LocalDate dataFim,
			boolean freelancerAssinou, boolean clienteAssinou, String termos) {
		this.id = id;
		this.freelancer = freelancer;
		this.cliente = cliente;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		FreelancerAssinou = freelancerAssinou;
		ClienteAssinou = clienteAssinou;
		Termos = termos;
	}

	
	public boolean isClienteAssinou() {
		return ClienteAssinou;
	}

	public void setClienteAssinou(boolean clienteAssinou) {
		ClienteAssinou = clienteAssinou;
	}

	public Contrato() {
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		dataFim = dataFim;
	}

	public String getTermos() {
		return Termos;
	}

	public void setTermos(String termos) {
		Termos = termos;
	}



	
     
     
	
}
