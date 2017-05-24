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
	private String nazwaKsztaltownika;

	@Column(nullable = false)
	private String wysokosc;
	
	@Column(nullable = false)
	private String szerokoscKsztaltownika;
	
	@Column(nullable = false)
	private String gruboscPolki;
	
	@Column(nullable = false)
	private String gruboscSrodnika;
	
	@Column(nullable = false)
	private String promienZaokragleniaDuzy;
	
	@Column(nullable = false)
	private String promienZaokragleniaMaly;
	
	public Ksztaltownik(String nazwaKsztaltownika, String wysokosc, String szerokoscKsztaltownika, String gruboscPolki, String gruboscSrodnika, String promienZaokragleniaDuzy, String promienZaokragleniaMaly){
		this.nazwaKsztaltownika = nazwaKsztaltownika;
		this.wysokosc = wysokosc;
		this.szerokoscKsztaltownika = szerokoscKsztaltownika;
		this.gruboscPolki = gruboscPolki;
		this.gruboscSrodnika = gruboscSrodnika;
		this.promienZaokragleniaDuzy = promienZaokragleniaDuzy;
		this.promienZaokragleniaMaly = promienZaokragleniaMaly;
	}

}