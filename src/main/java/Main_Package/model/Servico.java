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
	 
	 private String Titulo;
     public int Valor;
     public int Horas;
     public String Descricao;
     public int CodigoDeServico;
     
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


	public Servico(int valor, int horas, String descricao, int codigoDeServico) {
		Valor = valor;
		Horas = horas;
		Descricao = descricao;
		CodigoDeServico = codigoDeServico;
	}
	
	

	   public Servico() {
	}

	   
	   

	public String getTitulo() {
		return Titulo;
	}


	public void setTitulo(String titulo) {
		Titulo = titulo;
	}


	public Long getId() {
		   return id;
	   }
	public int getValor() {
		return Valor;
	}


	public void setValor(int valor) {
		Valor = valor;
	}


	public int getHoras() {
		return Horas;
	}


	public void setHoras(int horas) {
		Horas = horas;
	}


	public String getDescricao() {
		return Descricao;
	}


	public void setDescricao(String descricao) {
		Descricao = descricao;
	}


	public int getCodigoDeServico() {
		return CodigoDeServico;
	}


	public void setCodigoDeServico(int codigoDeServico) {
		CodigoDeServico = codigoDeServico;
	}
     
     
	
	
    
     
}
