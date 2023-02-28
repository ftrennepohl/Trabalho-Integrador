package br.edu.projeto.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Processo")
public class Processo {

	@Id
	private int cod;
	@NotNull
	private String tipo;
	private String status;
	private String orcmnt;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<Legislacao> legislacoes = new HashSet<>();
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<Cliente> clientes = new HashSet<>();
	
	public Integer getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getOrcmnt() {
		return orcmnt;
	}
	public void setOrcmnt(String orcmnt) {
		this.orcmnt = orcmnt;
	}
}
