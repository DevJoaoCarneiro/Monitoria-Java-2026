package Model.Exercicio1;

public class Roupas extends ItemLoja{
    private String tipoTecido;

    public Roupas(int id, String nome, double preco, String tipoTecido) {
        super(id, nome, preco);
        this.tipoTecido = tipoTecido;
    }
}
