package com.pessoalproject.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pessoalproject.dsvendas.dtos.SaleDTO;
import com.pessoalproject.dsvendas.dtos.SaleSuccessDTO;
import com.pessoalproject.dsvendas.dtos.SaleSumDTO;
import com.pessoalproject.dsvendas.entities.Sale;
import com.pessoalproject.dsvendas.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAllPageable (Pageable pageable){
		Page<Sale> sales = saleRepository.findAll(pageable);
		
		return sales.map(x -> new SaleDTO(x));
	}
	
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amoutGroupedBySeller(){
		return saleRepository.amoutGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller(){
		return saleRepository.successGroupedBySeller();
	}
}
