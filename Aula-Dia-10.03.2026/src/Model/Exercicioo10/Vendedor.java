package Model.Exercicioo10;

public class Vendedor {
    private String nome;
    private double totalVendas;

    public Vendedor(String nome, double totalVendas) {
        this.nome = nome;
        this.totalVendas = totalVendas;
    }

    public String getNome() {
        return nome;
    }

    public double getTotalVendas() {
        return totalVendas;
    }
}
