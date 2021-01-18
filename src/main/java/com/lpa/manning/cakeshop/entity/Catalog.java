package com.lpa.manning.cakeshop.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
//@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
@Entity
public class Catalog {

	@Id
	private String id = "id";
	private String description = "description";
	private Double price = 0.20;

}
