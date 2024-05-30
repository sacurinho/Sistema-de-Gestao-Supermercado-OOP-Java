package supermercado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DadosCliente{
	static Scanner sc=new Scanner(System.in);
	static ArrayList<Cliente> clientes = new ArrayList<Cliente>();

	public static void atualizarBaseDados() {
		try {
			FileWriter filewriter = new FileWriter("src/BaseDadosCliente.txt");//reescreve tudo
			BufferedWriter escritor = new BufferedWriter(filewriter);
			for(Cliente i: clientes) {
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
		DadosCliente.clientes.clear();
		String nome="", endereco="", id="", dataCadastro="";
		int telefone=0;
		try {
			FileReader filereader = new FileReader("src/BaseDadosCliente.txt");
			BufferedReader leitor = new BufferedReader(filereader);
			String linha;
			while((linha = leitor.readLine()) != null) {
				StringTokenizer tokenizer = new StringTokenizer(linha, " ");
				while(tokenizer.hasMoreTokens()) {
					 String token = tokenizer.nextToken();
					 switch(token) {
					 	case "nome=":
					 		nome=tokenizer.nextToken();
					 		break;
					 		
					 	case "telefone=":
					 		telefone = Integer.parseInt(tokenizer.nextToken());
					 		break;
					 		
					 	case "endereco=":
					 		endereco = tokenizer.nextToken();
					 		break;
					 		
					 	case "id=":
					 		id=tokenizer.nextToken();
					 		break;
					 		
					 	case "dataCadastro=":
					 		dataCadastro = tokenizer.nextToken();
					 		break;
					 		
					 }
				 }
				 Cliente cliente=new Cliente(nome, endereco, telefone, id, dataCadastro);
				 clientes.add(cliente);
				 
			}
			leitor.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void alterarAtributo(int index){
		System.out.println("O que deseja alterar: ");
		System.out.println("1. Nome");
		System.out.println("2. Endereco");
		System.out.println("3. Telefone");
		int opcao = sc.nextInt();
		switch(opcao) {
			case 1:
				System.out.println("Insira novo nome: ");
				String novoNome=sc.next();
				clientes.get(index).nome=novoNome;
				System.out.println("Alteracao concluida");
				break;
				
			case 2:
				System.out.println("Insira novo endereco: ");
				String novoEndereco=sc.next();
				clientes.get(index).endereco=novoEndereco;
				System.out.println("Alteracao concluida");
				break;
				
			case 3:
				System.out.println("Insira novo telefone: ");
				String novoTelefone=sc.next();
				clientes.get(index).endereco=novoTelefone;
				System.out.println("Alteracao concluida");
				break;
				
			default:
				System.out.println("Entrada Invalida");
				break;
		}
	}
	public static void mostrarComprasDoCliente() {
		System.out.println("Insira o id: ");
		int id = sc.nextInt();

		FileReader filereader;
		String linha;
		try {
			filereader = new FileReader("src/Compras Dos Clientes/" + id + ".txt");
			BufferedReader leitor = new BufferedReader(filereader);

			while ((linha = leitor.readLine()) != null) {
				System.out.println(linha);
			}
			leitor.close();
		} 
		catch (IOException e) {
			System.out.println("Ainda nao efetuou nenhuma compra");
		}

	}
	
	public static int obterUltimoId(){
		int ultimoID=0;
		try {
			FileReader filereader = new FileReader("src/UltimoIDCliente.txt");
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
	
	public static void atualizarUltimoId(int numClientes) {
		try {
			FileWriter filewriter = new FileWriter("src/UltimoIDCliente.txt");
			BufferedWriter escritor = new BufferedWriter(filewriter);
			escritor.write(String.valueOf(numClientes));
			escritor.close();
		}
		catch(IOException e) {
			System.out.println("Error");
		}
	}

	public static boolean verificarExistenciaCliente(String id) {
		DadosCliente.carregarArray();
		for(Cliente i: DadosCliente.clientes) {
			if(i.id.equals(id)) {
				return true;
			}
		}
		return false;
	}
}