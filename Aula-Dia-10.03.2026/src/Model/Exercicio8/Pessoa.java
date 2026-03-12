package Model.Exercicio8;

public class Pessoa implements Descritivel{

    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public String getDescricao() {
        return nome + " (" + idade + " anos)";
    }
}
