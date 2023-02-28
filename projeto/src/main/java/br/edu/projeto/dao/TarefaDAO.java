package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Tarefa;

@Stateful
public class TarefaDAO implements Serializable{

	@Inject
	private EntityManager em;
	
	public Tarefa encontrarTarefa(int cod){
		return em.find(Tarefa.class, cod);
	}
	
	public List<Tarefa> listarTodos() {
	    return em.createQuery("SELECT t FROM \"Tarefa\" t ", Tarefa.class).getResultList();      
	}
	
	public void salvar(Tarefa t) {
		em.persist(t);
	}
	
	public void atualizar(Tarefa t) {
		em.merge(t);
	}
	
	public void excluir(Tarefa t) {
		em.remove(em.getReference(Tarefa.class, t.getCod()));
	}
}
