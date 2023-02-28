package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Processo;

@Stateful
public class ProcessoDAO implements Serializable{

	@Inject
	private EntityManager em;
	
	public Processo encontrarProcesso(String cpf){
		return em.find(Processo.class, cpf);
	}
	
	public List<Processo> listarTodos() {
	    return em.createQuery("SELECT p FROM \"Processo\" p ", Processo.class).getResultList();      
	}
	
	public void salvar(Processo p) {
		em.persist(p);
	}
	
	public void atualizar(Processo p) {
		em.merge(p);
	}
	
	public void excluir(Processo p) {
		em.remove(em.getReference(Processo.class, p.getCod()));
	}
}