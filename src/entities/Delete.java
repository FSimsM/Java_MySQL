package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Exception.DbException;
import db.DB_access;

public class Delete {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pst = null;
	
	public Delete() {
		
	}
	
	public void show() {
		try {//Usar o try/ Catch para conseguir iniciar a conexçao
			conn = DB_access.getConnection();//sempre inciiar dentro do try/ catch
			
			System.out.println("Digite o id do produto que você quer deletar");
			int id = sc.nextInt();
			
			pst = conn.prepareStatement("Delete from produtos where id = ?", Statement.RETURN_GENERATED_KEYS);
			//Código MySQL para deletar dados
			pst.setInt(1, id);
			
			int rowsAffected = pst.executeUpdate();
			System.out.println("Feito! Linhas alteradas: " +rowsAffected);
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
