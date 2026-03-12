package Model.Exercicioo11;

public class PedidoEx11 {
    private int id;
    private Status status;

    public PedidoEx11(int id, Status status) {
        this.id = id;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Status getStatus() {
        return status;
    }
}
