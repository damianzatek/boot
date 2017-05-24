package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import it.coderunner.spring.data.dao.KlientRepository;
import it.coderunner.spring.data.model.Klient;


@Service
public class KlientServiceImpl implements KlientService{

	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private KlientRepository klientRepository;

	@Override
	public List<Klient> findByName(String name) {
		return klientRepository.findByNazwisko(name) ;
	}

	@Override
	public Klient save(Klient klient) {
		return klientRepository.save(klient);
	}

	@Override
	public List<Klient> findFirst10ByKlient(String klient) {
		return klientRepository.findFirst10ByNazwisko(klient);
	}

	@Override
	public Page<Klient> findAll(Pageable pageable) {
		return klientRepository.findAll(pageable);
	}

	

}
