package it.coderunner.spring.data.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Ksztaltownik;

public interface KsztaltownikRepository extends CrudRepository<Ksztaltownik, Long>{
	
	Page<Ksztaltownik> findAll(Pageable pageable);

	Page<Klient> findByNameContainingAndKsztaltownikContainingAllIgnoringCase(String name,
			String ksztaltownik, Pageable pageable);

	Klient findByNameAndKsztaltownikAllIgnoringCase(String name, String ksztaltownik);
	
	List<Klient> findFirst10ByKsztaltownik(String ksztaltownik);
	
	@SuppressWarnings("unchecked")
	Ksztaltownik save(Klient ksztaltownik);

}
