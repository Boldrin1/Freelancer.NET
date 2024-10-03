package Main_Package.model;

import java.util.Date;

public class Experiencias {
   public String NomeDaEmpresa;
   public Date DataDeInicio;
   public Date DataDeFim;
   public String ServicoPrestato;
   
   //Construtores
   public Experiencias(String nomeDaEmpresa, Date dataDeInicio, Date dataDeFim, String servicoPrestato) {
		super();
		NomeDaEmpresa = nomeDaEmpresa;
		DataDeInicio = dataDeInicio;
		DataDeFim = dataDeFim;
		ServicoPrestato = servicoPrestato;
	}
	public void setServicoPrestato(String servicoPrestato) {
		ServicoPrestato = servicoPrestato;
	}
	   
   
   
   
   // getters e seters
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
