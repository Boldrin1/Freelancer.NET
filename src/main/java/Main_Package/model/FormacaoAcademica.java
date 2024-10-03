package Main_Package.model;

import java.util.Date;

public class FormacaoAcademica {
     public String UltimaFormacao;
     public Date DataDeFim;
     public Date InstituicaoEscolar;
     
     
	public FormacaoAcademica(String ultimaFormacao, Date dataDeFim, Date instituicaoEscolar) {
		super();
		UltimaFormacao = ultimaFormacao;
		DataDeFim = dataDeFim;
		InstituicaoEscolar = instituicaoEscolar;
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
