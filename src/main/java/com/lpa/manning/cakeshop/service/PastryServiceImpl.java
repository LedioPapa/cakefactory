package com.lpa.manning.cakeshop.service;

import java.util.ArrayList;
import java.util.List;

import com.lpa.manning.cakeshop.repository.PastryRepository;
import org.springframework.stereotype.Service;

import com.lpa.manning.cakeshop.model.PastryDTO;

@Service
public class PastryServiceImpl implements PastryService {

	private PastryRepository pastryRepository;

	public PastryServiceImpl(PastryRepository pastryRepository) {
		this.pastryRepository = pastryRepository;
	}

	@Override
	public List<PastryDTO> getPastries() {
		List<PastryDTO> pastries = new ArrayList<>();
		pastryRepository.findAll().forEach(e -> pastries.add(new PastryDTO(e.getId(), e.getDescription(), e.getPrice())));
		return pastries;
	}

}
