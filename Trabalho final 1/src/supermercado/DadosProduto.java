package supermercado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DadosProduto{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Produto> produtos = new ArrayList<>();
	
	public static void atualizarBaseDados() {
		try {
			FileWriter filewriter = new FileWriter("src/BaseDadosProduto.txt", false);
			BufferedWriter escritor = new BufferedWriter(filewriter);
			for(Produto i: produtos) {
				escritor.write(i.toString());
				escritor.newLine();
			}
			escritor.close();
		}
		catch(IOException e) {
			System.out.println("Error");
		}
	}
	
	public static void carregarArray() {
		DadosProduto.produtos.clear();
		String marca="", nome="", unidade="", id="", categoria="";
		int quantidade=0, medida=0, numCompras=0;
		double preco=0;
		
		try {
			FileReader filereader = new FileReader("src/BaseDadosProduto.txt");
			BufferedReader leitor = new BufferedReader(filereader);
			String linha;
			while((linha = leitor.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(linha, " ");
				while(tokenizer.hasMoreTokens()) {
					 String token = tokenizer.nextToken();
					 switch(token) {
					 	case "marca=":
					 		marca=tokenizer.nextToken();
					 		break;
					 		
					 	case "nome=":
					 		nome = tokenizer.nextToken();
					 		break;
					 		
					 	case "quantidadeEmStock=":
					 		quantidade = Integer.parseInt(tokenizer.nextToken());
					 		break;
					 		
					 	case "numCompras=":
					 		numCompras = Integer.parseInt(tokenizer.nextToken());
					 		break;
					 		
					 	case "medida=":
					 		medida=Integer.parseInt(tokenizer.nextToken());
					 		break;
					 		
					 	case "unidade=":
					 		unidade = tokenizer.nextToken();
					 		break;
					 		
						case "id=":
					 		id = tokenizer.nextToken();
					 		break;
					 		
						case "categoria=":
					 		categoria = tokenizer.nextToken();
					 		break;
					 		
						case "preco=":
					 		preco = Double.parseDouble(tokenizer.nextToken());
					 		break;
					 		
					 }
				 }
				 Produto produto=new Produto(marca, nome, quantidade,numCompras, medida, unidade, id, categoria, preco);
				 produtos.add(produto);
				 
			}
			leitor.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void alterarAtributo(int index){
		System.out.println("O que deseja alterar: ");
		System.out.println("1. Marca");
		System.out.println("2. Nome");
		System.out.println("3. Quantidade");
		System.out.println("4. Medida");
		System.out.println("5. Unidade");
		System.out.println("6. Categoria");
		System.out.println("7. Preço");	
		int opcao = sc.nextInt();
		switch(opcao) {
			case 1:
				System.out.println("Insira nova marca: ");
				String novaMarca=sc.next();
				produtos.get(index).marca=novaMarca;
				System.out.println("Alteracao concluida");
				break;
				
			case 2:
				System.out.println("Insira novo nome: ");
				String novoNome=sc.next();
				produtos.get(index).nome=novoNome;
				System.out.println("Alteracao concluida");
				break;
				
			case 3:
				System.out.println("Insira nova quantidade: ");
				int novaQuantidade=sc.nextInt();
				produtos.get(index).quantidadeEmStock=novaQuantidade;
				System.out.println("Alteracao concluida");
				break;
				
			case 4:
				System.out.println("Insira nova medida: ");
				int novaMedida=sc.nextInt();
				produtos.get(index).medida=novaMedida;
				System.out.println("Alteracao concluida");
				break;

			case 5:
				System.out.println("Insira nova unidade: ");
				String novaUnidade=sc.next();
				produtos.get(index).unidade=novaUnidade;
				System.out.println("Alteracao concluida");
				break;

				
			case 6:
				System.out.println("Insira nova categoria: ");
				System.out.println("1.  Lacticinios & Ovos");
				System.out.println("2.  Legumes & Frutas");
				System.out.println("3.  Talho");
				System.out.println("4.  Padaria & Pastelaria");
				System.out.println("5.  Mercearia");
				System.out.println("6.  Bebidas");
				System.out.println("7.  Álcool");
				System.out.println("8.  Higiene & Beleza");
				System.out.println("9.  Limpeza");
				System.out.println("10. Casa");
				System.out.println("11. Animais");
				System.out.println("12. Papelaria");
				int categoria = sc.nextInt(); // int Para tornar o programa mais user-friendly.

				if (categoria > 0 && categoria < 13) {
					switch (categoria) {
					case 1:
						produtos.get(index).categoria ="Lacticinios & Ovos" ;
						break;

					case 2:
						produtos.get(index).categoria ="Legumes & Frutas";
						break;

					case 3:
						produtos.get(index).categoria ="Talho" ;
						break;

						
					case 4:
						produtos.get(index).categoria ="Padaria & Pastelaria" ;
						break;

					case 5:
						produtos.get(index).categoria ="Mercearia" ;
						break;

					case 6:
						produtos.get(index).categoria ="Bebidas" ;
						break;

					case 7:
						produtos.get(index).categoria ="Álcool" ;
						break;

					case 8:
						produtos.get(index).categoria ="Higiene & Beleza" ;
						break;

					case 9:
						produtos.get(index).categoria ="Limpeza" ;
						break;

					case 10:
						produtos.get(index).categoria ="Casa" ;
						break;

					case 11:
						produtos.get(index).categoria ="Animais" ;
						break;

					case 12:
						produtos.get(index).categoria ="Papelaria" ;
						break;
					}
					System.out.println("Alteracao concluida");
					break;
				}

			case 7:
				System.out.println("Insira novo preco: ");
				double novoPreco=sc.nextDouble();
				produtos.get(index).preco=novoPreco;
				System.out.println("Alteracao concluida");
				break;

			default:
				System.out.println("Entrada Invalida");
				break;
		}
	}

	
	public static int obterUltimoId(){
		int ultimoID=0;
		try {
			FileReader filereader = new FileReader("src/UltimoIDProduto.txt");
			BufferedReader leitor = new BufferedReader(filereader);
			String linha = leitor.readLine();
			ultimoID = Integer.parseInt(linha);
			leitor.close();

		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return ultimoID;
	}
	
	public static void atualizarUltimoId(int numProdutos) {
		try {
			FileWriter filewriter = new FileWriter("src/UltimoIDProduto.txt", false);
			BufferedWriter escritor = new BufferedWriter(filewriter);
			escritor.write(String.valueOf(numProdutos));
			escritor.close();
		}
		catch(IOException e) {
			System.out.println("Error");
		}		
	}
}