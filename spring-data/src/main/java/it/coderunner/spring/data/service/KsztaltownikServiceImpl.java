package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.coderunner.spring.data.dao.KsztaltownikRepository;
import it.coderunner.spring.data.model.Ksztaltownik;

@Service
public class KsztaltownikServiceImpl implements KsztaltownikService{

	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private KsztaltownikRepository ksztaltownikRepository;

	@Override
	public Ksztaltownik findByNazwaksztaltownikaAndKlientAllIgnoringCase(String nazwaksztaltownika, String klient) {
		return ksztaltownikRepository.findByNazwaksztaltownikaAndKlientAllIgnoringCase(nazwaksztaltownika, klient) ;
	}

	@Override
	public Ksztaltownik save(Ksztaltownik ksztaltownik) {
		return ksztaltownikRepository.save(ksztaltownik);
	}

	@Override
	public List<Ksztaltownik> findFirst10ByKsztaltownik(String ksztaltownik) {
		return ksztaltownikRepository.findFirst10ByKsztaltownik(ksztaltownik);
	}

	@Override
	public Page<Ksztaltownik> findAll(Pageable pageable) {
		return ksztaltownikRepository.findAll(pageable);
	}

}
