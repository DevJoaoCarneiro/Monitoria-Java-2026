package Model.Exercicio1;

public class Eletronico extends ItemLoja{
    private double peso;

    public Eletronico(int id, String nome, double preco, double peso) {
        super(id, nome, preco);
        this.peso = peso;
    }
}
