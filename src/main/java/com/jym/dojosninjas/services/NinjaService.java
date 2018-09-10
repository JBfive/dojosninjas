package com.jym.dojosninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jym.dojosninjas.models.Ninja;
import com.jym.dojosninjas.repositories.DojoRepository;
import com.jym.dojosninjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	private final DojoRepository dojoRepo;
	private final NinjaRepository ninjaRepo;
	
	public NinjaService(DojoRepository dojoRepo, NinjaRepository ninjaRepo) {
		this.dojoRepo = dojoRepo;
		this.ninjaRepo = ninjaRepo;
	}
	public Ninja createNinja(Ninja ninja) {
		System.out.println("This is Service");
		return ninjaRepo.save(ninja);
	}
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
}
