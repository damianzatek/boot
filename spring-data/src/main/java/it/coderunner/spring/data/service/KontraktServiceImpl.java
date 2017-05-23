package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.coderunner.spring.data.dao.KontraktRepository;
import it.coderunner.spring.data.model.Kontrakt;

@Service
public class KontraktServiceImpl implements KontraktService{

	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private KontraktRepository kontraktRepository;

	@Override
	public Kontrakt findByName(String name) {
		return kontraktRepository.findByName(name) ;
	}

	@Override
	public Kontrakt save(Kontrakt kontrakt) {
		return kontraktRepository.save(kontrakt);
	}

	@Override
	public List<Kontrakt> findFirst10ByKlient(String klient) {
		return kontraktRepository.findFirst10ByKlient(klient);
	}

	@Override
	public Page<Kontrakt> findAll(Pageable pageable) {
		return kontraktRepository.findAll(pageable);
	}

}
