package Main_Package.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
    public String Categoria;
    

	public void filtrarServico(Categoria categoria) {
    	//return ServicoListadoPorCategoria;
    }
	
	  public Categoria(Long id, String categoria) {
			this.id = id;
			Categoria = categoria;
		}
	   public Long getId() {
		   return id;
	   }  

	public Categoria() {
	}

	public Categoria(String categoria) {
		Categoria = categoria;
	}

	public String getCategoria() {
		return Categoria;
	}

	public void setCategoria(String categoria) {
		Categoria = categoria;
	}
	
	
    
    
}
