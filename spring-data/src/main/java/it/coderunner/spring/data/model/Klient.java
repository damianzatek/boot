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
public class Klient implements Serializable {

	private static final long serialVersionUID = -7901094204949006825L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String login;

	@Column(nullable = false)
	private String haslo;
	
	@Column(nullable = false)
	private String imie;
	
	@Column(nullable = false)
	private String nazwisko;
	
	@Column(nullable = false)
	private String email;
	
	public Klient(String login, String haslo, String imie, String nazwisko, String email){
		this.login = login;
		this.haslo = haslo;
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.email = email;
		
	}

}