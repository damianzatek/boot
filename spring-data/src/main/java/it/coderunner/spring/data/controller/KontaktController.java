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
import it.coderunner.spring.data.service.KontraktService;


@Controller
public class KontaktController {

	@Autowired
	private KontraktService kontraktService;

	@GetMapping("/get/kontrakt/{name}")
	public @ResponseBody ResponseEntity<String> getByName(@PathVariable String name) {
		Kontrakt kontrakt = kontraktService.findByName(name);
		return kontrakt != null ? new ResponseEntity<String>("GET Response : " + kontrakt, HttpStatus.OK)
				: new ResponseEntity<String>("No kontrakt found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/save/kontrakt/{nrKontraktu}/{dataOtwarcia}")
	public @ResponseBody ResponseEntity<String> saveSamochod(@PathVariable String nrKontraktu,
			@PathVariable String dataOtwarcia) {
		Kontrakt kontrakt = kontraktService.save(new Kontrakt(nrKontraktu, dataOtwarcia));
		return kontrakt != null ? new ResponseEntity<String>("GET Response : " + kontrakt, HttpStatus.OK)
				: new ResponseEntity<String>("Problem with saving", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/top10/{nameKlienta}")
	public @ResponseBody ResponseEntity<String> getTop10(@PathVariable String nameKlienta) {
		List<Kontrakt> kontrakty = kontraktService.findFirst10ByKlient(nameKlienta);
		 kontrakty.stream().forEach(System.out::println);
		return  kontrakty != null && ! kontrakty.isEmpty()
				? new ResponseEntity<String>("GET Response : " +  kontrakty, HttpStatus.OK)
				: new ResponseEntity<String>("No samochod found", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/get/allsam/{page}/{size}")
	public @ResponseBody Page<Kontrakt> getTop10(@PathVariable Integer page, @PathVariable Integer size) {
		return kontraktService.findAll(new PageRequest(page, size));
	}

}
