package model;

public class Pedido {
    private int idPedido;
    private String nomeCliente;
    private String enderecoEntrega;
    private double valor;
    private String descricao;

    public Pedido() {}
    
    //construtor
    public Pedido(int idPedido, String nomeCliente, String enderecoEntrega, double valor, String descricao) {
        this.idPedido = idPedido;
        this.nomeCliente = nomeCliente;
        this.enderecoEntrega = enderecoEntrega;
        this.valor = valor;
        this.descricao = descricao;
    }

    // getters e Setters
    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
