package entities;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Exception.DbException;
import db.DB_access;

public class Insert {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	PreparedStatement pst = null;
	
	public Insert() {
		
	}
	
	public void show() {
		try {
			conn = DB_access.getConnection();
			
			System.out.println("Escolha qual tabela vocÊ quer inserir dados:");
			System.out.println("1- Departamentos");
			System.out.println("2- Produtos");
			int n = sc.nextInt();
			
			if(n == 1) {			
				System.out.println("Digite os dados do departamento que você quer adicionar:");
				System.out.println("Nome:");
				String nome = sc.next();
				
				pst = conn.prepareStatement("insert into departamentos (nome) values (?)", Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, nome);
				
				int rowsAffected = pst.executeUpdate();
				System.out.println("Feito! Linha alteradas: " +rowsAffected);
			}
			else if(n == 2) {
				System.out.println("Digite os dados do produto que vocÊ quer adicionar:");
				System.out.println("Nome:");
				String nome = sc.next();
				System.out.println("Preço:");
				double preco = sc.nextDouble();
				System.out.println("Id do departamento:");
				int idDep = sc.nextInt();
				
				pst = conn.prepareStatement("insert into produtos (nome, preco, departamento)" +
											"values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
				pst.setString(1, nome);
				pst.setDouble(2, preco);
				pst.setInt(3, idDep);
				
				int rowsAffected = pst.executeUpdate();
				System.out.println("Feito! Linhas alteradas: " +rowsAffected);
			}
			else {
				System.out.println("Tabela não exitente");
			}
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
	}

}
