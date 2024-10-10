package Main_Package.dao;


import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import Main_Package.factory.ConnectionFactory;
import Main_Package.model.Usuario;

public class FreelancerDAO {

	/*
	 *  CRUD
	 *  c: CREATE
	 *  r: READ
	 *  u: UPDATE
	 *  d: DELETE 
	 *   
	 */
	
	public void save(Usuario usuario) {
		String sql = "INSERT INTO usuario(nome,email,senha,DataNascimento,Sexo,CPF,Telefone) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//Criar uma conexão com o Banco de Dados
			conn = ConnectionFactory.createConnectionToMySql();
			
			
			//Criamos uma PreparedStatement, para executar uma query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//Adicionar os valores que são esperados pela query
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setInt(3, usuario.getSenha());
			pstm.setDate(4, new Date(usuario.getDataNascimento().getTime()));
			pstm.setString(5,usuario.getSexo());
			pstm.setInt(6, usuario.getCPF());
			pstm.setString(7, usuario.getTelefone());
			
			//Executar a query
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			
			//Fechar as conexões
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
