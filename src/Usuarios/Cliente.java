package Usuarios;

public class Cliente {
    String nome;
    String CPF;
    String codigo;
    String endereco;

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    public String getCPF(){
        return CPF;
    }
    public void setCodigo(String codigo){
        this.codigo = codigo;
    }
    public String getCodigo(){
        return codigo;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getEndereco(){
        return endereco;
    }
    public Cliente(String nome, String CPF, String codigo, String endereco){
        this.nome = nome;
        this.CPF = CPF;
        this.codigo = codigo;
        this.endereco = endereco;
    }
    @Override
    public String toString(){
        return "Nome: " + nome + ", CPF: " + CPF + ", Codigo: " + codigo + ", Endereco: " + endereco;
    }

}
