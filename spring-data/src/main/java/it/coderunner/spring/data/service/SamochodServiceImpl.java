package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.coderunner.spring.data.dao.SamochodRepository;
import it.coderunner.spring.data.model.Kontrakt;

@Service
public class SamochodServiceImpl implements SamochodService{

	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private SamochodRepository samochodRepository;

	@Override
	public Kontrakt findByNameAndTypeAndColorAllIgnoringCase(String name, String type, String color) {
		return samochodRepository.findByNameAndTypeAndColorAllIgnoringCase(name, type, color) ;
	}

	@Override
	public Kontrakt save(Kontrakt samochod) {
		return samochodRepository.save(samochod);
	}

	@Override
	public List<Kontrakt> findFirst10ByColor(String color) {
		return samochodRepository.findFirst10ByColor(color);
	}

	@Override
	public Page<Kontrakt> findAll(Pageable pageable) {
		return samochodRepository.findAll(pageable);
	}

}
