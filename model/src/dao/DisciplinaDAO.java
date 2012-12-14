package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.jdbc.ConectionJDBC;
import domain.AreaConhecimento;
import domain.Disciplina;

public class DisciplinaDAO {

	private Connection connection;

	public DisciplinaDAO() {
		connection = new ConectionJDBC().getConnection();
	}

	public void insert(Disciplina disciplina) {
		try {

			String sql = "insert into disciplina(nome, id_areaconhecimento) values(?, ?)";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, disciplina.getNome());
			stm.setString(2, String.valueOf(disciplina.getArea().getId()));

			stm.execute();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(Disciplina disciplina) {
		try {

			String sql = "update disciplina set nome = ?, id_areaconhecimento = ? where id = ?";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, disciplina.getNome());
			stm.setString(2, String.valueOf(disciplina.getArea().getId()));
			stm.setString(3, String.valueOf(disciplina.getId()));

			stm.execute();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(Disciplina disciplina) {
		try {

			String sql = "delete from disciplina where id = ?";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, String.valueOf(disciplina.getId()));

			stm.execute();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<Disciplina> selectAll() {
		try {
			ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
			PreparedStatement stm = connection
					.prepareStatement("select id, nome, id_areaconhecimento from disciplina order by disciplina.nome");

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				Disciplina result = new Disciplina(null, null);
				result.setId(rs.getInt("id"));
				result.setNome(rs.getString("nome"));
				AreaConhecimento area = selectAreaConhecimento(rs.getInt("id"));
				result.setArea(area);

				disciplinas.add(result);
			}

			stm.close();
			rs.close();

			return disciplinas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private AreaConhecimento selectAreaConhecimento(long id) {
		try {
			AreaConhecimento area = new AreaConhecimento();
			PreparedStatement stm = connection
					.prepareStatement("select id, nome from areaconhecimento where id = ?");
			stm.setString(1, String.valueOf(id));
			ResultSet rs = stm.executeQuery();

			rs.next();
			area.setId(id);
			area.setNome(rs.getString("nome"));

			stm.close();
			rs.close();

			return area;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}