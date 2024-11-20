package Main_Package.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;



@Entity
@Table(name = "cliente")
public class Cliente extends Usuario{
	

	public Cliente(Long id, String nome, String email, String senha, Date dataNascimento, String sexo, String cpf,
			String telefone, Main_Package.model.role role) {
		super(id, nome, email, senha, dataNascimento, sexo, cpf, telefone, role);
	}
	
	public Cliente() {}



	private void criarServico() {
		   //return servicoCriado
	}

	private void excluirServico(Servico servico) {
		   //return servicoExcluido;
	}

	private void responderCurriculo(Curriculo curriculo) {
		   //return respostaEnviada
	}
	
	
}

