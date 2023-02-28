package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import br.edu.projeto.dao.ProcessoDAO;
import br.edu.projeto.model.Processo;

@ViewScoped
@Named
public class CadastroProcessoController implements Serializable {

	@Inject
	private FacesContext facesContext;

	@Inject
	private ProcessoDAO processodao;
	
	private Processo processo;
	
	private List<Processo> listaProcessos;
	
	public void novoProcesso() {
        this.setProcesso(new Processo());
    }
	
	public void salvar() {
    	try {
    		if (this.processo.getCod() == null) {
	        	this.processodao.salvar(this.processo);
	        	this.facesContext.addMessage(null, new FacesMessage("Usuário Criado"));
	        } else {
	        	this.processodao.atualizar(this.processo);
	        	this.facesContext.addMessage(null, new FacesMessage("Usuário Atualizado"));
	        }
    		//Após salvar usuário é necessário recarregar lista que popula tabela com os novos dados
	        this.listaProcessos = processodao.listarTodos();
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

	public Processo getProcesso() {
		return processo;
	}

	public void setProcesso(Processo processo) {
		this.processo = processo;
	}

	public List<Processo> getListaProcessos() {
		return listaProcessos;
	}

	public void setListaProcessos(List<Processo> listaProcessos) {
		this.listaProcessos = listaProcessos;
	}
}
