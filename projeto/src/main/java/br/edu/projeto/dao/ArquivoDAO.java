package br.edu.projeto.dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Arquivo;
import br.edu.projeto.model.Cliente;

@Stateful
public class ArquivoDAO implements Serializable {

	@Inject
    private EntityManager em;
	
	public Arquivo encontrarArquivo(int cod) {
        return em.find(Arquivo.class, cod);
    }
	
	public List<Arquivo> listarTodos() {
	    return em.createQuery("SELECT a FROM \"Arquivo\" a ", Arquivo.class).getResultList();      
	}
	
	public void salvar(Arquivo a) {
		em.persist(a);
	}
	
	public void atualizar(Arquivo a) {
		em.merge(a);
	}
	
	public void excluir(Arquivo a) {
		em.remove(em.getReference(Cliente.class, a.getCod()));
	}
}
