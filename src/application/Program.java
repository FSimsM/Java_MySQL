package application;

import java.util.Scanner;

import entities.Delete;
import entities.Insert;
import entities.ShowEspecificTable;
import entities.ShowTables;
import entities.Update;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		
		do {
			System.out.println();
			System.out.println("Escolha a ação que você quer fazer:");
			System.out.println("1- Mostrar tabelas no banco de dados");
			System.out.println("2- Mostrar conteudo em uma tabela especifica");
			System.out.println("3- Adicionar dados em uma tabela");
			System.out.println("4- Atualizar preço do produto");
			System.out.println("5- Deletar produto");
			System.out.println("6- Sair");
			n = sc.nextInt();
		
			if(n == 1) {
				ShowTables st = new  ShowTables();
				st.show();
			}
			if(n == 2) {
				ShowEspecificTable set = new ShowEspecificTable();
				set.show();
			}
			if(n == 3) {
				Insert ins = new Insert();
				ins.show();
			}
			if(n == 4) {
				Update up = new Update();
				up.show();
			}
			if(n == 5) {
				Delete del = new Delete();
				del.show();
			}
			if(n > 6 || n < 1) {
				System.out.println("Essa opção não exite! Tente novamente");
			}
		}while(n != 6);
		
		sc.close();
	}

}
