package DonnaGulaDAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DonnaGulaModels.Doces;

public class DocesDAO {
	private Connection connection;
	
	public DocesDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Doces doces) {

		String sql = "insert into doces (nome, recheio, preco) values (?, ?, ?);";

		try {
			PreparedStatement a = connection.prepareStatement(sql);

			a.setString(1, doces.getNome());
			a.setString(2, doces.getRecheio());
			a.setInt(3, doces.getPreco());
		

			a.execute();
			a.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	

	public List<Doces> getLista() {
		List<Doces> result = new ArrayList<>();
		String sql = "select * from doces";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			//stmt.setString(1, doces);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Doces
				Doces doces = new Doces();
				doces.setId(rs.getLong("id"));
				doces.setNome(rs.getString("nome"));
				doces.setRecheio(rs.getString("recheio"));
				doces.setPreco(rs.getInt("preco"));
				

				// adicionando o objeto � lista
				result.add(doces);
			}
			rs.close();
			stmt.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public boolean alterar(Doces doces) {
		String sql = "update doces set nome=?, recheio=?, preco=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, doces.getNome());
			stmt.setString(2, doces.getRecheio());
			stmt.setInt(3, doces.getPreco());
			stmt.setLong(4, doces.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Doces doces) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from doces where id=?;");
			stmt.setLong(1, doces.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public Doces getById(Long id) {
		Doces result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from doces where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Doces
				result = new Doces();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setRecheio(rs.getString("Recheio"));
				result.setPreco(rs.getInt("preco"));
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public Doces getByNome(String nome) {
		Doces result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from doces where nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Doces();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setRecheio(rs.getString("recheio"));
				result.setPreco(rs.getInt("preco"));
				
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public List<Doces> getDoces() {
		List<Doces> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from doces;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Doces
				Doces doces = new Doces();
				doces.setId(rs.getLong("id"));
				doces.setNome(rs.getString("nome"));
				doces.setRecheio(rs.getString("recheio"));
				doces.setPreco(rs.getInt("preco"));
				

				// adicionando o objeto � lista
				result.add(doces);
			}
			rs.close();
			stmt.close();

			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public Doces getDocesByID(Long id) {
		try {

			Doces doces = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from doces where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				doces = new Doces();
				doces.setId(rs.getLong("id"));
				doces.setNome(rs.getString("nome"));
				doces.setRecheio(rs.getString("Recheio"));
				doces.setPreco(rs.getInt("preco"));
				
			}
			rs.close();
			stmt.close();
			return doces;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}


}
