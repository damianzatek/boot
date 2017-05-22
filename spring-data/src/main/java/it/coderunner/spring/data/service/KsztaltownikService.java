
package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Ksztaltownik;

public interface KsztaltownikService extends Serializable{

	Ksztaltownik findByNazwaksztaltownikaAndKlientAllIgnoringCase(String nazwaksztaltownika, String nazwisko);

	Ksztaltownik save(Ksztaltownik ksztaltownik);
	
	List<Ksztaltownik> findFirst10ByKsztaltownik(String ksztaltownik);
	
	Page<Ksztaltownik> findAll(Pageable pageable);

}
