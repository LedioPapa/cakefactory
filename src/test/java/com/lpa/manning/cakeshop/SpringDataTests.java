package com.lpa.manning.cakeshop;

import com.lpa.manning.cakeshop.entity.Catalog;
import com.lpa.manning.cakeshop.repository.PastryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
public class SpringDataTests {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private PastryRepository pastryRepository;

    @Test
    void getDataFromDB() {
        this.testEntityManager.persist(new Catalog("abcr", "All Butter Croissant", 0.75));
        Optional<Catalog> pastry = pastryRepository.findById("abcr");
        assertThat(pastry.orElse(null)).isNotNull();
        assertThat(pastry.get().getId()).isEqualTo("abcr");
    }
}
