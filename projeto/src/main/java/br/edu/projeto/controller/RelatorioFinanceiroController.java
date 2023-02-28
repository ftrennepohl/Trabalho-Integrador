package br.edu.projeto.controller;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import br.edu.projeto.model.Movimentacao;


@ViewScoped
@Named
public class RelatorioFinanceiroController implements Serializable {

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private EntityManager em;
	
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
}
