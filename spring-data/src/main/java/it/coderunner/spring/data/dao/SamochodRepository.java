package it.coderunner.spring.data.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Kontrakt;

public interface SamochodRepository extends CrudRepository<Kontrakt, Long>{
	
	Page<Kontrakt> findAll(Pageable pageable);

	Page<Kontrakt> findByNameContainingAndTypeContainingAndColorContainingAllIgnoringCase(String name,
			String type,String color, Pageable pageable);

	Kontrakt findByNameAndTypeAndColorAllIgnoringCase(String name, String type,String color);
	
	List<Kontrakt> findFirst10ByColor(String color);
	
	@SuppressWarnings("unchecked")
	Kontrakt save(Kontrakt samochod);

}
