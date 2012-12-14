package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.jdbc.ConectionJDBC;
import domain.AreaConhecimento;

public class AreaConhecimentoDAO {

	private Connection connection;

	public AreaConhecimentoDAO() {
		connection = new ConectionJDBC().getConnection();
	}

<<<<<<< HEAD
	public void insert(AreaConhecimento area) {
		try {

			String sql = "insert into area(nome) values(?)";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, area.getNome());

			stm.execute();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void update(AreaConhecimento area) {
		try {

			String sql = "update area set nome = ? where idArea = ?";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, area.getNome());
			stm.setString(2, String.valueOf(area.getId()));

			stm.execute();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(AreaConhecimento area) {
		try {

			String sql = "delete from area where idArea = ?";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, String.valueOf(area.getId()));

=======
	public void insert(AreaConhecimento area){
		try {

			String sql = "insert into Area(nome) values(?)";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, area.getNomeArea());
			
			stm.execute();
			stm.close();

		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void update(AreaConhecimento area){
		try {

			String sql = "update Area set nome = ? where idArea = ?";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, area.getNomeArea());
			stm.setString(2, String.valueOf(area.getId()));
			
			stm.execute();
			stm.close();

		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void delete(AreaConhecimento area){
		try {

			String sql = "delete from Area where idArea = ?";

			PreparedStatement stm = connection.prepareStatement(sql);
			stm.setString(1, String.valueOf(area.getId()));
			
>>>>>>> Mudanças Web MAdrugada
			stm.execute();
			stm.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<AreaConhecimento> selectAll() {
		try {
			ArrayList<AreaConhecimento> areas = new ArrayList<AreaConhecimento>();
<<<<<<< HEAD
			PreparedStatement stm = connection
					.prepareStatement("select * from area order by nome");
=======
			PreparedStatement stm = connection.prepareStatement("select * from Area order by nome");
>>>>>>> Mudanças Web MAdrugada

			ResultSet rs = stm.executeQuery();

			while (rs.next()) {
				AreaConhecimento result = new AreaConhecimento();
				result.setId(rs.getInt("idArea"));
				result.setNome(rs.getString("nome"));

				areas.add(result);
			}

			stm.close();
			rs.close();

			return areas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
<<<<<<< HEAD

=======
	
>>>>>>> Mudanças Web MAdrugada
}