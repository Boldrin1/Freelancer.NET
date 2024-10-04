package Main_Package.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pagamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    public int Valor;
    
    @Enumerated(EnumType.STRING)
    private TiposPagamento tipo;
    
    private void processarPagamento(int valor) {
    	//return resultado
    }
     
    
    public Pagamento() {
	}


	public Long getId() {
 	   return id;
    }
	public Pagamento(int valor) {
		Valor = valor;
	}



	public int getValor() {
		return Valor;
	}

	public void setValor(int valor) {
		Valor = valor;
	}

    
}
