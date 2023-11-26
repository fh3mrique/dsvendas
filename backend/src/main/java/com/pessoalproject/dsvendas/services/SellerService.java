package com.pessoalproject.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoalproject.dsvendas.dtos.SellerDTO;
import com.pessoalproject.dsvendas.entities.Seller;
import com.pessoalproject.dsvendas.repositories.SellerRepository;

@Service
public class SellerService {
	
	@Autowired
	private SellerRepository sellerRepository;
	
	public List<SellerDTO> findAll (){
		List<Seller> sellers = sellerRepository.findAll();
		
		return sellers.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());	
	}
	
	

}
