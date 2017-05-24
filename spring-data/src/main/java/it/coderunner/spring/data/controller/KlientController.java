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

import it.coderunner.spring.data.model.Klient;
import it.coderunner.spring.data.service.KlientService;

@Controller
public class KlientController {

	@Autowired
	private KlientService klientService;

	@GetMapping("/get/klient/{name}")
	public @ResponseBody ResponseEntity<String> getByName(@PathVariable String name) {
		List<Klient> klient = klientService.findByName(name);
		return klient != null ? new ResponseEntity<String>("GET Response : " + klient, HttpStatus.OK)
				: new ResponseEntity<String>("Nie znaleziono klienta", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/save/klient/{login}/{haslo}/{imie}/{nazwisko}/{email}")
	public @ResponseBody ResponseEntity<String> saveKlient(@PathVariable String login, @PathVariable String haslo, @PathVariable String imie, @PathVariable String nazwisko, @PathVariable String email) {
		Klient klient = klientService.save(new Klient(login,haslo,imie,nazwisko,email));
		return klient != null ? new ResponseEntity<String>("GET Response : " + klient, HttpStatus.OK)
				: new ResponseEntity<String>("Problem with saving", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/klient/top10/{name}")
	public @ResponseBody ResponseEntity<String> getTop10(@PathVariable String name) {
		List<Klient> klients = klientService.findFirst10ByKlient(name);
		klients.stream().forEach(System.out::println);
		return klients != null && !klients.isEmpty()
				? new ResponseEntity<String>("GET Response : " + klients, HttpStatus.OK)
				: new ResponseEntity<String>("No city found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/klient/all/{page}/{size}")
	public @ResponseBody Page<Klient> getTop10(@PathVariable Integer page, @PathVariable Integer size) {
		return klientService.findAll(new PageRequest(page, size));
	}

}
