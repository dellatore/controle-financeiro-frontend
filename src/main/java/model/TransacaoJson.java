package model;

public class TransacaoJson {
	    public transient int id; // Não será enviado no JSON
	    public String descricao;
	    public double valor;
	    public String tipo;
	    public String categoria;
	    public String data;
	


    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
	@Override
	public String toString() {
		return "Transacao [id=" + id + ", descricao=" + descricao + ", valor=" + valor + ", tipo=" + tipo
				+ ", categoria=" + categoria + ", data=" + data + "]";
	}
    
}
