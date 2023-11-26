package com.pessoalproject.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pessoalproject.dsvendas.dtos.SaleDTO;
import com.pessoalproject.dsvendas.dtos.SaleSuccessDTO;
import com.pessoalproject.dsvendas.dtos.SaleSumDTO;
import com.pessoalproject.dsvendas.repositories.SellerRepository;
import com.pessoalproject.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "sales")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAllPageable (Pageable pageable){
		
		sellerRepository.findAll();
		
		Page<SaleDTO> list = saleService.findAllPageable(pageable);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	
	@GetMapping(value = "sum-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amoutGroupedBySeller (){
		
		List<SaleSumDTO> list = saleService.amoutGroupedBySeller();
		
		return ResponseEntity.ok().body(list);	
	}
	
	@GetMapping(value = "success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGroupedBySeller (){
		
		List<SaleSuccessDTO> list = saleService.successGroupedBySeller();
		
		return ResponseEntity.ok().body(list);	
	}
}
