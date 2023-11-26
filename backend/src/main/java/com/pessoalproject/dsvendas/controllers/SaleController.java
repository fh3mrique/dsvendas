package com.pessoalproject.dsvendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoalproject.dsvendas.dtos.SaleDTO;
import com.pessoalproject.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAllPageable (Pageable pageable){
		
		Page<SaleDTO> list = saleService.findAllPageable(pageable);
		
		return ResponseEntity.ok().body(list);
		
	}
}
