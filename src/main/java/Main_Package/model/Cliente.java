package Main_Package.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
   private void criarServico() {
	   //return servicoCriado
   }
   
   private void excluirServico(Servico servico) {
	   //return servicoExcluido;
   }
   
   private void responderCurriculo(Curriculo curriculo) {
	   //return respostaEnviada
   }
   
   private void avaliarFreelancer(Freelancer freelancer) {
	   //return avaliacaoRealizada
   }
   
   private void confirmarServicoRealizado(OrdemDeServico ordem) {
	   //return confirmaRealizada
   }
}
