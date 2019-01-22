package DonnaGulaDAOS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import DonnaGulaModels.Carrinho;


public class CarrinhoDAO {
	private Connection connection;

	public CarrinhoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Carrinho carrinho) {

		String sql = "insert into carrinho (id, nome, recheio, quantidade, preco) values ( ?, ?, ?, ?);";

	try{
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setLong(1, carrinho.getA().getId());
		stmt.setLong(2, emprestimo.getLivro().getId());
		stmt.setDate(3, new java.sql.Date(calendario));
		

		stmt.execute();
		stmt.close();

	} catch (SQLException e) {
		e.printStackTrace();
		return true;
	}

	return false;
}
}