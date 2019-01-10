package DonnaGulaDAOS;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DonnaGulaModels.Cliente;

public class ClientDAO {

	private Connection connection;

	public ClientDAO() {
		connection = ConnectionFactory.getConnection();
	}

	public boolean inserir(Cliente cliente) {

		String sql = "insert into cliente (nome, endereco, email, contato, cartao, senha) values (?, ?, ?, ?, ?, ?);";

		try {
			PreparedStatement a = connection.prepareStatement(sql);

			a.setString(1, cliente.getNome());
			a.setString(2, cliente.getEndereco());
			a.setString(3, cliente.getEmail());
			a.setInt(4, cliente.getContato());
			a.setString(5, cliente.getCartao());
			a.setString(6, cliente.getSenha());

			a.execute();
			a.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return true;
	}
	

	public List<Cliente> getLista() {
		List<Cliente> result = new ArrayList<>();
		String sql = "select * from cliente";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			//stmt.setString(1, cliente);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Cliente
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setEmail(rs.getString("email"));
				cliente.setContato(rs.getInt("contato"));
				cliente.setCartao(rs.getString("cartao"));
				cliente.setSenha(rs.getString("senha"));

				// adicionando o objeto � lista
				result.add(cliente);
			}
			rs.close();
			stmt.close();
			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public boolean alterar(Cliente cliente) {
		String sql = "update cliente set nome=?, endereco=?, email=?, contato=?, cartao=? senha=? where id=?;";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getEmail());
			stmt.setInt(4, cliente.getContato());
			stmt.setString(5, cliente.getCartao());
			stmt.setString(6, cliente.getSenha());
			stmt.setLong(7, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Cliente cliente) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from cliente where id=?;");
			stmt.setLong(1, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	public Cliente getById(Long id) {
		Cliente result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from cliente where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Aluno
				result = new Cliente();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setEndereco(rs.getString("endereco"));
				result.setEmail(rs.getString("email"));
				result.setContato(rs.getInt("contato"));
				result.setCartao(rs.getString("cartao"));
				result.setSenha(rs.getString("senha"));

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public Cliente getByNome(String nome) {
		Cliente result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from cliente where nome = ?;");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Cliente();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setEndereco(rs.getString("endereco"));
				result.setEmail(rs.getString("email"));
				result.setContato(rs.getInt("contato"));
				result.setCartao(rs.getString("cartao"));
				result.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public List<Cliente> getCliente() {
		List<Cliente> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from cliente;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto Cliente
				Cliente cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setEmail(rs.getString("email"));
				cliente.setContato(rs.getInt("contato"));
				cliente.setCartao(rs.getString("cartao"));
				cliente.setSenha(rs.getString("senha"));

				// adicionando o objeto � lista
				result.add(cliente);
			}
			rs.close();
			stmt.close();

			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public Cliente getClienteByID(Long id) {
		try {

			Cliente cliente = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from cliente where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getLong("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEndereco(rs.getString("endereco"));
				cliente.setEmail(rs.getString("email"));
				cliente.setContato(rs.getInt("contato"));
				cliente.setCartao(rs.getString("cartao"));
				cliente.setSenha(rs.getString("senha"));
			}
			rs.close();
			stmt.close();
			return cliente;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}


