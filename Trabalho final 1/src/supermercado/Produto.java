package supermercado;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Produto {
	protected String marca;
	protected String nome;
	protected int quantidadeEmStock;
	protected int numCompras;
	protected int quantidadeVenda;
	protected int quantidadeEncomenda;
	protected int medida;
	protected String unidade;
	protected String id;
	protected String categoria;
	protected double preco;

	static Scanner sc = new Scanner(System.in);
	static Date dt = new Date();
	static ArrayList<Produto> encontrados = new ArrayList<>();

	public Produto(String marca, String nome, int quantidadeEmStock, int medida, String unidade, String categoria,
			double preco) {
		this.marca = marca;
		this.nome = nome;
		this.quantidadeEmStock = quantidadeEmStock;
		this.quantidadeVenda = 0;
		this.quantidadeEncomenda = 0;
		this.numCompras = 0;
		this.medida = medida;
		this.unidade = unidade;
		this.preco = preco;
		this.categoria = categoria;
		int ultimoId = DadosProduto.obterUltimoId();
		id = String.format("%04d", ultimoId + 1);
		DadosProduto.atualizarUltimoId(ultimoId + 1);
	}

	public Produto(String marca, String nome, int quantidadeEmStock, int numCompras, int medida, String unidade,
			String id, String categoria, double preco) {
		this.marca = marca;
		this.nome = nome;
		this.quantidadeEmStock = quantidadeEmStock;
		this.quantidadeVenda = 0;
		this.quantidadeEncomenda = 0;
		this.numCompras = numCompras;
		this.medida = medida;
		this.unidade = unidade;
		this.preco = preco;
		this.categoria = categoria;
		this.id = id;
	}

	public Produto() {
	}

	@Override
	public String toString() {
		return "[ marca= " + marca + " , nome= " + nome + " , quantidadeEmStock= " + quantidadeEmStock
				+ " , numCompras= " + numCompras + " , medida= " + medida + " , unidade= " + unidade + " , id= " + id
				+ " , categoria= " + categoria + " , preco= " + preco + " ]";
	}

	public String produzirRecibo() {
		return quantidadeVenda + "x " + marca + " " + nome + " " + medida + unidade + " a " + preco + "MZN" + " "
				+ "total:" + (preco * quantidadeVenda);
	}

	public String mostrarInfoProduto() {
		return marca + " " + nome + " " + medida + unidade + " " + preco + "MZN";
	}

	public String mostrarRelatorioProduto() {
		return marca + " " + nome + " " + medida + unidade + " " + preco + "MZN" + " " + quantidadeEmStock
				+ " unidades em stock";
	}

	public static void criarProduto(){
		DadosProduto.carregarArray();
		
		System.out.println("Insira a marca do produto: ");
		String marca=sc.nextLine();
		
		System.out.println("Insira o nome do produto: ");
		String nome=sc.nextLine();
		
		System.out.println("Insira a unidade de medida (g/L/...): ");
		String unidade=sc.nextLine();

		System.out.println("Insira a medida produto: "); 
		int medida=sc.nextInt();
		
		System.out.println("Insira o preco do produto: ");
		double preco=sc.nextDouble();

		System.out.println("Insira a quantidade do produto em stock: ");
		int quantidade=sc.nextInt();
		
		System.out.println("Insira o categoria do produto");
		System.out.println("1.  Lacticinios & ovos");
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
		int categoria=sc.nextInt(); 
		if(categoria>0 && categoria<13) {
			Produto produto = new Produto();
			switch (categoria) {
				case 1:
					produto = new Produto(marca, nome,quantidade, medida, unidade, "Lacticinios & Ovos", preco);
					break;
					
				case 2:
					produto = new Produto(marca, nome,quantidade, medida, unidade, "Legumes & Frutas", preco);
					break;
					
				case 3:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Talho", preco);
					break;
					
				case 4:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Padaria & Pastelaria", preco);
					break;
					
				case 5:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Mercearia", preco);
					break;

				case 6:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Bebidas", preco);
					break;
				
				case 7:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Álcool", preco);
					break;

				case 8:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Higiene & Beleza", preco);
					break;
		
				case 9:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Limpeza", preco);
					break;
		
				case 10:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Casa", preco);
					break;
		
				case 11:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Animais", preco);
					break;
				
				case 12:
					produto = new Produto(marca,nome,quantidade, medida, unidade, "Papelaria", preco);
					break;
			}
			System.out.println("Produto criado com sucesso.");
			DadosProduto.produtos.add(produto);
			DadosProduto.atualizarBaseDados();
		}
		else {
			System.out.println("Entrada Invalida");
		}
	}

	
	public static void atualizarProduto(){
		DadosProduto.carregarArray();
		int index=procurarProduto();
				
		if(index>=0) {
			DadosProduto.alterarAtributo(index);
			DadosProduto.atualizarBaseDados();
		}
	}
	
	public static void removerProduto() {
		DadosProduto.carregarArray();
		int index=procurarProduto();

		
		if(index>=0) {
			DadosProduto.produtos.remove(index);
			System.out.println("Produto removido com sucesso");
			DadosProduto.atualizarBaseDados();
		}
	  
	}
	
	public static void procurarInfoProduto() {
		DadosProduto.carregarArray();
		int index =-1; 
		ArrayList<Produto> encontrados = new ArrayList<>();

		System.out.println("Que produto deseja procurar: "); 	
		String marca_nome = sc.nextLine();
		
		for(Produto i:DadosProduto.produtos) {
			if(i.marca.equalsIgnoreCase(marca_nome) || i.nome.equalsIgnoreCase(marca_nome)) {
				encontrados.add(i);
			}
		}
		if(encontrados.size()>0) {
			System.out.println("Produtos encontrados:");
			for(int i=1; i<=encontrados.size(); i++) {
				System.out.println(i+". "+encontrados.get(i-1).toString());
			}
			
			System.out.println("Escolha o produto: ");
			int escolha = sc.nextInt();
			Produto produtoEscolhido = encontrados.get(escolha-1);
			index= DadosProduto.produtos.indexOf(produtoEscolhido);
		}
		else {
			System.out.println("Nenhum produto foi encontrado.");
		}
		
		System.out.println(DadosProduto.produtos.get(index).toString());
	
	  
	}

	public static int procurarProduto() {
		encontrados.clear();
		int index =-1; 
		System.out.println("Que produto deseja procurar: "); 	
		String marca_nome = sc.nextLine();
		
		for(Produto i:DadosProduto.produtos) {
			if(i.marca.equalsIgnoreCase(marca_nome) || i.nome.equalsIgnoreCase(marca_nome)) {
				encontrados.add(i);
			}
		}
		if(encontrados.size()>0) {
			System.out.println("Produtos encontrados:");
			for(int i=1; i<=encontrados.size(); i++) {
				System.out.println(i+". "+encontrados.get(i-1).toString());
			}
			
			System.out.println("Escolha o produto: ");
			int escolha = sc.nextInt();
			Produto produtoEscolhido = encontrados.get(escolha-1);
			index= DadosProduto.produtos.indexOf(produtoEscolhido);
		}
		else {
			System.out.println("Nenhum produto foi encontrado.");
		}
		
		return index;
	}

	

}
