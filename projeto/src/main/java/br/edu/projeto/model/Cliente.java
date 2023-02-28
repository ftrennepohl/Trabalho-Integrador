package br.edu.projeto.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Cliente")
public class Cliente {

	private String nome;
	private Date dtnasc;
	private String ender;
	private String prof;
	@Length(max=11)
	private String rg;
	@Id
	@NotNull
	@Length(max=11)
	private String cpf;
	@ManyToMany(mappedBy = "clientes", fetch = FetchType.EAGER)
	private Set<Processo> processos = new HashSet<Processo>();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDtnasc() {
		return dtnasc;
	}
	public void setDtnasc(Date dtnasc) {
		this.dtnasc = dtnasc;
	}
	public String getEnder() {
		return ender;
	}
	public void setEnder(String ender) {
		this.ender = ender;
	}
	public String getProf() {
		return prof;
	}
	public void setProf(String prof) {
		this.prof = prof;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
}
