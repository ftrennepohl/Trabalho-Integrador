package br.edu.projeto.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

import br.edu.projeto.dao.ClienteDAO;
import br.edu.projeto.model.Cliente;

@ViewScoped
@Named
public class CadastroClienteController implements Serializable{

	@Inject
	private FacesContext facesContext;
	
	@Inject
	private ClienteDAO clientedao;
	
	private Cliente cliente;
	
	private List<Cliente> listaClientes;
	
	public void novoCliente() {
        this.setCliente(new Cliente());
    }
	
	public void salvar() {
		novoCliente();
		System.out.println(this.cliente.getCpf());
    	try {
    		if (this.cliente.getCpf() == null) {
	        	this.clientedao.salvar(this.cliente);
	        	this.facesContext.addMessage(null, new FacesMessage("Usuário Criado"));
	        } else {
	        	this.clientedao.atualizar(this.cliente);
	        	this.facesContext.addMessage(null, new FacesMessage("Usuário Atualizado"));
	        }
    		//Após salvar usuário é necessário recarregar lista que popula tabela com os novos dados
	        this.listaClientes = clientedao.listarTodos();
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
}
