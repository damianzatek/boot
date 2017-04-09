package it.coderunner.spring.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Ksztaltownik implements Serializable {

	private static final long serialVersionUID = -7901094204949006825L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nazwaksztaltownika;

	@Column(nullable = false)
	private String wysokoscksztaltownika;
	
	@Column(nullable = false)
	private String szerokoscksztaltownika;
	
	@Column(nullable = false)
	private String gruboscpolki;
	
	@Column(nullable = false)
	private String gruboscsrodnika;
	
	@Column(nullable = false)
	private String promienzaokragleniaduzy;
	
	@Column(nullable = false)
	private String promienzaokragleniamaly;
	
	public Ksztaltownik(String nazwaksztaltownika, String wysokoscksztaltownika, String szerokoscksztaltownika, String gruboscpolki, String gruboscsrodnika, String promienzaokragleniaduzy, String promienzaokragleniamaly){
		this.nazwaksztaltownika = nazwaksztaltownika;
		this.wysokoscksztaltownika = wysokoscksztaltownika;
		this.szerokoscksztaltownika = szerokoscksztaltownika;
		this.gruboscpolki = gruboscpolki;
		this.gruboscsrodnika = gruboscsrodnika;
		this.promienzaokragleniaduzy = promienzaokragleniaduzy;
		this.promienzaokragleniamaly = promienzaokragleniamaly;
	}

}