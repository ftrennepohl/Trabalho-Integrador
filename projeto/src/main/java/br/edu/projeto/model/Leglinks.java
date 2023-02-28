package br.edu.projeto.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Leglinks")
public class Leglinks {

	@Id
	private String link;
	@ManyToOne
	@JoinColumn(name = "legcod",
	foreignKey = @ForeignKey(name = "LINKS_LEGCOD_FK")
)
	private Legislacao leg;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Legislacao getLeg() {
		return leg;
	}
	public void setLeg(Legislacao leg) {
		this.leg = leg;
	}
	
}
