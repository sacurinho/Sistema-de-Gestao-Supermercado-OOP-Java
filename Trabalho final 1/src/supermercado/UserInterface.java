package supermercado;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stock.notificarEEncomendarProdutosAbaixoCincoUnidades();
		System.out.println("MENU:");
		System.out.println("1. Cliente");
		System.out.println("2. Produto");
		System.out.println("3. Registar Compra");
		System.out.println("4. Inventario");
		int opcao = sc.nextInt();
		switch (opcao) {
		case 1:
			System.out.println("a. Criar Cliente");
			System.out.println("b. Atualizar Cliente");
			System.out.println("c. Remover Cliente");
			System.out.println("d. Ver Compras");
			String subopcao = sc.next();
			switch (subopcao) {
			case "a":
				Cliente.criarCliente();
				break;
			case "b":
				Cliente.atualizarCliente();
				break;
			case "c":
				Cliente.removerCliente();
				break;
			case "d":
				DadosCliente.mostrarComprasDoCliente();
				break;
			default:
				System.out.println("Opcao inserida invalida");
				break;
			}
			break;

		case 2:
			System.out.println("a. Criar Produto");
			System.out.println("b. Atualizar Produto");
			System.out.println("c. Remover Produto");
			System.out.println("d. Procurar Produto");
			subopcao = sc.next();
			switch (subopcao) {
			case "a":
				Produto.criarProduto();
				break;
			case "b":
				Produto.atualizarProduto();
				break;
			case "c":
				Produto.removerProduto();
				break;
			case "d":
				Produto.procurarInfoProduto();
				break;
			default:
				System.out.println("Opcao inserida invalida");
				break;
			}
			break;


		case 3:
			Vendas.registarVendaADinheiro();
			break;

		case 4:
			System.out.println("a. Emitir Relatorio Geral");
			System.out.println("b. Produtos Mais Vendidos");
			System.out.println("c. Produtos Em Ponto De Encomenda");
			subopcao = sc.next();
			switch (subopcao) {
			case "a":
				Stock.emitirRelatorioGeral();
				break;
			case "b":
				Stock.mostrarMaisVendidos();
				break;
			case "c":
				Stock.notificarEEncomendarProdutosAbaixoCincoUnidades();
				break;
			default:
				System.out.println("Opcao inserida invalida");
				break;

			}
			break;

		default:
			System.out.println("Opcao inserida invalida");
			break;
		}
	}		
}