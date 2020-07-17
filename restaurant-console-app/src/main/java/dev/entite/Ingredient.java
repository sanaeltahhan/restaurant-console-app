package dev.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO Mapping JPA
@Entity
@Table(name="ingredient")
public class Ingredient {
//TODO Mapping JPA
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nom;
	/** Getter
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}