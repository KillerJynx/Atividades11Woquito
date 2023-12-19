package Estoque;

public class ProdutoNaoPerecivel extends Produto {
    private String material;

    public ProdutoNaoPerecivel(String nome, double preco, int quantidadeEmEstoque, String material) {
        super(nome, preco, quantidadeEmEstoque);
        this.material = material;
    }
    public ProdutoNaoPerecivel(int codigo, String nome, double preco, int quantidadeEmEstoque, String material) {
        super(codigo, nome, preco, quantidadeEmEstoque);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String toString() {
        return super.toString() + ", Material: " + material;
    }
}
