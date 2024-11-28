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

	    private String propostaText;

	    @ManyToOne
	    @JoinColumn(name = "cliente_id", nullable = false)
	    private Cliente cliente;

	    @ManyToOne
	    @JoinColumn(name = "freelancer_id", nullable = false)
	    private Freelancer freelancer;
	    
	    @ManyToOne
	    @JoinColumn(name = "curriculo_id", nullable = false) // Mapeamento correto para Curriculo
	    private Curriculo curriculo;
	    

		public Proposta() {
		}


		public Proposta(Long id, String propostaText, Cliente cliente, Freelancer freelancer, Curriculo curriculo) {
			this.id = id;
			this.propostaText = propostaText;
			this.cliente = cliente;
			this.freelancer = freelancer;
			this.curriculo = curriculo;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getPropostaText() {
			return propostaText;
		}


		public void setPropostaText(String propostaText) {
			this.propostaText = propostaText;
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


		public Curriculo getCurriculo() {
			return curriculo;
		}


		public void setCurriculo(Curriculo curriculo) {
			this.curriculo = curriculo;
		}


		
			
	}

