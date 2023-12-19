package Estoque;


import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("### Sistema de Gerenciamento de Produtos ###");
            System.out.println("1. Inserir Produto Perecível");
            System.out.println("2. Inserir Produto Não Perecível");
            System.out.println("3. Consultar Produtos");
            System.out.println("4. Adicionar Estoque");
            System.out.println("5. Remover Estoque");
            System.out.println("6. Sair");

            int escolha = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (escolha) {
                case 1:
                    System.out.println("### Inserir Produto Perecível ###");
                    System.out.print("Nome: ");
                    String nomePerecivel = scanner.nextLine();
                    System.out.print("Preço R$: ");
                    double precoPerecivel = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Quantidade em Estoque: ");
                    int quantidadePerecivel = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Data de Vencimento: ");
                    String dataVencimento = scanner.nextLine();

                    ProdutoPerecivel pp = new ProdutoPerecivel(nomePerecivel, precoPerecivel, quantidadePerecivel, dataVencimento, null);

                    if (pp.cadastrarProduto(pp)) {
                        System.out.println("Produto Perecível inserido com sucesso");
                    } else {
                        System.out.println("Faça o L imediatamente");
                    }
                    break;

                case 2:
                    System.out.println("### Inserir Produto Não Perecível ###");
                    System.out.print("Nome: ");
                    String nomeNaoPerecivel = scanner.nextLine();
                    System.out.print("Preço R$: ");
                    double precoNaoPerecivel = scanner.nextDouble();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Quantidade em Estoque: ");
                    int quantidadeNaoPerecivel = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha
                    System.out.print("Material: ");
                    String material = scanner.nextLine();

                    ProdutoNaoPerecivel pnp = new ProdutoNaoPerecivel(nomeNaoPerecivel, precoNaoPerecivel, quantidadeNaoPerecivel, material);
                    System.out.println(pnp.getMaterial());
                    if (pnp.cadastrarProduto(pnp)) {
                        System.out.println("Produto Não Perecível inserido com sucesso");
                    } else {
                        System.out.println("Faça o L imediatamente");
                    }
                    break;

                case 3:
                    System.out.println("### Consultar Produtos ###");
                    ArrayList<Produto> listaProdutos = Produto.lerTodos();
                    for (Produto produto : listaProdutos) {
                        System.out.println(produto);
                    }
                    System.out.println();
                    break;

                case 4:
                    System.out.println("### Adicionar Estoque ###");
                    System.out.println("Digite o código do produto: ");
                    int codigoProduto = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Digite a quantidade a ser adicionada ao estoque: ");
                    int quantidadeAdicionar = scanner.nextInt();
                    if (quantidadeAdicionar > 0) {
                        Produto produto = new Produto();
                        if(produto.adicionarEstoque(quantidadeAdicionar, codigoProduto))
                        {
                            System.out.println("Quantidade alterada com sucesso!");
                        }
                        else{
                            System.out.println("Não foi possível alterar o produto! :(");
                        }
                    }

                    break;
                case 5:
                    System.out.println("### Remover Estoque ###");
                    System.out.println("Digite o código do produto: ");
                    int codigoProdutoRemover = scanner.nextInt();
                    Produto produto = new Produto();
                    if(produto.deletarEstoque(codigoProdutoRemover))
                    {
                        System.out.println("Item deletado com sucesso!");
                    }
                    else{
                        System.out.println("Não foi possível deletar o produto! :(");
                    }

                    break;

                case 6:
                    System.out.println("Sistema encerrado. ");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        }
    }
}
