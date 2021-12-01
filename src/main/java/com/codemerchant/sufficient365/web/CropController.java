package com.codemerchant.sufficient365.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codemerchant.sufficient365.domain.Crop;
import com.codemerchant.sufficient365.domain.CropRepository;

@RestController

public class CropController {
	@Autowired
	private CropRepository repository;
	
	
	@RequestMapping("/crops")
	public Iterable<Crop> getCrops(){
	return repository.findAll();	
	}

}
