package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Leglinks;

@Stateful
public class LeglinksDAO implements Serializable{

	@Inject
	private EntityManager em;
	
	public Leglinks encontrarLeglink(String link){
		return em.find(Leglinks.class, link);
	}
	
	public List<Leglinks> listarTodos() {
	    return em.createQuery("SELECT l FROM \"Leglinks\" l ", Leglinks.class).getResultList();      
	}
	
	public void salvar(Leglinks l) {
		em.persist(l);
	}
	
	public void atualizar(Leglinks l) {
		em.merge(l);
	}
	
	public void excluir(Leglinks l) {
		em.remove(em.getReference(Leglinks.class, l.getLink()));
	}
}
