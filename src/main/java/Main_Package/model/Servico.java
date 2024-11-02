package Main_Package.model;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;



@Entity
public class Servico {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String titulo;
     public int valor;
     public int horas;
     public String descricao;

     
     @ManyToOne
     @JoinColumn(name = "cliente_id")
     private Cliente cliente;
     
     // Um serviço pode ter vários curriculos enviados por freelancers
     @OneToMany(mappedBy = "servico")
     private List<Curriculo> curriculos;
     
     @Enumerated(EnumType.STRING)
     private AreaDeInteresse area;
     
     
     public void receberCurriculo(Curriculo curriculo) {
    	 //return curriculoGuardado
     }


	public Servico(Long id, String titulo, int valor, int horas, String descricao, Cliente cliente,
			List<Curriculo> curriculos, AreaDeInteresse area) {
		this.id = id;
		this.titulo = titulo;
		this.valor = valor;
		this.horas = horas;
		this.descricao = descricao;
		this.cliente = cliente;
		this.curriculos = curriculos;
		this.area = area;
	}


	public Servico() {
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


	public int getValor() {
		return valor;
	}


	public void setValor(int valor) {
		this.valor = valor;
	}


	public int getHoras() {
		return horas;
	}


	public void setHoras(int horas) {
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


	public List<Curriculo> getCurriculos() {
		return curriculos;
	}


	public void setCurriculos(List<Curriculo> curriculos) {
		this.curriculos = curriculos;
	}


	public AreaDeInteresse getArea() {
		return area;
	}


	public void setArea(AreaDeInteresse area) {
		this.area = area;
	}


	
     
}
