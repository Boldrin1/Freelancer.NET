package Main_Package.model;

import java.util.Collection;
import java.util.Date;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements UserDetails{
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
      public String Nome; 
      public String Email;  
      private String Senha;    
      public Date DataNascimento;
      public String Sexo;
      public String CPF;
      public String Telefone;  
      
      
      public void setId(Long id) {
		this.id = id;
	}

      
      private void  vereficarLogin(String Email,boolean Senha) {
    	  //return bool;
      }

	public Usuario(String nome, String email, String senha, Date dataNascimento, String sexo, String cPF,String telefone) {
		Nome = nome;
		Email = email;
		Senha = senha;
		DataNascimento = dataNascimento;
		Sexo = sexo;
		CPF = cPF;
		Telefone = telefone;
	}
	
	   public Usuario() {
	}

	public Long getId() {
		   return id;
	   }
	

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getSenha() {
		return Senha;
	}

	public void setSenha(String string) {
		Senha = string;
	}

	public Date getDataNascimento() {
		return DataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String string) {
		this.CPF = string;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}


	// o spring vai consultar quais sao os papeis(roles) que nosso usuario tem, entao é aqui que nos temos que retornar quais sao as roles do
	// meu usuario
	
}
