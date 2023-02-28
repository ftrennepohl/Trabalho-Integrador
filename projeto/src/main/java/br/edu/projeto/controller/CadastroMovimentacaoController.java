package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import br.edu.projeto.dao.MovimentacaoDAO;
import br.edu.projeto.model.Movimentacao;


@ViewScoped
@Named
public class CadastroMovimentacaoController implements Serializable {

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private MovimentacaoDAO movimentacaodao;
	
	private Movimentacao movimentacao;
	
	private List<Movimentacao> listaMovimentacao;
	
	public void novaMovimentacao() {
        this.setMovimentacao(new Movimentacao());
    }
	
	public void salvar() {
    	try {
    		if (this.movimentacao.getTransac() == null) {
	        	this.movimentacaodao.salvar(this.movimentacao);
	        	this.facesContext.addMessage(null, new FacesMessage("Usuário Criado"));
	        } else {
	        	this.movimentacaodao.atualizar(this.movimentacao);
	        	this.facesContext.addMessage(null, new FacesMessage("Usuário Atualizado"));
	        }
    		//Após salvar usuário é necessário recarregar lista que popula tabela com os novos dados
	        this.listaMovimentacao = movimentacaodao.listarTodos();
        } catch (Exception e) {
            String errorMessage = getMensagemErro(e);
            this.facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, errorMessage, null));
        }
    }
	
	private String getMensagemErro(Exception e) {
	    String erro = "Falha no sistema!. Contacte o administrador do sistema.";
	    if (e == null) 
	        return erro;
	    Throwable t = e;
	    while (t != null) {
	        erro = t.getLocalizedMessage();
	        t = t.getCause();
	    }
	    return erro;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public List<Movimentacao> getListaMovimentacao() {
		return listaMovimentacao;
	}

	public void setListaMovimentacao(List<Movimentacao> listaMovimentacao) {
		this.listaMovimentacao = listaMovimentacao;
	}
}
