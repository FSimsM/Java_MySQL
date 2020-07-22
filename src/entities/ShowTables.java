package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Exception.DbException;
import db.DB_access;

public class ShowTables {
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public ShowTables() {
		
	}
	
	public void show() {
		try {
			conn = DB_access.getConnection();
			st = conn.createStatement();
			
			rs = st.executeQuery("Show tables");
			
			System.out.println("Tabelas: ");
			
			while(rs.next()) {
				System.out.println("Nome: " +rs.getString("Tables_in_eletronicos"));
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

}
