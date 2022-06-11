package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class VoceListaDAO {
	private static final
		String DBMS = "mysql",
		HOST = "localhost:3306",
		DBNAME = "listaSpesaDB",
		TABNAME = "lista",
		USER = "root",
		SECRET = "",
		CON_STR =
			"jdbc:%s://%s/%s?user=%s&password=%s"
				.formatted(
					DBMS, HOST, DBNAME,
					USER, SECRET
				);
	public static ArrayList<VoceLista> listItems() {
		final String q = "SELECT * FROM " + TABNAME + " ORDER BY voce ASC;";
		ArrayList<VoceLista> list = new ArrayList<>();
		try {
			Connection con = DriverManager.getConnection(CON_STR);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(q);
			while (rs.next())
				list.add(
					new VoceLista(
						rs.getInt("id"),
						rs.getString("voce")
					)
				);
			st.close();
			rs.close();
			con.close();
		} catch (Exception e) {
			System.err.printf("Errore query %s", q);
		}
		return list;
	}
	public static int deleteItem(VoceLista item) {
		final String q = "DELETE FROM " + TABNAME + " WHERE id=?;";
		int affectedRows = 0;
		try {
			Connection con = DriverManager.getConnection(CON_STR);
			PreparedStatement pst = con.prepareStatement(q);
			pst.setInt(1, item.getId());
			affectedRows = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.err.printf("Errore query %s", q);
		}
		return affectedRows;
	}
	public static int modifyItem(VoceLista item) {
		final String q = "UPDATE " + TABNAME + " SET voce=? WHERE id=?;";
		int affectedRows = 0;
		try {
			Connection con = DriverManager.getConnection(CON_STR);
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, item.getVoce());
			pst.setInt(2, item.getId());
			affectedRows = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.err.printf("Errore query %s %s %d", q, item, affectedRows);
			e.printStackTrace();
		}
		return affectedRows;
	}
	public static int addItem(VoceLista item) {
		final String q = "INSERT INTO " + TABNAME + "(voce) VALUES (?);";
		int affectedRows = 0;
		try {
			Connection con = DriverManager.getConnection(CON_STR);
			PreparedStatement pst = con.prepareStatement(q);
			pst.setString(1, item.getVoce());
			affectedRows = pst.executeUpdate();
			pst.close();
			con.close();
		} catch (Exception e) {
			System.err.printf("Errore query %s %s %d", q, item, affectedRows);
			e.printStackTrace();
		}
		return affectedRows;
	}
}