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
	  
	  private String nome;
	    private String email;
	    private String senha;    
	    private Date dataNascimento;
	    private String sexo;
	    private String cpf;
	    private String telefone;
		private String role;
		
		
		public Usuario(Long id, String nome, String email, String senha, Date dataNascimento, String sexo, String cpf,
				String telefone, String role) {
			this.id = id;
			this.nome = nome;
			this.email = email;
			this.senha = senha;
			this.dataNascimento = dataNascimento;
			this.sexo = sexo;
			this.cpf = cpf;
			this.telefone = telefone;
			this.role = role;
		}
		
		
		public Usuario() {
		}


		
		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getNome() {
			return nome;
		}


		public void setNome(String nome) {
			this.nome = nome;
		}


		public String getEmail() {
			return email;
		}


		public void setEmail(String email) {
			this.email = email;
		}


		public String getSenha() {
			return senha;
		}


		public void setSenha(String senha) {
			this.senha = senha;
		}


		public Date getDataNascimento() {
			return dataNascimento;
		}


		public void setDataNascimento(Date dataNascimento) {
			this.dataNascimento = dataNascimento;
		}


		public String getSexo() {
			return sexo;
		}


		public void setSexo(String sexo) {
			this.sexo = sexo;
		}


		public String getCpf() {
			return cpf;
		}


		public void setCpf(String cpf) {
			this.cpf = cpf;
		}


		public String getTelefone() {
			return telefone;
		}


		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}


		public String getRole() {
			return role;
		}


		public void setRole(String role) {
			this.role = role;
		}


		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getPassword() {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return null;
		} 
      
      
<<<<<<< HEAD
}
=======
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
>>>>>>> 2d5aa6a9000b6a28de71ab3e9ed1abbcba4432e8
