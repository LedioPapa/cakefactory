package com.lpa.manning.cakeshop.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.lpa.manning.cakeshop.service.PastryService;

@Slf4j
@Controller
public class IndexController {
	
	private PastryService pastryService;
	
	public IndexController(PastryService pastryService) {
		this.pastryService = pastryService;
	}

    @GetMapping("/")
    public String getIndex(Model model) {
    	model.addAttribute("pastries", pastryService.getPastries());
        return "index";
    }
}
