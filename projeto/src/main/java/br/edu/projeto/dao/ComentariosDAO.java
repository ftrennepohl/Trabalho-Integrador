package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Comentarios;

@Stateful
public class ComentariosDAO implements Serializable{

	@Inject
	private EntityManager em;
	
	public Comentarios encontrarComentarios(String cpf){
		return em.find(Comentarios.class, cpf);
	}
	
	public List<Comentarios> listarTodos() {
	    return em.createQuery("SELECT c FROM \"Comentarios\" c ", Comentarios.class).getResultList();      
	}
	
	public void salvar(Comentarios c) {
		em.persist(c);
	}
	
	public void atualizar(Comentarios c) {
		em.merge(c);
	}
	
	public void excluir(Comentarios c) {
		em.remove(em.getReference(Comentarios.class, c.getTexto()));
	}
}