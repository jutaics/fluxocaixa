package com.fluxocaixa.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fluxocaixa.models.Conta;
import com.fluxocaixa.repository.ContaRepository;

@Controller
public class IndexController {

	@Autowired
	private ContaRepository er;

	@RequestMapping("/")
	public ModelAndView dashboard() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Conta> dashboard = er.findAll();
		mv.addObject("dashboard", dashboard);
		return mv;
	}

}
