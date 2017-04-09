package it.coderunner.spring.data.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Klient;

public interface CityRepository extends CrudRepository<Klient, Long>{
	
	Page<Klient> findAll(Pageable pageable);

	Page<Klient> findByNameContainingAndCountryContainingAllIgnoringCase(String name,
			String country, Pageable pageable);

	Klient findByNameAndCountryAllIgnoringCase(String name, String country);
	
	List<Klient> findFirst10ByCountry(String country);
	
	@SuppressWarnings("unchecked")
	Klient save(Klient city);

}
