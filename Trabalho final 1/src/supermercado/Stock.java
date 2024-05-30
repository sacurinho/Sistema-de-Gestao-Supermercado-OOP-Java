package supermercado;

import java.io.BufferedWriter;
import java.util.Comparator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Date;

public class Stock {
	static Scanner sc = new Scanner(System.in);
	static Date dt = new Date();
	static ArrayList<Produto> encontrados = new ArrayList<>();

	public static void emitirRelatorioGeral() {
		DadosProduto.carregarArray();

		System.out.println(dt.toString());
		System.out.println();

		System.out.println("Lacticinios & Ovos");
		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Lacticinios & Ovos")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}

		System.out.println();
		System.out.println("Legumes & Frutas");
		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Legumes & Frutas")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Talho");
		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Talho")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Padaria & Pastelaria");
		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Padaria & Pastelaria")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Mercearia");
		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Mercearia")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Bebidas");

		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Bebidas")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Álcool");

		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Álcool")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Higiene & Beleza");

		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Higiene & Beleza")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Limpeza");

		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Limpeza")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Casa");

		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Casa")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Animais");

		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Animais")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}
		System.out.println();
		System.out.println("Papelaria");

		for (Produto i : DadosProduto.produtos) {
			if (i.categoria.equals("Papelaria")) {
				System.out.println(i.mostrarRelatorioProduto());
			}
		}

	}

	public static void mostrarMaisVendidos() {
		ArrayList<Produto> listaOrdenada = new ArrayList<>();
		int index;
		DadosProduto.carregarArray();

		while (DadosProduto.produtos.isEmpty() == false) {
			int indiceDoMaior = 0;
			Produto produtoMaisVendido = DadosProduto.produtos.get(indiceDoMaior);
			for (int j = 1; j < DadosProduto.produtos.size(); j++) {
				if (produtoMaisVendido.numCompras < DadosProduto.produtos.get(j).numCompras) {
					indiceDoMaior = j;
					produtoMaisVendido = DadosProduto.produtos.get(indiceDoMaior);
				}
			}

			listaOrdenada.add(produtoMaisVendido);
			DadosProduto.produtos.remove(indiceDoMaior);
		}
		for (int i = 1; i <= listaOrdenada.size(); i++) {
			if(i<=5) {
				System.out.println(i + ". " + listaOrdenada.get(i - 1).mostrarInfoProduto() + " numero  de compras:"
						+ listaOrdenada.get(i - 1).numCompras);
			}
		}
	}

	public static void mostrarProdutosSelecionados(ArrayList<Produto> produtosSelecionados) {
		if (produtosSelecionados.size() == 0) {
			System.out.println("Nenhum Produto Selecionado");
		} else {
			System.out.println("Produtos Selecionados:");
			for (int i = 1; i <= produtosSelecionados.size(); i++) {
				System.out.println(i + ". "+ produtosSelecionados.get(i - 1).mostrarRelatorioProduto() + "\n");
			}
		}

	}

	public static void mostrarProdutosAbaixoCincoUnidades(ArrayList<Produto> produtosAbaixoCincoUnidades) {
		if (produtosAbaixoCincoUnidades.size() == 0) {
			System.out.println("Nenhum Produto está em ponto de encomenda");
		} else {
			System.out.println("Produtos em ponto de encomenda:");
			for (int i = 1; i <= produtosAbaixoCincoUnidades.size(); i++) {
				System.out.println(
						i + ". " + produtosAbaixoCincoUnidades.get(i - 1).mostrarRelatorioProduto() + "\n");
			}
		}

	}

	public static void notificarEEncomendarProdutosAbaixoCincoUnidades() {
        DadosProduto.carregarArray();

        ArrayList<Produto> produtosAbaixoCincoUnidades = new ArrayList<>();
        ArrayList<Produto> produtosSelecionados = new ArrayList<>();

        for (Produto i : DadosProduto.produtos) {
            if (i.quantidadeEmStock <= 5) {
                produtosAbaixoCincoUnidades.add(i);
            }
        }
        mostrarProdutosAbaixoCincoUnidades(produtosAbaixoCincoUnidades);

        System.out.println("Deseja encomendar neste momento?(S/N)");
        String res = sc.nextLine();
        if (res.equalsIgnoreCase("S")) {
            boolean aux = false;
            while (aux==false) {
                System.out.println();
                if (produtosAbaixoCincoUnidades.size() == 0) {
                    aux = true;
                } else {
                    if (produtosSelecionados.size() == 0) {
                        System.out.println("1. Selecionar produto");
                        int resposta = sc.nextInt();
                        if (resposta == 1) {
                            mostrarProdutosAbaixoCincoUnidades(produtosAbaixoCincoUnidades);
                            System.out.println();
                            System.out.println("Selecione um produto");
                            int escolha = sc.nextInt();
                            Produto produto = produtosAbaixoCincoUnidades.get(escolha - 1);
                            int index = DadosProduto.produtos.indexOf(produto);
                            System.out.println("Quanto deseja encomendar?");
                            DadosProduto.produtos.get(index).quantidadeEmStock += sc.nextInt();
                            produtosSelecionados.add(produto);
                            produtosAbaixoCincoUnidades.remove(produto);
                            DadosProduto.atualizarBaseDados();
                            System.out.println("Encomendado com sucesso");                            
                        } else {
                            System.out.println("Entrada Invalida");
                        }

                    } else {
                        mostrarProdutosSelecionados(produtosSelecionados);
                        System.out.println();
                        System.out.println("1. Selecionar produto");
                        System.out.println("2. Descelecionar produto");
                        System.out.println("3. Encomendar");
                        int resposta = sc.nextInt();
                        switch (resposta) {
                            case 1:
                                mostrarProdutosAbaixoCincoUnidades(produtosAbaixoCincoUnidades);
                                System.out.println();
                                System.out.println("Selecione um produto");
                                int escolha = sc.nextInt();
                                Produto produto = produtosAbaixoCincoUnidades.get(escolha - 1);
                                int index = DadosProduto.produtos.indexOf(produto);
                                System.out.println("Quanto deseja encomendar?");
                                DadosProduto.produtos.get(index).quantidadeEmStock += sc.nextInt();
                                produtosSelecionados.add(produto);
                                produtosAbaixoCincoUnidades.remove(produto);
                                System.out.println();
                                break;

                            case 2:
                                mostrarProdutosSelecionados(produtosSelecionados);
                                System.out.println();
                                System.out.println("Descelecione um produto");
                                escolha = sc.nextInt();
                                produto = produtosSelecionados.get(escolha - 1);
                                index = DadosProduto.produtos.indexOf(produto);
                                System.out.println("Quanto deseja reduzir?");
                                DadosProduto.produtos.get(index).quantidadeEmStock -= sc.nextInt();
                                produtosAbaixoCincoUnidades.add(produto);
                                produtosSelecionados.remove(produto);
                                System.out.println();
                                break;

                            case 3:
                                DadosProduto.atualizarBaseDados();
                                System.out.println("Encomendado com sucesso");
                                aux = true;
                                break;
                            default:
                                System.out.println("Entrada Invalida");
                        }
                    }
                }
            }
        } else if (res.equalsIgnoreCase("N")) {
            System.out.println("Poderá ver no menu inventário.");
        } else {
            System.out.println("Entrada Invalida");
        }
    }

}