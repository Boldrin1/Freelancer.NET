package Main_Package.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Experiencias {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   
   private String NomeDaEmpresa;
   private Date DataDeInicio;
   private Date DataDeFim;
   private String ServicoPrestato;
   
   //Construtores
   public Experiencias(String nomeDaEmpresa, Date dataDeInicio, Date dataDeFim, String servicoPrestato) {
		NomeDaEmpresa = nomeDaEmpresa;
		DataDeInicio = dataDeInicio;
		DataDeFim = dataDeFim;
		ServicoPrestato = servicoPrestato;
	}  
   
   
   
   public Experiencias() {
}



// getters e seters
   public Long getId() {
	   return id;
   }
public String getNomeDaEmpresa() {
	return NomeDaEmpresa;
}
public void setNomeDaEmpresa(String nomeDaEmpresa) {
	NomeDaEmpresa = nomeDaEmpresa;
}
public Date getDataDeInicio() {
	return DataDeInicio;
}
public void setDataDeInicio(Date dataDeInicio) {
	DataDeInicio = dataDeInicio;
}
public Date getDataDeFim() {
	return DataDeFim;
}
public void setDataDeFim(Date dataDeFim) {
	DataDeFim = dataDeFim;
}
public String getServicoPrestato() {
	return ServicoPrestato;
}
   
   
}
