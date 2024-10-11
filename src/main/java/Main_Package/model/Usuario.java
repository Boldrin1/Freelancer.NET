package Main_Package.model;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  
      public String Nome;
      public String Email;
      private int Senha;
      public Date DataNascimento;
      public String Sexo;
      public int CPF;
      public String Telefone;
      
      
      public void setId(Long id) {
		this.id = id;
	}

	private void alterarDados(String Nome,String Email,Date DataNascimento,String Sexo,int CPF,String Telefone){
    	  //return dadosAlterados;
      }
      
      private void  vereficarLogin(String Email,boolean Senha) {
    	  //return bool;
      }

	public Usuario(String nome, String email, int senha, Date dataNascimento, String sexo, int cPF,String telefone) {
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

	public int getSenha() {
		return Senha;
	}

	public void setSenha(int senha) {
		Senha = senha;
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

	public int getCPF() {
		return CPF;
	}

	public void setCPF(int CPF) {
		this.CPF = CPF;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}


      
}
