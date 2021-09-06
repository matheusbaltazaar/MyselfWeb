package br.com.myself.web.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Registro implements Serializable {
	
	private static final long serialVersionUID = -4580394392782324101L;
	
	private String descricao;
	private LocalDate data;
	private double valor;

	public Registro() {
		this.data = LocalDate.of(2019, 1, 1);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Registro [descricao=" + descricao + ", data=" + data + ", valor=" + valor + "]";
	}
	
	

}
