package it.coderunner.spring.data.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Klient;

public interface KlientRepository extends CrudRepository<Klient, Long>{
	

	//Page<Klient> findByNameContainingAllIgnoringCase(String name,
	//		String type,String color, Pageable pageable);

	List<Klient> findByNazwisko(String name);
	
	List<Klient> findFirst10ByNazwisko(String name);
	
	@SuppressWarnings("unchecked")
	Klient save(Klient klient);

	Page<Klient> findAll(Pageable pageable);
}
