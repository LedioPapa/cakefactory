package com.lpa.manning.cakeshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PastryDTO {
	
	private String id = "id";
	private String description = "description";
	private Double price = 0.20;

}
