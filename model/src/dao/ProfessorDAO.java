package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.jdbc.ConectionJDBC;
import domain.Professor;

public class ProfessorDAO {

	private Connection connection;

	public ProfessorDAO() {
		connection = new ConectionJDBC().getConnection();
	}

	public void insert(Professor professor) {
		try {

			String sql = "insert into professor(nome) values(?)";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, professor.getNome());

			stm.execute();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Professor professor) {
		try {

			String sql = "update professor set nome = ? where id = ?";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, professor.getNome());
			stm.setString(2, String.valueOf(professor.getId()));

			stm.execute();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(Professor professor) {
		try {

			String sql = "delete from professor where id = ?";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, String.valueOf(professor.getId()));

			stm.execute();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Professor> selectAll() {
		try {
			ArrayList<Professor> professores = new ArrayList<Professor>();
			PreparedStatement stm = connection
					.prepareStatement("select id, nome from professor order by nome");

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Professor result = new Professor(null);
				result.setId(rs.getInt("id"));
				result.setNome(rs.getString("nome"));

				professores.add(result);
			}

			stm.close();
			rs.close();

			return professores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}