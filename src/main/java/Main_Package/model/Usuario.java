package Main_Package.model;

import java.util.Date;

public class Usuario {
      public String Nome;
      public String Email;
      public boolean Senha;
      public Date DataNascimento;
      public String Sexo;
      public int CPF;
      public String Telefone;
      
      
      private void alterarDados(String Nome,String Email,Date DataNascimento,String Sexo,int CPF,String Telefone){
    	  //return dadosAlterados;
      }
      
      private void  vereficarLogin(String Email,boolean Senha) {
    	  //return bool;
      }

	public Usuario(String nome, String email, boolean senha, Date dataNascimento, String sexo, int cPF,
			String telefone) {
		super();
		Nome = nome;
		Email = email;
		Senha = senha;
		DataNascimento = dataNascimento;
		Sexo = sexo;
		CPF = cPF;
		Telefone = telefone;
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

	public boolean isSenha() {
		return Senha;
	}

	public void setSenha(boolean senha) {
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

	public void setCPF(int cPF) {
		CPF = cPF;
	}

	public String getTelefone() {
		return Telefone;
	}

	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
      
      
      
	
}
