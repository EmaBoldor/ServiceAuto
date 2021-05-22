package ro.emanuel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ro.emanuel.helpers.ServiceDBHelper;
import ro.emanuel.pojo.Client;


public class ClientDAO {

public static Client getClientById(int id) throws SQLException {
		
		String select = "select * from client where id=?";
		Connection con=ServiceDBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setInt(1, id);
		ResultSet rs =stmt.executeQuery();
		Client result = null;
		if (rs.next()) {
			String nume = rs.getString("nume");
			String email = rs.getString("email");
			int telefon = rs.getInt("telefon");
			result = new Client(id, nume, email, telefon);
		}
		ServiceDBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Client> getClientByName(String nameQuery) throws SQLException{
		String select = "select * from client where nume LIKE ?";
		Connection con = ServiceDBHelper.getConnection();
		PreparedStatement stmt = con.prepareStatement(select);
		stmt.setString(1, "%"+ nameQuery+"%");
		ArrayList<Client> result = new ArrayList<Client>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String email = rs.getString("email");
			int telefon = rs.getInt("telefon");

			Client s = new Client(id, nume, email, telefon);

			result.add(s);
		}
		ServiceDBHelper.closeConnection();
		return result;
	}
	
	public static ArrayList<Client> getClienti() throws SQLException {

		String select = "select * from client";

		Connection con = ServiceDBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(select);

		ArrayList<Client> result = new ArrayList<Client>();
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {

			int id = rs.getInt("id");
			String nume = rs.getString("nume");
			String email = rs.getString("email");
			int telefon = rs.getInt("telefon");

			Client s = new Client(id, nume, email, telefon);

			result.add(s);
		}
		ServiceDBHelper.closeConnection();
		return result;
	}
	
	public static void createClient(String nume, String email, int telefon) throws SQLException{
		String insert="insert into client (nume,email,telefon)"
				+ "value(?,?,?);";
		
		Connection con = ServiceDBHelper.getConnection();
		
		PreparedStatement stmt = con.prepareStatement(insert);
		
		stmt.setString(1,nume);
		stmt.setString(2, email);
		stmt.setInt(3, telefon);
		
		stmt.executeUpdate();
		
		ServiceDBHelper.closeConnection();
	}
	
	public static void createClient(Client s) throws SQLException {
		createClient(s.getNume(),s.getEmail(),s.getTelefon());
	}
	
	public static void updateClient(Client s) throws SQLException {
		String update = "update client set nume=?, email=?,telefon=? where id=?";
	
		Connection con = ServiceDBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(update);
		
		stmt.setString(1, s.getNume());
		stmt.setString(2, s.getEmail());
		stmt.setInt(3, s.getTelefon());
		stmt.setInt(4, s.getId());
		
		stmt.executeUpdate();
		
		ServiceDBHelper.closeConnection();
				
	}
	public static void deleteClient(int id) throws SQLException{
		String delete = "delete from client where id=?";
		
		Connection con = ServiceDBHelper.getConnection();

		PreparedStatement stmt = con.prepareStatement(delete);
		
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		
		ServiceDBHelper.closeConnection();
	}
	
	public static void deleteClient(Client s) throws SQLException {
		
		deleteClient(s.getId());
	}
}
