package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Legislacao;

@Stateful
public class LegislacaoDAO implements Serializable{

	@Inject
	private EntityManager em;
	
	public Legislacao encontrarLegislacao(String cpf){
		return em.find(Legislacao.class, cpf);
	}
	
	public List<Legislacao> listarTodos() {
	    return em.createQuery("SELECT l FROM \"Legislacao\" l ", Legislacao.class).getResultList();      
	}
	
	public void salvar(Legislacao l) {
		em.persist(l);
	}
	
	public void atualizar(Legislacao l) {
		em.merge(l);
	}
	
	public void excluir(Legislacao l) {
		em.remove(em.getReference(Legislacao.class, l.getCod()));
	}
}