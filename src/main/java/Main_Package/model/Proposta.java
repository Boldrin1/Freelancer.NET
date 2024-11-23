package Main_Package.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Proposta {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String proposta;

	    @ManyToOne
	    @JoinColumn(name = "cliente_id", nullable = false)
	    private Cliente cliente;

	    @ManyToOne
	    @JoinColumn(name = "freelancer_id", nullable = false)
	    private Freelancer freelancer;

		public Proposta(Long id, String proposta, Cliente cliente, Freelancer freelancer) {
			this.id = id;
			this.proposta = proposta;
			this.cliente = cliente;
			this.freelancer = freelancer;
		}

		public Proposta() {
			
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

