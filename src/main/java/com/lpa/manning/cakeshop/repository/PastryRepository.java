package com.lpa.manning.cakeshop.repository;

import com.lpa.manning.cakeshop.entity.Catalog;
import org.springframework.data.repository.CrudRepository;

public interface PastryRepository extends CrudRepository<Catalog, String> {
}
