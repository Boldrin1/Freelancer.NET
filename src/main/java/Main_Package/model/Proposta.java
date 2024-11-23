package Main_Package.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Proposta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String proposta;
	
	private String resposta;

    @OneToMany
    @JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
    @OneToMany
    @JoinColumn(name = "freelancer_id")
	private Freelancer freelancer;

	public Proposta() {
	}

	public Proposta(Long id, String proposta, String resposta, Cliente cliente, Freelancer freelancer) {
		this.id = id;
		this.proposta = proposta;
		this.resposta = resposta;
		this.cliente = cliente;
		this.freelancer = freelancer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProposta() {
		return proposta;
	}

	public void setProposta(String proposta) {
		this.proposta = proposta;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
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
    
    
}
