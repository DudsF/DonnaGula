package DonnaGulaDAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DonnaGulaModels.Carrinho;
import DonnaGulaModels.Doces;
import DonnaGulaModels.Salgados;


public class CarrinhoDAO {
	private Connection connection;

	public CarrinhoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Carrinho carrinho) {

		String sql = "insert into carrinho (id, salgado, doce, quantidade, preco) values ( ?, ?, ?, ?);";

	try{
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setLong(1, carrinho.getDoces().getId());
		stmt.setLong(2, carrinho.getSalgados().getId());
		stmt.setInt(3, carrinho.getQuantidade());
		stmt.setFloat(4, carrinho.getPreco());
		

		stmt.execute();
		stmt.close();

	} catch (SQLException e) {
		e.printStackTrace();
		return true;
	}

	return false;
}
	public List<Carrinho> getLista() {
		List<Carrinho> lista = new ArrayList<Carrinho>();
			
			try {
				
			PreparedStatement stmt = this.connection.prepareStatement("select * from carrinho;");
			ResultSet rs = stmt.executeQuery();

			

			while (rs.next()) {
				Carrinho carrinho = new Carrinho();
				Doces doces = new DocesDAO().getByNome(rs.getString("doce"));
				Salgados salgados = new SalgadosDAO().getByNome(rs.getString("salgado"));
				carrinho.setDoces(doces);
				carrinho.setSalgados(salgados);

				lista.add(carrinho);
			}
			rs.close();

			stmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return lista;
	}
}