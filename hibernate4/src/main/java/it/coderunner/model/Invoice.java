package it.coderunner.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice {
	
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nr_faktury")
	private String nrFaktury;
	private String data_faktury;
	private double wartosc_netto;
	private double podatek;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNr_faktury() {
		return nrFaktury;
	}
	public void setNr_faktury(String nr_faktury) {
		this.nrFaktury = nr_faktury;
	}
	public String getData_faktury() {
		return data_faktury;
	}
	public void setData_faktury(String data_faktury) {
		this.data_faktury = data_faktury;
	}
	public double getWartosc_netto() {
		return wartosc_netto;
	}
	public void setWartosc_netto(double wartosc_netto) {
		this.wartosc_netto = wartosc_netto;
	}
	public double getPodatek() {
		return podatek;
	}
	public void setPodatek(double podatek) {
		this.podatek = podatek;
	}
	@ManyToOne
    @JoinColumn(name="personId")
	private Person person;


	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	

}
