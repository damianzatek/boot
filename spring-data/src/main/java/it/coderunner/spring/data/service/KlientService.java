package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Klient;

public interface KlientService extends Serializable{

	List<Klient> findByName(String name);

	Klient save(Klient klient);
	
	List<Klient> findFirst10ByKlient(String name);
	
	Page<Klient> findAll(Pageable pageable);

}
