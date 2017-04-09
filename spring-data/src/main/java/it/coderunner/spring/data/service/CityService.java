package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Klient;

public interface CityService extends Serializable{

	Klient findByNameAndCountryAllIgnoringCase(String name, String country);

	Klient save(Klient city);
	
	List<Klient> findFirst10ByCountry(String country);
	
	Page<Klient> findAll(Pageable pageable);

}
