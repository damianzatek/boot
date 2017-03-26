package it.coderunner.spring.data.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Samochod;

public interface SamochodRepository extends CrudRepository<SamochodRepository, Long>{
	
	Page<Samochod> findAll(Pageable pageable);

	Page<Samochod> findByNameContainingAndTypeContainingAndColorContainingAllIgnoringCase(String name,
			String type,String color, Pageable pageable);

	Samochod findByNameAndTypeAndColorAllIgnoringCase(String name, String type,String color);
	
	List<Samochod> findFirst10ByColor(String color);
	
	@SuppressWarnings("unchecked")
	Samochod save(Samochod Samochod);

}
