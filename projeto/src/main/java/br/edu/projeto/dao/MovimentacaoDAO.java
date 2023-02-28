package br.edu.projeto.dao;

import java.io.Serializable;
import java.security.Timestamp;
import java.sql.Date;
import java.util.List;

import javax.ejb.Stateful;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Movimentacao;
import br.edu.projeto.model.Transacao;

@Stateful
public class MovimentacaoDAO implements Serializable{

	@Inject
	private EntityManager em;
	
	public Movimentacao encontrarMovimentacao(Transacao transac){
		return em.find(Movimentacao.class, transac);
	}
	
	public List<Movimentacao> listarTodos() {
	    return em.createQuery("SELECT m FROM \"Movimentacao\" m ", Movimentacao.class).getResultList();      
	}
	
	public double getSaldo(Timestamp dtinicio, Timestamp dtfim) {
		int saldo = 0;
		List<Movimentacao> movs = em.createQuery("SELECT sum(valor) FROM \"Movimentacao\" m  where dthora > " + dtinicio.toString() +  "and dthora < " + dtfim.toString(), Movimentacao.class).getResultList();
		return movs.get(0).getValor();
	}
	
	public double getEntradas(Timestamp dtinicio, Timestamp dtfim) {
		double saldoEntradas = 0;
		List<Movimentacao> movs = em.createQuery("SELECT valor FROM \"Movimentacao\" m  where dthora > " + dtinicio.toString() +  "and dthora < " + dtfim.toString(), Movimentacao.class).getResultList();
		for(Movimentacao m : movs) {
			if(m.getValor() > 0) saldoEntradas += m.getValor();
		}
		return saldoEntradas;
	}
	
	public double getSaidas(Timestamp dtinicio, Timestamp dtfim) {
		double saldoSaidas = 0;
		List<Movimentacao> movs = em.createQuery("SELECT valor FROM \"Movimentacao\" m  where dthora > " + dtinicio.toString() +  "and dthora < " + dtfim.toString(), Movimentacao.class).getResultList();
		for(Movimentacao m : movs) {
			if(m.getValor() > 0) saldoSaidas += m.getValor();
		}
		return saldoSaidas;
	}
	
	public void salvar(Movimentacao m) {
		em.persist(m);
	}
	
	public void atualizar(Movimentacao m) {
		em.merge(m);
	}
	
	public void excluir(Movimentacao m) {
		em.remove(em.getReference(Movimentacao.class, m.getTransac()));
	}
}
