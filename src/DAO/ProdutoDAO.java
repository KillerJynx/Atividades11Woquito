package DAO;

import conexao.Conexao;
import Estoque.Produto;
import Estoque.ProdutoPerecivel;
import Estoque.ProdutoNaoPerecivel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoDAO {

    public static void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO Produto (nome, preco, quantEstoque, material, dataVencimento) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = Conexao.getConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setInt(3, produto.getQuantidadeEmEstoque());

            if (produto instanceof ProdutoPerecivel) {
                ProdutoPerecivel perecivel = (ProdutoPerecivel) produto;
                ps.setString(4, null);  // material
                ps.setString(5, perecivel.getDataVencimento());
            } else {
                ProdutoNaoPerecivel pnp = (ProdutoNaoPerecivel) produto;
                System.out.println(pnp.getMaterial());
                ps.setString(4, pnp.getMaterial());  // material
                ps.setString(5, null);  // dataVencimento
            }

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Conexao.fecharConexao();
        }
    }


    public static ArrayList<Produto> lerTodos() {
        String selectQuery = "SELECT * FROM Produto";

        ArrayList<Produto> listaProdutos = new ArrayList<>();

        try (Connection connection = Conexao.getConexao(); PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                String nome = resultSet.getString("nome");
                double preco = resultSet.getDouble("preco");
                int quantidadeEstoque = resultSet.getInt("quantEstoque");
                String material = resultSet.getString("material");
                String dataVencimento = resultSet.getString("dataVencimento");

                if (dataVencimento != null) {
                    ProdutoPerecivel produtoPerecivel = new ProdutoPerecivel(codigo, nome, preco, quantidadeEstoque, dataVencimento, null);
                    listaProdutos.add(produtoPerecivel);
                } else {
                    ProdutoNaoPerecivel produtoNaoPerecivel = new ProdutoNaoPerecivel(codigo, nome, preco, quantidadeEstoque, material);
                    listaProdutos.add(produtoNaoPerecivel);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProdutos;
    }

    public static boolean alterarQuantidadeEstoque(int codigoProduto, int novaQuantidade) {
        String sql = "UPDATE Produto SET quantEstoque = quantEstoque + ? WHERE codigo = ?";
        if (existe(codigoProduto)) {
            try (Connection connection = Conexao.getConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, novaQuantidade);
                ps.setInt(2, codigoProduto);
                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.fecharConexao();
            }
        }
        return false;
    }

    public static boolean deletarQuantidadeEstoque(int codigoProduto) {
        String sql = "DELETE FROM Produto WHERE codigo = ?";
        if (existe(codigoProduto)) {
            try (Connection connection = Conexao.getConexao(); PreparedStatement ps = connection.prepareStatement(sql)) {
                ps.setInt(1, codigoProduto);
                ps.executeUpdate();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                Conexao.fecharConexao();
            }
        }
        return false;
    }

    public static boolean existe(int codigo) {
        Connection connection = Conexao.getConexao();
        String sql = "SELECT * FROM Produto WHERE codigo = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
