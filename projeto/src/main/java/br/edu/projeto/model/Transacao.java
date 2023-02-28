package br.edu.projeto.model;

import java.sql.Timestamp;
import javax.persistence.*;

@Entity
@Table(name="Transacao")
public class Transacao {

	@Id
	private Timestamp dthora;
	@ManyToOne
	@JoinColumn(name = "cpfcliente",
			foreignKey = @ForeignKey(name = "TRANSACAO_CPF_FK")
	)
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name = "codproc",
			foreignKey = @ForeignKey(name = "TRANSACAO_CODPROC_FK")
	)
	private Processo proc;
	
	public Timestamp getDthora() {
		return dthora;
	}
	public void setDthora(Timestamp dthora) {
		this.dthora = dthora;
	}
	public Processo getProc() {
		return proc;
	}
	public void setProc(Processo proc) {
		this.proc = proc;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
