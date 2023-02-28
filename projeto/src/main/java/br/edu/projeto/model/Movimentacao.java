package br.edu.projeto.model;

import java.io.Serializable;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Movimentacao")
public class Movimentacao implements Serializable{

	@Id
	@OneToOne
	@JoinColumn(name = "dthora")
	private Transacao transac;
	@NotNull
	private double valor;
	private String desc;
	

	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Transacao getTransac() {
		return transac;
	}
	public void setTransac(Transacao transac) {
		this.transac = transac;
	}
	
}
