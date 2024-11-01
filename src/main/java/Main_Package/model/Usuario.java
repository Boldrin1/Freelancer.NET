package Main_Package.model;

import java.util.Date;

import javax.management.relation.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity

public class Usuario{
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
		private Role role;
		public Usuario(Long id, String nome, String email, String senha, Date dataNascimento, String sexo, String cpf,
				String telefone, Role role) {
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
		public Role getRole() {
			return role;
		}
		public void setRole(Role role) {
			this.role = role;
		}
		
		
		
}