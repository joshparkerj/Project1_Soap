package com.revature.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.revature.domain.Manufacturer;

public class ManufacturerDAO {

	private static ManufacturerDAO dao = new ManufacturerDAO();
	private static final String url = "jdbc:postgresql://localhost:5432/p1SOAP";
	private static Connection conn;

	public static ManufacturerDAO getDAO() {
		return dao;
	}

	public static Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
		}
		if (conn == null) {
			try {
				conn = DriverManager.getConnection(url);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}

	public void setup() {
		Connection conn = getConnection();
		String sql = "CREATE TABLE IF NOT EXISTS manufacturer (\n" + "	name text PRIMARY KEY,\n"
				+ "	address text NOT NULL,\n" + "	city text NOT NULL,\n" + "	state text NOT NULL,\n"
				+ "	zipcode text NOT NULL,\n" + "	phone text NOT NULL,\n" + "	email text NOT NULL\n" + ");";
		try {
			Statement statement = conn.createStatement();
			statement.execute(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public Manufacturer addManufacturer(Manufacturer manufacturer) {
		String sql = "INSERT INTO manufacturer (name, address, city, state, zipcode, phone, " + "email) "
				+ "VALUES (?,?,?,?,?,?,?)";
		Connection conn = getConnection();
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, manufacturer.getCompanyName());
			pstmt.setString(2, manufacturer.getAddress());
			pstmt.setString(3, manufacturer.getCity());
			pstmt.setString(4, manufacturer.getState());
			pstmt.setString(5, manufacturer.getZipcode());
			pstmt.setString(6, manufacturer.getPhone());
			pstmt.setString(7, manufacturer.getEmail());
			int affectedRows = pstmt.executeUpdate();
			if (affectedRows == 0) {
				throw new SQLException("Manufacturer insertion failed, no rows affected.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return manufacturer;
	}

	public Manufacturer getManufacturer(String manufacturerName) {
		Manufacturer manufacturer = new Manufacturer();
		String sql = "SELECT name, address, city, state, zipcode, phone, email " + "FROM manufacturer WHERE name = ?";
		Connection conn = getConnection();
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, manufacturerName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				manufacturer.setCompanyName(rs.getString("name"));
				manufacturer.setAddress(rs.getString("address"));
				manufacturer.setCity(rs.getString("city"));
				manufacturer.setState(rs.getString("state"));
				manufacturer.setZipcode(rs.getString("zipcode"));
				manufacturer.setPhone(rs.getString("phone"));
				manufacturer.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manufacturer;
	}

	public List<Manufacturer> getAll() {
		List<Manufacturer> list = new ArrayList<Manufacturer>();
		String sql = "SELECT name, address, city, state, zipcode, phone, email " + "FROM manufacturer";
		Connection conn = getConnection();
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Manufacturer manufacturer = new Manufacturer();
				manufacturer.setCompanyName(rs.getString("name"));
				manufacturer.setAddress(rs.getString("address"));
				manufacturer.setCity(rs.getString("city"));
				manufacturer.setState(rs.getString("state"));
				manufacturer.setZipcode(rs.getString("zipcode"));
				manufacturer.setPhone(rs.getString("phone"));
				manufacturer.setEmail(rs.getString("email"));
				list.add(manufacturer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Collections.sort(list);
		return list;
	}

	public Boolean deleteManufacturer(Manufacturer manufacturer) {
		String sql = "DELETE FROM aircraft WHERE name = ?";
		Connection conn = getConnection();
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, manufacturer.getCompanyName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return true;
	}

	public Manufacturer updateManufacturer(Manufacturer manufacturer) {
		String sql = "UPDATE aircraft SET address = ? , city = ? , "
				+ "state = ? , zipcode = ? , phone = ? , email = ? " + "WHERE name = ?";
		Connection conn = getConnection();
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, manufacturer.getAddress());
			pstmt.setString(2, manufacturer.getCity());
			pstmt.setString(3, manufacturer.getState());
			pstmt.setString(4, manufacturer.getZipcode());
			pstmt.setString(5, manufacturer.getPhone());
			pstmt.setString(6, manufacturer.getEmail());
			pstmt.setString(7, manufacturer.getCompanyName());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.exit(1);
		}
		return manufacturer;
	}
}
