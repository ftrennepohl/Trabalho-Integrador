package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Telefones;

@Stateful
public class TelefonesDAO implements Serializable{

	@Inject
	private EntityManager em;
	
	public Telefones encontrarTelefones(int num){
		return em.find(Telefones.class, num);
	}
	
	public List<Telefones> listarTodos() {
	    return em.createQuery("SELECT t FROM \"Telefones\" t ", Telefones.class).getResultList();      
	}
	
	public void salvar(Telefones t) {
		em.persist(t);
	}
	
	public void atualizar(Telefones t) {
		em.merge(t);
	}
	
	public void excluir(Telefones t) {
		em.remove(em.getReference(Telefones.class, t.getNum()));
	}
}