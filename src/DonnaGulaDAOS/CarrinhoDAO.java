package DonnaGulaDAOS;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import DonnaGulaModels.Carrinho;
import DonnaGulaModels.Cliente;
import DonnaGulaModels.Doces;
import DonnaGulaModels.Salgados;

public class CarrinhoDAO {
	private Connection connection;

	public CarrinhoDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Carrinho carrinho) {

		String sql = "insert into carrinho(salgado, doce, quantidade) values ( ?, ?, ?, ?);";

	try{
		
		PreparedStatement stmt = connection.prepareStatement(sql);
		
		stmt.setLong(1, carrinho.getSalgados().getId());
		stmt.setLong(2, carrinho.getDoces().getId());
		stmt.setInt(3, carrinho.getQuantidade());
		

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
	public List<Carrinho> getPesquisar() {
		List<Carrinho> lista = new ArrayList<Carrinho>();
			
			try {
				
			PreparedStatement stmt = this.connection.prepareStatement("select * from carrinho where doce like '%brigadeiro%' ");
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
	private Carrinho formacaoCarrinho(ResultSet rs) throws SQLException {
		Carrinho carrinho = new Carrinho();
		carrinho.setId(rs.getLong("id"));
		Doces doce = new DocesDAO().getById(rs.getLong("doce"));
		carrinho.setDoces(doce);
		Salgados salgado = new SalgadosDAO().getById(rs.getLong("salgado"));
		carrinho.setSalgados(salgado);
		
		return carrinho;
		}
	public Carrinho getCarrinhoByID(Long id) {
		try {

			Carrinho carrinho = null;
			
			PreparedStatement stmt = this.connection.prepareStatement("select * from carrinho where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				carrinho = formacaoCarrinho(rs);
			}
			rs.close();
			stmt.close();
			return carrinho;
		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}
	public List<Carrinho> getLista1() {
		try {

			List<Carrinho> carrinho = new ArrayList<Carrinho>();
			PreparedStatement stmt = connection.prepareStatement("select * from carrinho;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				carrinho.add (formacaoCarrinho(rs));
				 
			}
			rs.close();
			stmt.close();
			return carrinho;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public boolean alterar(Carrinho carrinho) {
		String sql = "update cliente set doce=?, salgado=?, quantidade=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, carrinho.getSalgados().getId());
			stmt.setLong(2, carrinho.getDoces().getId());
			stmt.setInt(3, carrinho.getQuantidade());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
