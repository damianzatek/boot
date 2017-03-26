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
public class Samochod implements Serializable {

	private static final long serialVersionUID = -7901094204949006826L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String type;
	
	@Column(nullable = false)
	private String color;
	
	public Samochod(String name, String type, String color){
		this.name = name;
		this.type = type;
		this.color=color;
	}

}