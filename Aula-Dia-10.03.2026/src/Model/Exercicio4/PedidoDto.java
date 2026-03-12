package Model.Exercicio4;

public class PedidoDto {
    private int id;
    private double valorTotal;

    public PedidoDto(int id, double valorTotal) {
        this.id = id;
        this.valorTotal = valorTotal;
    }

    public int getId() {
        return id;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    @Override
    public String toString() {
        return "PedidoDto{id=" + id + ", valorTotal=" + valorTotal + "}";
    }
}
