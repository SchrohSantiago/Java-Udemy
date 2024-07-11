package models;

public class Cliente extends Persona{
    private int clienteId;

    public Cliente(String apellido, String direccion, String nombre, String numeroFiscal, int clienteId) {
        super(apellido, direccion, nombre, numeroFiscal);
        this.clienteId = clienteId;
    }

    public int getClienteId() {
        return clienteId;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "clienteId=" + clienteId +
                '}';
    }
}
