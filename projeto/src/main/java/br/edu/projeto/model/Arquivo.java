package br.edu.projeto.model;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Arquivo")
public class Arquivo {

	@Id
	private int cod;
	@NotNull
	private String nome;
	@NotNull
	private String local;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "codproc",
			foreignKey = @ForeignKey(name = "ARQUIVO_COD_FK")
	)
	private Processo codproc;
	@ManyToMany(mappedBy = "arquivos", fetch = FetchType.EAGER)
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	public Processo getProc() {
		return codproc;
	}
	public void setProc(Processo proc) {
		this.codproc = proc;
	}
	
}
