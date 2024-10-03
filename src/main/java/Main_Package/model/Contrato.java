package Main_Package.model;

import java.util.Date;

public class Contrato {
     public Date DataInicio;
     public Date DataFim;
     public String Termos;
     
     public void validarContrato(Date DateInico,Date DateFim,int Valor) {
    	 //return resulta 
     }
     
     public void exibirStatus(Date DataInicio, Date DateFim){
    	 //return status
     }

	public Contrato(Date dataInicio, Date dataFim, String termos) {
		super();
		DataInicio = dataInicio;
		DataFim = dataFim;
		Termos = termos;
	}

	public Date getDataInicio() {
		return DataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		DataInicio = dataInicio;
	}

	public Date getDataFim() {
		return DataFim;
	}

	public void setDataFim(Date dataFim) {
		DataFim = dataFim;
	}

	public String getTermos() {
		return Termos;
	}

	public void setTermos(String termos) {
		Termos = termos;
	}
     
     
	
}
