package Estoque;

import DAO.ProdutoDAO;

import java.util.ArrayList;

public class Produto {
    int codigo;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(int codigo, String nome, double preco, int quantidadeEmEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
    public Produto(String nome, double preco, int quantidadeEmEstoque) {
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Produto(){

    }

    public static ArrayList<Produto> lerTodos() {
        ArrayList <Produto> listaProdutos = new ArrayList<>( );
        listaProdutos = ProdutoDAO.lerTodos();
        return  listaProdutos;
    }
    public boolean cadastrarProduto (Produto produto){
        if (produto.getQuantidadeEmEstoque()>=0) {
            ProdutoDAO.cadastrarProduto(produto);
            return true;
        }
        else {
            return false;
        }
    }


    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public boolean adicionarEstoque(int quantidade, int codigo) {
        if (ProdutoDAO.alterarQuantidadeEstoque(codigo, quantidade)){
            return true;
        }
        return false;
    }

    public boolean deletarEstoque( int codigo) {
        if (ProdutoDAO.deletarQuantidadeEstoque(codigo)){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Codigo: " +codigo+ ", Nome: " + nome + ", Preco R$: " + preco + ", Estoque: " + quantidadeEmEstoque;
    }
}
