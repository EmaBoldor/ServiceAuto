package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.ServiceDBHelper;
import ro.emanuel.pojo.Angajat;


public class AngajatDAO {

public static Angajat getAngajatById(int id) throws SQLException {
		
		String select = "select * from angajat where id=?";
		Connection con=ServiceDBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs =stmt.executeQuery();
		Angajat result = null;
		if (rs.next()) {
			String nume = rs.getString("nume");
			int vechime = rs.getInt("vechime");
			String calificare = rs.getString("calificare");
			result = new Angajat(id, nume, vechime, calificare);
		}
		ServiceDBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Angajat> getAngajatByName(String nameQuery) throws SQLException{
		String select = "select * from angajat where nume LIKE ?";
		Connection con = ServiceDBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, "%"+ nameQuery+"%");
		ArrayList<Angajat> result = new ArrayList<Angajat>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			int vechime = rs.getInt("vechime");
			String calificare = rs.getString("calificare");

			Angajat s = new Angajat(id, nume, vechime, calificare);

			result.add(s);
		}
		ServiceDBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Angajat> getAngajati() throws SQLException {

		String select = "select * from angajat";

		Connection con = ServiceDBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Angajat> result = new ArrayList<Angajat>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			int vechime = rs.getInt("vechime");
			String calificare = rs.getString("calificare");

			Angajat s = new Angajat(id, nume, vechime, calificare);

			result.add(s);
		}
		ServiceDBHelper.closeConnection();
		return result;
	}
	
	public static void createClient(String nume, int vechime, String calificare) throws SQLException{
		String insert="insert into client (nume, vechime, calificare)"
				+ "value(?,?,?);";
		
		Connection con = ServiceDBHelper.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(insert);
		
		stmt.setString(1,nume);
		stmt.setInt(2, vechime);
		stmt.setString(3, calificare);
		
		stmt.executeUpdate();
		
		ServiceDBHelper.closeConnection();
	}
	
	public static void createAngajat(Angajat s) throws SQLException {
		createClient(s.getNume(),s.getVechime(),s.getCalificare());
	}
	
	public static void updateAngajat(Angajat s) throws SQLException {
		String update = "update angajat set nume=?, vechime=?,calificare=? where id=?";
	
		Connection con = ServiceDBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(update);
		
		stmt.setString(1, s.getNume());
		stmt.setInt(2, s.getVechime());
		stmt.setString(3, s.getCalificare());
		stmt.setInt(4, s.getId());
		
		stmt.executeUpdate();
		
		ServiceDBHelper.closeConnection();
				
	}
	public static void deleteAngajat(int id) throws SQLException{
		String delete = "delete from angajat where id=?";
		
		Connection con = ServiceDBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(delete);
		
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		
		ServiceDBHelper.closeConnection();
	}
	
	public static void deleteAngajat(Angajat s) throws SQLException {
		
		deleteAngajat(s.getId());
	}
}
