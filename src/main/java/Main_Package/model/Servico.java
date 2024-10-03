package Main_Package.model;

public class Servico {
     public int Valor;
     public int Horas;
     public String Descricao;
     public int CodigoDeServico;
     
     enum AreaDeInteresse{
    	 MARKETING,
    	 TECNOLOGIADAINFORMACAO,
    	 LIMPEZA,
    	 AUTOMOTIVO,
    	 GRAFICA,
    	 CONSULTORIA,
    	 EVENTOS,
    	 SERVICOSGERAIS
     }
     
     
     public void receberCurriculo(Curriculo curriculo) {
    	 //return curriculoGuardado
     }


	public Servico(int valor, int horas, String descricao, int codigoDeServico) {
		super();
		Valor = valor;
		Horas = horas;
		Descricao = descricao;
		CodigoDeServico = codigoDeServico;
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
