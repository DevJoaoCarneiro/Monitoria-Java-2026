package Model.Exercicio1;

public abstract class ItemLoja implements Vendavel{
    private int id;
    private String nome;
    private double preco;

    public ItemLoja(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
