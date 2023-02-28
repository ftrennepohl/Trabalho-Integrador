package br.edu.projeto.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

@Entity
@Table(name="Telefones")
public class Telefones {

	@Id
	@Length(max=20)
	private String num;
	@ManyToOne
	@JoinColumn(name = "cpfcliente",
			foreignKey = @ForeignKey(name = "TELEFONES_CPF_FK")
	)
	private Cliente cliente;
	
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}
