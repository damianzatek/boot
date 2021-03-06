package it.coderunner.spring.data.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import it.coderunner.spring.data.model.Ksztaltownik;

public interface KsztaltownikRepository extends CrudRepository<Ksztaltownik, Long>{
	
	Page<Ksztaltownik> findAll(Pageable pageable);

	Ksztaltownik findByNazwaKsztaltownikaAllIgnoringCase(String name);
	
	List<Ksztaltownik> findFirst10ByWysokosc(String wysokosc);
	
	@SuppressWarnings("unchecked")
	Ksztaltownik save(Ksztaltownik ksztaltownik);

}
