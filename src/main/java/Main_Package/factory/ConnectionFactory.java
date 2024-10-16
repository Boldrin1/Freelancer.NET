/*package Main_Package.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	//Nomde do usuario do my sql
	private static final String USERNAME = "root";
	
	//Senha do banco
	private static final String PASSWORD = "1";
	
	//Caminho do banco de dados, porta
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/FreelancerNET";
	
	
	 * Conexao com o banco de dados
	 
	
	public static Connection createConnectionToMySql() throws Exception{
		//Faz com que a classe seja caregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		//Cria a conexao com o banco de dados
		Connection connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		return connection;
	}
	
	public static void main(String[] args ) throws Exception {
		//Recuperar uma conexão com o banco de dados
		Connection con = createConnectionToMySql();
		
		//Testar se a conexão é nula
		if(con != null) {
			System.out.println("Conexão obetida com sucesso!");
			con.close();
		}
	}
}*/
