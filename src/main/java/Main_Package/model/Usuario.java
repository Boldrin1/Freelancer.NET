package Main_Package.model;

import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;



@MappedSuperclass
public class Usuario{
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	  
	    private String nome;
	    @Column(unique = true)
	    private String email;
	    private String senha;    
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date dataNascimento;
	    private String sexo;
	    private String cpf;
	    private String telefone;
		private role role;
		public Usuario(Long id, String nome, String email, String senha, Date dataNascimento, String sexo, String cpf,
				String telefone, role role) {
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
		public role getRole() {
			return role;
		}
		public void setRole(role role) {
			this.role = role;
		}
		
		
		
		
		
}