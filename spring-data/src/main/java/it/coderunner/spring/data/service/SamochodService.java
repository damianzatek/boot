package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Samochod;

public interface SamochodService extends Serializable{

	Samochod findByNameAndTypeAndColorAllIgnoringCase(String name, String type,String color);

	Samochod save(Samochod samochod);
	
	List<Samochod> findFirst10ByColor(String color);
	
	Page<Samochod> findAll(Pageable pageable);

}
