package Model.Exercicio7;

public class Produto {
    private String nomeProduto;
    private String preco;

    public Produto(String nomeProduto, String preco) {
        this.nomeProduto = nomeProduto;
        this.preco = preco;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getPreco() {
        return preco;
    }
}
