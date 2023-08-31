package fase1Comercio;

import java.util.ArrayList;
import java.util.Scanner;

public class Comercio {
	ArrayList<Produtos> produtos = new ArrayList<Produtos>();
	Scanner sc = new Scanner(System.in);
	
	public void listarProduto() {
		if (produtos.size() > 0) {
			System.out.println("Listando Produtos:");
			for (int i =0; i < produtos.size(); i++) {
				Produtos produto = produtos.get(i);
				System.out.println(i + 1 +")" + produto.nomeProduto + "(cód: " + produto.codigos + " | estoque: " + produto.estoque +")");
			}	
		}
		else {
			System.out.println("Não há nenhum produto cadastrado! ");
		}
	}
	private Produtos verificarProduto(int codido) {
		for (Produtos produto : produtos) {
			if (produto.codigos.equals(codido)) {
				return produto;
			}
		}
		return null;
		
	}
	
	public void cadastrarProduto() {
		System.out.print("Digite o nome do produto que deseja cadastrar: ");
		String nome = sc.nextLine();
		System.out.print("Digite o codigo do produto: ");
		int codigo = Integer.parseInt(sc.nextLine());
		for (Produtos produto : produtos) {
			if(produto.codigos.equals(codigo)) {
				while(produto.codigos.equals(codigo)) {
					System.out.print("Código já em uso. Por favor, digite outro: ");
					codigo = Integer.parseInt(sc.nextLine());
				}
			}
		}
		Produtos novoProduto = new Produtos(nome, codigo);
		produtos.add(novoProduto);
		System.out.print("deseja adicionar estoque para este produto? (S/N): ");
		String resposta = sc.nextLine();
		if (resposta.equalsIgnoreCase("S")) {
			System.out.print("Digite a quantidade que deseja adicionar: ");
			int qunatidade = Integer.parseInt(sc.nextLine());
			novoProduto.estoque += qunatidade;
		}
		System.out.println(novoProduto.nomeProduto + " cadastrado com sucesso. Código: " + novoProduto.codigos + ". Estoque: " + novoProduto.estoque);
		
	}
	
	public void adicionaEstoque() {
		System.out.println("Digite o código do produto: ");
		int codigo = Integer.parseInt(sc.nextLine());
		Produtos produto = verificarProduto(codigo);
		if(produto != null) {
			System.out.println("Quanto será adicionado ao estoque? ");
			int quantidade = Integer.parseInt(sc.nextLine());
			produto.estoque += quantidade;
		}
		else {
			System.out.println("Produto não encontrado!");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
