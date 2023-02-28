package br.edu.projeto.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name="Usuario")
@Table(name="Usuario")
public class Usuario {

	@Id
	private String login;
	@NotNull
	private String senha;
	private String nome;
	private String email;
	@NotNull
	private String nivel;
	private String telefone;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<Arquivo> arquivos = new HashSet<Arquivo>();
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Set<Tarefa> tarefas = new HashSet<Tarefa>();
//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
//	private Set<TipoPermissao> permissoes = new HashSet<TipoPermissao>();
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Set<Arquivo> getArquivos() {
		return arquivos;
	}
	public void setArquivos(Set<Arquivo> arquivos) {
		this.arquivos = arquivos;
	}
	public Set<Tarefa> getTarefas() {
		return tarefas;
	}
	public void setTarefas(Set<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}
//	public Set<TipoPermissao> getPermissoes() {
//		return permissoes;
//	}
//	public void setPermissoes(Set<TipoPermissao> permissoes) {
//		this.permissoes = permissoes;
//	}
	
}
