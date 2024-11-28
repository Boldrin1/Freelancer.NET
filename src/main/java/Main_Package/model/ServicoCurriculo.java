package Main_Package.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ServicoCurriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
	public ServicoCurriculo() {
	}

	private Long clienteId;


	@ManyToOne
	    @JoinColumn(name = "servico_id")
	    private Servico servico;

	    @ManyToOne
	    @JoinColumn(name = "curriculo_id")
	    private Curriculo curriculo;


		public ServicoCurriculo(Long id, Long clienteId, Servico servico, Curriculo curriculo) {
			this.id = id;
			this.clienteId = clienteId;
			this.servico = servico;
			this.curriculo = curriculo;
		}


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public Long getClienteId() {
			return clienteId;
		}


		public void setClienteId(Long clienteId) {
			this.clienteId = clienteId;
		}


		public Servico getServico() {
			return servico;
		}


		public void setServico(Servico servico) {
			this.servico = servico;
		}


		public Curriculo getCurriculo() {
			return curriculo;
		}


		public void setCurriculo(Curriculo curriculo) {
			this.curriculo = curriculo;
		}


	
	
	}
	
