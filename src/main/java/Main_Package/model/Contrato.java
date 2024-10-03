package Main_Package.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Contrato {
   	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
   	 private Long id;
   	 
     private Date DataInicio;
     private Date DataFim;
     private String Termos;
     
     public void validarContrato(Date DateInico,Date DateFim,int Valor) {
    	 //return resulta 
     }
     
     public void exibirStatus(Date DataInicio, Date DateFim){
    	 //return status
     }

	public Contrato(Date dataInicio, Date dataFim, String termos) {
		DataInicio = dataInicio;
		DataFim = dataFim;
		Termos = termos;
	}
	
	   public Long getId() {
		   return id;
	   }
	public Contrato() {
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
