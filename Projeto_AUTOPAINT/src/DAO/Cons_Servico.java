package DAO;
// Construtor da Classe Serviço
public class Cons_Servico {

    String cliente, descricao, modeloCarro, tempoEstimado, placa;
    Double valor;


    public Cons_Servico(String cliente, String descricao, String modeloCarro, String tempoEstimado, String placa, Double valor) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.modeloCarro = modeloCarro;
        this.placa = placa;
        this.tempoEstimado = tempoEstimado;
        this.valor = valor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModeloCarro() {
        return modeloCarro;
    }

    public void setModeloCarro(String modeloCarro) {
        this.modeloCarro = modeloCarro;
    }

    public String getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(String tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
