package Estoque;

public class ProdutoPerecivel extends Produto {
    private String dataVencimento;

    public ProdutoPerecivel(String nome, double preco, int quantidadeEmEstoque, String dataVencimento, Object o) {
        super(nome, preco, quantidadeEmEstoque);
        this.dataVencimento = dataVencimento;
    }
    public ProdutoPerecivel(int codigo, String nome, double preco, int quantidadeEmEstoque, String dataVencimento, Object o) {
        super(codigo, nome, preco, quantidadeEmEstoque);
        this.dataVencimento = dataVencimento;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }


    @Override
    public String toString() {
        return super.toString() + ", Data de Vencimento: " + dataVencimento;
    }
}
