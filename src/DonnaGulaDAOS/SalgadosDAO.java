package DonnaGulaDAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DonnaGulaModels.Salgados;

public class SalgadosDAO {
private Connection connection;
	
	public SalgadosDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Salgados salgados) {

		String sql = "insert into salgados (nome, recheio, preco) values (?, ?, ?);";

		try {
			PreparedStatement a = connection.prepareStatement(sql);

			a.setString(1, salgados.getNome());
			a.setString(2, salgados.getRecheio());
			a.setInt(3, salgados.getPreco());
		

			a.execute();
			a.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	

	public List<Salgados> getLista() {
		List<Salgados> result = new ArrayList<>();
		String sql = "select * from salgados";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			//stmt.setString(1, salgados);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Salgados
				Salgados salgados = new Salgados();
				salgados.setId(rs.getLong("id"));
				salgados.setNome(rs.getString("nome"));
				salgados.setRecheio(rs.getString("recheio"));
				salgados.setPreco(rs.getInt("preco"));
				

				// adicionando o objeto � lista
				result.add(salgados);
			}
			rs.close();
			stmt.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public boolean alterar(Salgados salgados) {
		String sql = "update salgados set nome=?, recheio=?, preco=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, salgados.getNome());
			stmt.setString(2, salgados.getRecheio());
			stmt.setInt(3, salgados.getPreco());
			stmt.setLong(4, salgados.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Salgados salgados) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from salgados where id=?;");
			stmt.setLong(1, salgados.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public Salgados getById(Long id) {
		Salgados result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from salgados where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Salgados
				result = new Salgados();
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
	
	public Salgados getByNome(String nome) {
		Salgados result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from salgados where nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Salgados();
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
	
	public List<Salgados> getSalgados() {
		List<Salgados> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from salgados;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Salgados
				Salgados salgados = new Salgados();
				salgados.setId(rs.getLong("id"));
				salgados.setNome(rs.getString("nome"));
				salgados.setRecheio(rs.getString("recheio"));
				salgados.setPreco(rs.getInt("preco"));
				

				// adicionando o objeto � lista
				result.add(salgados);
			}
			rs.close();
			stmt.close();

			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public Salgados getSalgadosByID(Long id) {
		try {

			Salgados salgados = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from salgados where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				salgados = new Salgados();
				salgados.setId(rs.getLong("id"));
				salgados.setNome(rs.getString("nome"));
				salgados.setRecheio(rs.getString("recheio"));
				salgados.setPreco(rs.getInt("preco"));
				
			}
			rs.close();
			stmt.close();
			return salgados;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
