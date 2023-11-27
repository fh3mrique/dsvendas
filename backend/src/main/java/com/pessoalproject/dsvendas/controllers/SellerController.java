package com.pessoalproject.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoalproject.dsvendas.dtos.SellerDTO;
import com.pessoalproject.dsvendas.services.SellerService;

@RestController
@RequestMapping(value = "sellers")
@CrossOrigin(origins = "*")
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping
	public ResponseEntity<List<SellerDTO>> findAll(){
		
		List<SellerDTO> list = sellerService.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
}
