package it.coderunner.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PERSON")
public class Person {

	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int personId;
	@Column(name="Imie")
	private String name;

	private String country;

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int id) {
		this.personId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "id=" + personId + ", name=" + name + ", country=" + country;
	}
	
	@OneToMany(mappedBy="person")
    private Set<Invoice> invoises;

	public Set<Invoice> getInvoises() {
		return invoises;
	}

	public void setInvoises(Set<Invoice> invoises) {
		this.invoises = invoises;
	}
}
