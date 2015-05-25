package mestreCuca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Conexao {
	
	public void inserirNoBanco(String nome){
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/mestrecuca", "sa", "");
			PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Receita (nome) VALUES (?)");
			preparedStatement.setString(1, nome);
			preparedStatement.executeUpdate();
			connection.close();
		} catch (Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public String pesquisarNoBanco(){
//GAMBIARRA
		String nomes = "";
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/~/mestrecuca", "sa", "");
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Receita");
			ResultSet result = preparedStatement.executeQuery();

			while(result.next()){
			    nomes += result.getString("nome");
			    nomes += "\n";
			}
			connection.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return nomes;
	}
}
