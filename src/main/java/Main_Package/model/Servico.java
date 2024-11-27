package Main_Package.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;




@Entity
public class Servico {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String titulo;
     private String valor;
     private String horas;
     private String descricao;

     
     @ManyToOne
     @JoinColumn(name = "cliente_id" , nullable = false)
     private Cliente cliente;


     /*
     // Um serviço pode ter vários curriculos enviados por freelancers
     @OneToMany(mappedBy = "servico")
     private List<Curriculo> curriculos;*/
     
     
     public void receberCurriculo(Curriculo curriculo) {
    	 //return curriculoGuardado
     }

     

	public Servico() {
	}

	
	/*
	 * 
	 * 
 	 * ALTER TABLE servico
       DROP FOREIGN KEY FKte1p7xhut5cf7cdiqbvp6yoqd;

       ALTER TABLE servico
       ADD CONSTRAINT FK_cliente FOREIGN KEY (cliente_id) REFERENCES cliente(id);

	 * */


	public Servico(Long id, String titulo, String valor, String horas, String descricao, Cliente cliente) {
		this.id = id;
		this.titulo = titulo;
		this.valor = valor;
		this.horas = horas;
		this.descricao = descricao;
		this.cliente = cliente;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getTitulo() {
		return titulo;
	}



	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public String getValor() {
		return valor;
	}



	public void setValor(String valor) {
		this.valor = valor;
	}



	public String getHoras() {
		return horas;
	}



	public void setHoras(String horas) {
		this.horas = horas;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	
}
