package it.coderunner.spring.data.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.coderunner.spring.data.dao.CityRepository;
import it.coderunner.spring.data.model.Klient;

@Service
public class CityServiceImpl implements CityService{

	private static final long serialVersionUID = -5212497294563141450L;
	
	@Resource
	private CityRepository cityRepository;

	@Override
	public Klient findByNameAndCountryAllIgnoringCase(String name, String country) {
		return cityRepository.findByNameAndCountryAllIgnoringCase(name, country) ;
	}

	@Override
	public Klient save(Klient city) {
		return cityRepository.save(city);
	}

	@Override
	public List<Klient> findFirst10ByCountry(String country) {
		return cityRepository.findFirst10ByCountry(country);
	}

	@Override
	public Page<Klient> findAll(Pageable pageable) {
		return cityRepository.findAll(pageable);
	}

}
