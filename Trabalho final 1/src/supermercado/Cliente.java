package supermercado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Vector;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Cliente{
	//Rever encapsulamento
	protected String nome;
	protected String endereco;
	protected int telefone;
	protected String id;
	protected String dataCadastro;
		
		
	public Cliente(String nome, String endereco, int telefone) {
		this.nome=nome;
		this.endereco=endereco;
		this.telefone = telefone;
		int ultimoId=DadosCliente.obterUltimoId();
		id=String.format("%04d", ultimoId +1);
		DadosCliente.atualizarUltimoId(ultimoId +1);
		dataCadastro = dt.toString();
	}
	
	public Cliente(String nome, String endereco, int telefone, String id, String dataCadastro) {
		this.nome=nome;
		this.endereco=endereco;
		this.telefone = telefone;
		this.id=id;
		this.dataCadastro = dataCadastro;
	}
	
	Date dt = new Date();
	static Scanner sc = new Scanner(System.in);

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}
	
	public String getDataCadastro() {
		return dataCadastro;
	}

	@Override
	public String toString() {
		return "[ nome= " + nome + " , endereco= " + endereco + " , telefone= " + telefone + " , id= " + id
				+ " , dataCadastro= " + dataCadastro + " ]";
	}
	
	public static void criarCliente() {
		DadosCliente.carregarArray();

		System.out.println("Insira o nome: ");
		String nome = sc.nextLine();
		
		System.out.println("Insira o endereco: ");
		String endereco = sc.nextLine();
		
		System.out.println("Insira o telefone: ");
		int telefone = sc.nextInt();
		
		Cliente cliente = new Cliente(nome, endereco, telefone);
		DadosCliente.clientes.add(cliente);
		DadosCliente.atualizarBaseDados();
		File file = new File("src/Compras Dos Clientes/"+cliente.id+".txt");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Cliente criado com sucesso.");
	} 
	
	
	
	
		
	public static void atualizarCliente() {
		int index =procurarCliente();

		if(index>=0) {
			DadosCliente.alterarAtributo(index);
			DadosCliente.atualizarBaseDados();
		}
		else {
			System.out.println("Cliente nao encontrado");
		}
	 }
	
	
	
	  public static void removerCliente() {
			int index =procurarCliente();
			
			if(index>=0) {
				DadosCliente.clientes.remove(index);
				System.out.println("Cliente removido com sucesso");
				DadosCliente.atualizarBaseDados();
			}
			else {
				System.out.println("Cliente nao encontrado");
			}
	  }
	  
	  public static int procurarCliente() {
		  DadosCliente.carregarArray();
			int index =-1; 
			
			System.out.println("Insira o id: "); 	
			String id = sc.nextLine();
			
			for(Cliente i:DadosCliente.clientes) {
				if(i.id.equals(id)) {
					index = DadosCliente.clientes.indexOf(i);
				}
			}
			return index;
	  }
}