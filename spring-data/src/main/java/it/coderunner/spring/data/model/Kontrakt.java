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
public class Kontrakt implements Serializable {

	private static final long serialVersionUID = -7901094204949006826L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String nrkontraktu;

	@Column(nullable = false)
	private String dataotwarcia;
	
	@Column(nullable = false)
	private String terminzakonczenia;
	
	public Kontrakt(String nrkontraktu, String dataotwarcia, String terminzakonczenia){
		this.nrkontraktu = nrkontraktu;
		this.dataotwarcia = dataotwarcia;
		this.terminzakonczenia = terminzakonczenia;
	}

}