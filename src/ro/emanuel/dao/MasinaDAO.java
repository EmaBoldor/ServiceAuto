package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.ServiceDBHelper;
import ro.emanuel.pojo.Masina;


public class MasinaDAO {

public static Masina getMasinaById(int id) throws SQLException {
		
		String select = "select * from masina where id=?";
		Connection con=ServiceDBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs =stmt.executeQuery();
		Masina result = null;
		if (rs.next()) {
			String marca = rs.getString("marca");
			String model = rs.getString("model");
			String culoare = rs.getString("culoare");
			result = new Masina(id, marca, model, culoare);
		}
		ServiceDBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Masina> getMasinaByName(String nameQuery) throws SQLException{
		String select = "select * from masina where nume LIKE ?";
		Connection con = ServiceDBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, "%"+ nameQuery+"%");
		ArrayList<Masina> result = new ArrayList<Masina>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int id = rs.getInt("id");
			String marca = rs.getString("marca");
			String model = rs.getString("model");
			String culoare = rs.getString("culoare");

			Masina s = new Masina(id, marca, model, culoare);

			result.add(s);
		}
		ServiceDBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Masina> getMasini() throws SQLException {

		String select = "select * from masina";

		Connection con = ServiceDBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Masina> result = new ArrayList<Masina>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int id = rs.getInt("id");
			String marca = rs.getString("marca");
			String model = rs.getString("model");
			String culoare = rs.getString("culoare");

			Masina s = new Masina(id, marca, model, culoare);

			result.add(s);
		}
		ServiceDBHelper.closeConnection();
		return result;
	}
	
	public static void createMasina(String marca, String model, String culoare) throws SQLException{
		String insert="insert into client (marca, model, culoare)"
				+ "value(?,?,?);";
		
		Connection con = ServiceDBHelper.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(insert);
		
		stmt.setString(1,marca);
		stmt.setString(2, model);
		stmt.setString(3, culoare);
		
		stmt.executeUpdate();
		
		ServiceDBHelper.closeConnection();
	}
	
	public static void createMasina(Masina s) throws SQLException {
		createMasina(s.getMarca(),s.getModel(),s.getCuloare());
	}
	
	public static void updateMasina(Masina s) throws SQLException {
		String update = "update masina set marca=?, model=?,culoare=? where id=?";
	
		Connection con = ServiceDBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(update);
		
		stmt.setString(1, s.getMarca());
		stmt.setString(2, s.getModel());
		stmt.setString(3, s.getCuloare());
		stmt.setInt(4, s.getId());
		
		stmt.executeUpdate();
		
		ServiceDBHelper.closeConnection();
				
	}
	public static void deleteMasina(int id) throws SQLException{
		String delete = "delete from masina where id=?";
		
		Connection con = ServiceDBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(delete);
		
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		
		ServiceDBHelper.closeConnection();
	}
	
	public static void deleteMasina(Masina s) throws SQLException {
		
		deleteMasina(s.getId());
	}
}
