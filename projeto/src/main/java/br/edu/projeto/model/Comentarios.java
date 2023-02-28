package br.edu.projeto.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="Comentarios")
public class Comentarios {
	
	@Id
	private String texto;
	@ManyToOne
	@JoinColumn(name = "codproc",
	foreignKey = @ForeignKey(name = "COMENTARIO_CODPROC_FK")
)
	private Processo proc;
	

	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Processo getProc() {
		return proc;
	}
	public void setProc(Processo proc) {
		this.proc = proc;
	}
}
