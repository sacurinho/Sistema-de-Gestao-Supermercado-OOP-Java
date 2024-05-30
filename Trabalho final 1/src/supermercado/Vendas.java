package supermercado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

public class Vendas {
	static Scanner sc = new Scanner(System.in);
	static Date dt = new Date();
	static ArrayList<Produto> encontrados = new ArrayList<>();

	public static void adicionarAoCarrinho(ArrayList<Produto> carrinho) {

		int index = Produto.procurarProduto();
		if (index >= 0) {
			DadosProduto.produtos.get(index);
			System.out.println("Quantidade desejada: ");
			DadosProduto.produtos.get(index).quantidadeVenda = sc.nextInt();

			if (DadosProduto.produtos.get(index).quantidadeEmStock >= DadosProduto.produtos
					.get(index).quantidadeVenda) {
				carrinho.add(DadosProduto.produtos.get(index));

			} else {
				System.out.println("\n" + "Quantidade insuficiente em stock");
				System.out.println(DadosProduto.produtos.get(index).quantidadeEmStock + " disponiveis" + "\n");
			}
		}
	}

	public static void removerDoCarrinho(ArrayList<Produto> carrinho) {
		if (carrinho.size() > 0) {
			System.out.println("Que produto deseja remover.");
			int escolha = sc.nextInt();
			carrinho.remove(escolha - 1);
		} else {
			System.out.println("O carrinho esta vazio");
		}
	}

	public static void registarVendaADinheiro() {
		DadosProduto.carregarArray();

		ArrayList<Produto> carrinho = new ArrayList<>();
		System.out.println("Insira o id:");
		String id = sc.nextLine();
		if (DadosCliente.verificarExistenciaCliente(id) == true) {
			boolean aux = false;
			while (aux == false) {
				System.out.println();
				mostrarCarrinhoAtual(carrinho);
				System.out.println();

				if (carrinho.size() == 0) {
					System.out.println("1. Adicionar produto ao carrinho");
					int resposta = sc.nextInt();
					if (resposta == 1) {
						adicionarAoCarrinho(carrinho);
						continue;
					} else {
						System.out.println("Entrada Invalida");
					}
				} else if (carrinho.size() > 0) {
					System.out.println("1. Adicionar produto ao carrinho.");
					System.out.println("2. Remover produto do carrinho.");
					System.out.println("3. Efetuar Compra.");
					int resposta = sc.nextInt();
					switch (resposta) {
					case 1:
						adicionarAoCarrinho(carrinho);
						continue;

					case 2:
						mostrarCarrinhoAtual(carrinho);
						removerDoCarrinho(carrinho);
						continue;

					case 3:
						if (carrinho.size() > 0) {
							efetuarVenda(carrinho, id);
							aux = true;
						} else {
							System.out.println("Carrinho está vazio.");
						}
						continue;

					default:
						System.out.println("Entrada Invalida");
						break;

					}
				}

			}
		}

		else {
			System.out.println("Cliente nao encontrado. ");
		}
	}

	public static void efetuarVenda(ArrayList<Produto> carrinho, String id) {
		double total = 0;
		try {
			FileWriter filewriter = new FileWriter("src/Compras Dos Clientes/" + id + ".txt", true);
			BufferedWriter escritor = new BufferedWriter(filewriter);
			System.out.println(dt.toString());
			escritor.write(dt.toString());
			escritor.newLine();
			for (Produto i : carrinho) {
				int index = DadosProduto.produtos.indexOf(i);
				DadosProduto.produtos.get(index).numCompras += i.quantidadeVenda;
				DadosProduto.produtos.get(index).quantidadeEmStock -= DadosProduto.produtos.get(index).quantidadeVenda;
				DadosProduto.atualizarBaseDados();
				DadosProduto.atualizarBaseDados();
				System.out.println(i.produzirRecibo());
				escritor.write(i.produzirRecibo() + "\n");
				total += (i.preco * i.quantidadeVenda) + (i.preco + i.quantidadeVenda) * 0.16;

			}
			System.out.println("IVA: 16%");
			String totalFormatado = String.format("%.2f", total);
			System.out.println("Total : " + totalFormatado);
			escritor.write("IVA: 16%");
			escritor.write("Total : " + totalFormatado + "\n");
			escritor.newLine();
			escritor.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void mostrarCarrinhoAtual(ArrayList<Produto> carrinho) {
		if (carrinho.size() == 0) {
			System.out.println("Carrinho atualmente vazio");
		} else {
			System.out.println("Carrinho Atual:");
			for (int i = 1; i <= carrinho.size(); i++) {
				System.out.println(i + ". " + carrinho.get(i - 1).mostrarInfoProduto());
			}
		}
	}
}