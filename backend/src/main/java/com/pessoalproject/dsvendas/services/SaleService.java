package com.pessoalproject.dsvendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pessoalproject.dsvendas.dtos.SaleDTO;
import com.pessoalproject.dsvendas.entities.Sale;
import com.pessoalproject.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public Page<SaleDTO> findAllPageable (Pageable pageable){
		Page<Sale> sales = saleRepository.findAll(pageable);
		
		return sales.map(x -> new SaleDTO(x));
	}
	
	

}
