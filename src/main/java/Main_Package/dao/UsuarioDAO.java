package Main_Package.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

import Main_Package.factory.ConnectionFactory;
import Main_Package.model.Usuario;

public class UsuarioDAO {

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


	public List<Usuario> getUsuario(){
		String sql = "SELECT * FROM usuarios";
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		
		//Classe que vai recuperar os dados do banco.   *****SELECT*****
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySql();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			
			while (rset.next()) {
				Usuario usuario = new Usuario();
				
				//Recuperar o id
				usuario.setId(rset.getLong("id"));
				//Recuperar o nome
				usuario.setNome(rset.getString("nome"));
				//Recuperar o email
				usuario.setEmail(rset.getString("email"));
				
				usuario.setSenha(rset.getInt("senha"));
				
				usuario.setDataNascimento(rset.getDate("datadenascimento"));
				
				usuario.setSexo(rset.getString("sexo"));
				
				usuario.setCPF(rset.getInt("cpf"));
				
				usuario.setTelefone(rset.getString("telefone"));
				
				usuarios.add(usuario);
				
			}
				
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
				if(rset!=null) {
					rset.close();
				}
				
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
	
		return usuarios;
	}

	
	
	
	
}
