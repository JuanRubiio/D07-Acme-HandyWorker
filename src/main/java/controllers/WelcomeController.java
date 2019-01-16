/*
 * WelcomeController.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import services.ConfigurationService;
import domain.Configuration;

@Controller
@RequestMapping("/welcome")
public class WelcomeController extends AbstractController {

	@Autowired
	private ConfigurationService	configurationService;


	// Constructors -----------------------------------------------------------

	public WelcomeController() {
		super();
	}

	// Index ------------------------------------------------------------------		

	@RequestMapping(value = "/index")
	public ModelAndView index(final Locale locale) {
		final ModelAndView res = new ModelAndView("welcome/index");
		final Configuration configuration = this.configurationService.findAll().iterator().next();
		res.addObject("banner", configuration.getBanner());
		if (locale.getLanguage().equals("es"))
			res.addObject("name", configuration.getWelcomMessageEs());
		else
			res.addObject("name", configuration.getWelcomMessage());

		return res;
	}
}
