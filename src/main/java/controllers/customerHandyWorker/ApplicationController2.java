package controllers.customerHandyWorker;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ApplicationService;

import controllers.AbstractController;

import domain.Application;

@Controller
@RequestMapping("/application/handyworker,customer")
public class ApplicationController2 extends AbstractController{

	@Autowired
	private ApplicationService applicationService;
	
	//@Autowired
	//private actorService actorService;
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView res;
		Collection<Application> applications;
		
		//Si falla, probar:
		//Actor logueado = this.actorService.getPrincipal();
		//applications = ApplicationService.findByHandyWorker(logueado.getId());
		
		//y borrar: 	applications = applicationService.findAll();
		
		applications = applicationService.findAll();
		
		res = new ModelAndView("application/list");
		res.addObject("applications",applications);
		res.addObject("requestURI","application/handyworker,customer/list.do");
		
		return res;
	}
	
}
