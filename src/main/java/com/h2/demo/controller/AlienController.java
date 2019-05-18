package com.h2.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.h2.demo.dao.AlienRepository;
import com.h2.demo.model.Alien;

@RestController
@ResponseBody
public class AlienController {

	@Autowired
	private AlienRepository alienRepository;

	@RequestMapping(path = "/aliens", method = RequestMethod.GET)
	public ResponseEntity<?> getAllAliens() {
		List<Alien> aliens = alienRepository.findAll();
		return ResponseEntity.ok(aliens);
	}

	@RequestMapping(path = "/alien/{id}/", method = RequestMethod.GET)
	public ResponseEntity<?> getAlien(@PathVariable String id) {
		Alien alien = alienRepository.getOne(Integer.parseInt(id));
		return ResponseEntity.ok(alien);
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ResponseEntity<?> addAlien(@RequestBody(required = true) Alien alien) {
		alienRepository.save(alien);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(path = "/alien/{id}/", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteAlien(@PathVariable String id) {
		Alien alien = alienRepository.getOne(Integer.parseInt(id));
		alienRepository.delete(alien);
		return ResponseEntity.ok().build();
	}
}
