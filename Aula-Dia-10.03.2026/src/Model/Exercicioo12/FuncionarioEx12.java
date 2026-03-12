package Model.Exercicioo12;

public class FuncionarioEx12 {
    private String nome;
    private double salario;
    private String departamento;

    public FuncionarioEx12(String nome, double salario, String departamento) {
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    // Getters para acessar os dados
    public String getNome() { return nome; }
    public double getSalario() { return salario; }
    public String getDepartamento() { return departamento; }
}
