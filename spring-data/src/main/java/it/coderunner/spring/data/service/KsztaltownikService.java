
package it.coderunner.spring.data.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.coderunner.spring.data.model.Ksztaltownik;

public interface KsztaltownikService extends Serializable{

	Ksztaltownik findByNazwaKsztaltownika(String nazwaksztaltownika);

	Ksztaltownik save(Ksztaltownik ksztaltownik);
	
	List<Ksztaltownik> findFirst10ByWysokosc(String wysokosc);
	
	Page<Ksztaltownik> findAll(Pageable pageable);

}
