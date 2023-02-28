package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Cliente;

@Stateful
public class ClienteDAO implements Serializable{

	@Inject
	private EntityManager em;
	
	public Cliente encontrarCliente(String cpf){
		return em.find(Cliente.class, cpf);
	}
	
	public List<Cliente> listarTodos() {
	    return em.createQuery("SELECT c FROM \"Cliente\" c ", Cliente.class).getResultList();      
	}
	
	public void salvar(Cliente c) {
		em.persist(c);
	}
	
	public void atualizar(Cliente c) {
		em.merge(c);
	}
	
	public void excluir(Cliente c) {
		em.remove(em.getReference(Cliente.class, c.getCpf()));
	}
}
