package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Exception.DbException;
import db.DB_access;

public class Update {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pst = null;
	
	public Update() {
		
	}
	
	public void show() {
		try {
			conn = DB_access.getConnection();
			
			System.out.println("Digite o id do produto que você quer alterar o preço");
			int id = sc.nextInt();
			System.out.println("Digite o novo preço desse produto");
			double preco = sc.nextDouble();
			
			pst = conn.prepareStatement("update produtos set preco = ? where id = ?", Statement.RETURN_GENERATED_KEYS);
			pst.setDouble(1, preco);
			pst.setInt(2, id);
			
			int rowsAffected = pst.executeUpdate();
			System.out.println("Feito! Linhas afetadas: " +rowsAffected);
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
