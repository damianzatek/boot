package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Kontrakt;

public interface SamochodService extends Serializable{

	Kontrakt findByNameAndTypeAndColorAllIgnoringCase(String name, String type,String color);

	Kontrakt save(Kontrakt samochod);
	
	List<Kontrakt> findFirst10ByColor(String color);
	
	Page<Kontrakt> findAll(Pageable pageable);

}
