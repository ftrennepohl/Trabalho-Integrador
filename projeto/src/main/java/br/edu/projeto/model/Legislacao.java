package br.edu.projeto.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Legislacao")
public class Legislacao {

	@Id
	private int cod;
	@NotNull
	private String texto;
	@ManyToMany(mappedBy = "legislacoes", fetch = FetchType.EAGER)
	private Set<Processo> processos = new HashSet<Processo>();
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
