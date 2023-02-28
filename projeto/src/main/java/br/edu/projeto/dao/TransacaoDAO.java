package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Transacao;

@Stateful
public class TransacaoDAO implements Serializable{

	@Inject
	private EntityManager em;
	
	public Transacao encontrarTransacao(int dthora){
		return em.find(Transacao.class, dthora);
	}
	
	public List<Transacao> listarTodos() {
	    return em.createQuery("SELECT t FROM \"Transacao\" t ", Transacao.class).getResultList();      
	}
	
	public void salvar(Transacao t) {
		em.persist(t);
	}
	
	public void atualizar(Transacao t) {
		em.merge(t);
	}
	
	public void excluir(Transacao t) {
		em.remove(em.getReference(Transacao.class, t.getDthora()));
	}
}
