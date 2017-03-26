package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.coderunner.spring.data.dao.SamochodRepository;
import it.coderunner.spring.data.model.Samochod;

@Service
public class SamochodServiceImpl implements SamochodService{

	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private SamochodRepository samochodRepository;

	@Override
	public Samochod findByNameAndTypeAndColorAllIgnoringCase(String name, String type, String color) {
		return samochodRepository.findByNameAndTypeAndColorAllIgnoringCase(name, type, color) ;
	}

	@Override
	public Samochod save(Samochod Samochod) {
		return samochodRepository.save(Samochod);
	}

	@Override
	public List<Samochod> findFirst10ByColor(String color) {
		return samochodRepository.findFirst10ByColor(color);
	}

	@Override
	public Page<Samochod> findAll(Pageable pageable) {
		return samochodRepository.findAll(pageable);
	}

}
