package br.com.myself.web.entity;

import java.io.Serializable;
import java.util.Objects;

public class Registro implements Serializable {

	private static final long serialVersionUID = -4580394392782324101L;
	
	private int id;
	private String descricao;
	private Long data;
	private double valor;
	private String outros;
	private int referenciaDespesa;

	public Registro() {
		this.referenciaDespesa = 0;
	}

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

	public String getOutros() {
		return outros;
	}

	public void setOutros(String outros) {
		this.outros = outros;
		if (outros != null)
			this.outros = outros.trim();
	}

	public int getReferenciaDespesa() {
		return referenciaDespesa;
	}

	public void setReferenciaDespesa(int referenciaDespesa) {
		this.referenciaDespesa = referenciaDespesa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, descricao, id, outros, referenciaDespesa, valor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Registro [id=" + id + ", descricao=" + descricao + ", data=" + data + ", valor=" + valor + ", outros="
				+ outros + ", referenciaDespesa=" + referenciaDespesa + "]";
	}	
	
}
