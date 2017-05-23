package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Kontrakt;

public interface KontraktService extends Serializable{

	Kontrakt findByName(String name);

	Kontrakt save(Kontrakt kontrakt);
	
	List<Kontrakt> findFirst10ByKlient(String name);
	
	Page<Kontrakt> findAll(Pageable pageable);

}
