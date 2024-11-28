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


    private Long curriculoId; // ID do currículo enviado (relacionado ao freelancer)

    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente; // Referência ao cliente que publicou o serviço

    @ManyToOne
    @JoinColumn(name = "servico_id", referencedColumnName = "id")
    private Servico servico; // Referência ao serviço
	
	public ServicoCurriculo() {
	}

	public ServicoCurriculo(Long id, Long curriculoId, Cliente cliente, Servico servico) {
		this.id = id;
		this.curriculoId = curriculoId;
		this.cliente = cliente;
		this.servico = servico;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCurriculoId() {
		return curriculoId;
	}

	public void setCurriculoId(Long curriculoId) {
		this.curriculoId = curriculoId;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public void setCurriculoId(Curriculo curriculo) {
		// TODO Auto-generated method stub
		
	}


	
}