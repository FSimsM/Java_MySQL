package entities;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Exception.DbException;
import db.DB_access;

public class ShowEspecificTable {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	Statement st = null;
	ResultSet rs = null;
	
	public ShowEspecificTable() {
		
	}
	
	public void show() {
		try {
			conn = DB_access.getConnection();
			st = conn.createStatement();
			
			System.out.println("Qual tabela você quer acessar:");
			System.out.println("1- departamentos");
			System.out.println("2- produtos");
			int n = sc.nextInt();
			
			if(n == 1) {
				rs = st.executeQuery("select * from departamentos");
			
				while(rs.next()) {
					System.out.println("------------------------------------------\n"
										+ "Id: " +rs.getInt("id")+ "\n"
										+ "Nome: " +rs.getString("nome"));
				}
			}
			else if(n == 2) {
				rs = st.executeQuery("select * from produtos");
				
				while(rs.next()) {
					System.out.println("--------------------------------------------\n"
										+ "Id: " +rs.getInt("id")+ "\n"
										+ "Nome: " +rs.getString("nome")+ "\n"
										+ "Preço: R$" +rs.getDouble("preco")+ "\n"
										+ "Id do departamento: " +rs.getInt("departamento"));
				}
			}
			else {
				System.out.println("Essa opção não existe!");
			}
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		
	}

}
