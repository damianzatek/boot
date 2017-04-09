package it.coderunner.spring.data.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import it.coderunner.spring.data.model.Kontrakt;
import it.coderunner.spring.data.service.SamochodService;


@Controller
public class SamochodController {

	@Autowired
	private SamochodService samochodService;

	@GetMapping("/get/samochod/{name}/{type}/{color}")
	public @ResponseBody ResponseEntity<String> getByNameAndCountry(@PathVariable String name,
			@PathVariable String type, @PathVariable String color) {
		Kontrakt samochod = samochodService.findByNameAndTypeAndColorAllIgnoringCase(name, type, color);
		return samochod != null ? new ResponseEntity<String>("GET Response : " + samochod, HttpStatus.OK)
				: new ResponseEntity<String>("No samochod found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/save/samochod/{name}/{type}/{color}")
	public @ResponseBody ResponseEntity<String> saveSamochod(@PathVariable String name,
			@PathVariable String type, @PathVariable String color) {
		Kontrakt samochod = samochodService.save(new Kontrakt(name, type, color));
		return samochod != null ? new ResponseEntity<String>("GET Response : " + samochod, HttpStatus.OK)
				: new ResponseEntity<String>("Problem with saving", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/top10/{color}")
	public @ResponseBody ResponseEntity<String> getTop10(@PathVariable String color) {
		List<Kontrakt> samochody = samochodService.findFirst10ByColor(color);
		samochody.stream().forEach(System.out::println);
		return samochody != null && !samochody.isEmpty()
				? new ResponseEntity<String>("GET Response : " + samochody, HttpStatus.OK)
				: new ResponseEntity<String>("No samochod found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/allsam/{page}/{size}")
	public @ResponseBody Page<Kontrakt> getTop10(@PathVariable Integer page, @PathVariable Integer size) {
		return samochodService.findAll(new PageRequest(page, size));
	}

}
