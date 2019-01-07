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
		String sql = "select * from alunos";
		
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
			stmt.setString(1, cliente.getMatricula());
			stmt.setString(2, cliente.getNome());
			stmt.setString(3, cliente.getCPF());
			stmt.setString(4, cliente.getEndereco());
			stmt.setDate(5, new java.sql.Date(cliente.getDataNascimento().getTimeInMillis()));
			stmt.setLong(6, cliente.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean remover(Aluno aluno) {
		try {
			PreparedStatement stmt = connection.prepareStatement("delete from alunos where id=?;");
			stmt.setLong(1, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Aluno getById(Long id) {
		Aluno result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos where id = ?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				// criando o objeto Aluno
				result = new Aluno();
				result.setId(rs.getLong("id"));
				result.setMatricula(rs.getString("matricula"));
				result.setNome(rs.getString("nome"));
				result.setCPF(rs.getString("CPF"));
				result.setEndereco(rs.getString("endereco"));

				// montando a data atrav�s do Calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public Aluno getByMatricula(String matricula) {
		Aluno result = null;

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos where matricula = ?;");
			stmt.setString(1, matricula);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				result = new Aluno();
				result.setId(rs.getLong("id"));
				result.setNome(rs.getString("nome"));
				result.setMatricula(rs.getString("matricula"));
				result.setEndereco(rs.getString("endereco"));
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				result.setDataNascimento(dataNascimento);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public List<Aluno> getAlunos() {
		List<Aluno> result = new ArrayList<>();

		try {
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// criando o objeto aluno
				Aluno alun = new Aluno();
				alun.setId(rs.getLong("id"));
				alun.setNome(rs.getString("nome"));
				alun.setCPF(rs.getString("cpf"));
				alun.setMatricula(rs.getString("matricula"));
				alun.setEndereco(rs.getString("endereco"));
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				alun.setDataNascimento(dataNascimento);
			
				result.add(alun);
			}
			rs.close();
			stmt.close();

			return result;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	public Aluno getAlunoByID(Long id) {
		try {

			Aluno alun = null;
			PreparedStatement stmt = this.connection.prepareStatement("select * from alunos where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				alun = new Aluno();
				alun.setId(rs.getLong("id"));
				alun.setNome(rs.getString("nome"));
				alun.setCPF(rs.getString("cpf"));
				alun.setMatricula(rs.getString("matricula"));
				Calendar dataNascimento = Calendar.getInstance();
				dataNascimento.setTime(rs.getDate("dataNascimento"));
				alun.setDataNascimento(dataNascimento);
			}
			rs.close();
			stmt.close();
			return alun;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}


