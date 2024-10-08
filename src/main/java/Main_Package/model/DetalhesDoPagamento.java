package Main_Package.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
@Entity
public class DetalhesDoPagamento {
	       @Id
	       @GeneratedValue(strategy = GenerationType.IDENTITY)
	       private Long id;
	       
           private Date DataDePagamento;
           @ManyToOne
           public Freelancer Coletor;
           @ManyToOne
           public Cliente Pagador;
           
           
		public DetalhesDoPagamento(Date dataDePagamento, Freelancer coletor, Cliente pagador) {
			DataDePagamento = dataDePagamento;
			Coletor = coletor;
			Pagador = pagador;
		}
		
		
		
		   public DetalhesDoPagamento() {
		}



		public Long getId() {
			   return id;
		   }
		public Date getDataDePagamento() {
			return DataDePagamento;
		}
		public void setDataDePagamento(Date dataDePagamento) {
			DataDePagamento = dataDePagamento;
		}
		public Freelancer getColetor() {
			return Coletor;
		}
		public void setColetor(Freelancer coletor) {
			Coletor = coletor;
		}
		public Cliente getPagador() {
			return Pagador;
		}
		public void setPagador(Cliente pagador) {
			Pagador = pagador;
		}

           
           
		
		
}
