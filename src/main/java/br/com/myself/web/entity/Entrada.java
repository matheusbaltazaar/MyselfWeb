package br.com.myself.web.entity;

import java.io.Serializable;
import java.util.Objects;

public class Entrada implements Serializable {

	private static final long serialVersionUID = 6936893424014647386L;

	private int id;
	private String descricao;
	private Long data;
	private double valor;

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
		if (descricao != null)
			this.descricao = descricao.trim();
	}

	public Long getData() {
		return data;
	}

	public void setData(Long data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, descricao, id, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entrada other = (Entrada) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", descricao=" + descricao + ", data=" + data + ", valor=" + valor + "]";
	}
	
}
