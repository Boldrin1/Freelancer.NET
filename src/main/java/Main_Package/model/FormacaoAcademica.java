package Main_Package.model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FormacaoAcademica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
     private String UltimaFormacao;
     private Date DataDeFim;
     private Date InstituicaoEscolar;
     
     
	public FormacaoAcademica(String ultimaFormacao, Date dataDeFim, Date instituicaoEscolar) {
		UltimaFormacao = ultimaFormacao;
		DataDeFim = dataDeFim;
		InstituicaoEscolar = instituicaoEscolar;
	}
	
	

	   public FormacaoAcademica() {
	}



	public Long getId() {
		   return id;
	   }
	public String getUltimaFormacao() {
		return UltimaFormacao;
	}


	public void setUltimaFormacao(String ultimaFormacao) {
		UltimaFormacao = ultimaFormacao;
	}


	public Date getDataDeFim() {
		return DataDeFim;
	}


	public void setDataDeFim(Date dataDeFim) {
		DataDeFim = dataDeFim;
	}


	public Date getInstituicaoEscolar() {
		return InstituicaoEscolar;
	}


	public void setInstituicaoEscolar(Date instituicaoEscolar) {
		InstituicaoEscolar = instituicaoEscolar;
	}
     
     
	
}
