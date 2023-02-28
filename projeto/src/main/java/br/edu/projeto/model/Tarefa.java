package br.edu.projeto.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Tarefa")
public class Tarefa {
	
	@Id
	private int cod;
	@NotNull
	private String desc;
	private Date dtin;
	private Date dtenc;
	@ManyToMany(mappedBy = "tarefas", fetch = FetchType.EAGER)
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Date getDtin() {
		return dtin;
	}
	public void setDtin(Date dtin) {
		this.dtin = dtin;
	}
	public Date getDtenc() {
		return dtenc;
	}
	public void setDtenc(Date dtenc) {
		this.dtenc = dtenc;
	}
	
}
