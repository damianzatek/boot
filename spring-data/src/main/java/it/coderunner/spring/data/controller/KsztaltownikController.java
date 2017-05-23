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
import it.coderunner.spring.data.model.Ksztaltownik;
import it.coderunner.spring.data.service.KontraktService;
import it.coderunner.spring.data.service.KsztaltownikService;


@Controller
public class KsztaltownikController {

	@Autowired
	private KsztaltownikService ksztaltownikService;

	@GetMapping("/get/ksztaltownik/{name}")
	public @ResponseBody ResponseEntity<String> getByName(@PathVariable String name) {
		Ksztaltownik ksztaltownik = ksztaltownikService.findByNazwaKsztaltownika(name);
		return ksztaltownik != null ? new ResponseEntity<String>("GET Response : " + ksztaltownik, HttpStatus.OK)
				: new ResponseEntity<String>("No ksztaltownik found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/save/nazwaksztaltownika/{name}/{wys}/{szer}/{grpolki}/{grsrodnika}/{promienmaly}/{promienduzy}")
	public @ResponseBody ResponseEntity<String> saveKsztaltownik(@PathVariable String name,@PathVariable String wys,@PathVariable String szer,
			@PathVariable String grpolki, @PathVariable String grsrodnika, @PathVariable String promienmaly, @PathVariable String promienduzy) {
		Ksztaltownik ksztaltownik = ksztaltownikService.save(new Ksztaltownik(name,wys,szer,grpolki,grsrodnika,promienmaly,promienduzy));
		return ksztaltownik != null ? new ResponseEntity<String>("GET Response : " + ksztaltownik, HttpStatus.OK)
				: new ResponseEntity<String>("Problem with saving", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/top10/{wysokosc}")
	public @ResponseBody ResponseEntity<String> getTop10(@PathVariable String wysokosc) {
		List<Ksztaltownik> ksztaltowniki = ksztaltownikService.findFirst10ByWysokosc(wysokosc);
		ksztaltowniki.stream().forEach(System.out::println);
		return ksztaltowniki != null && !ksztaltowniki.isEmpty()
				? new ResponseEntity<String>("GET Response : " + ksztaltowniki, HttpStatus.OK)
				: new ResponseEntity<String>("No samochod found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/allsam/{page}/{size}")
	public @ResponseBody Page<Ksztaltownik> getTop10(@PathVariable Integer page, @PathVariable Integer size) {
		return ksztaltownikService.findAll(new PageRequest(page, size));
	}

}
