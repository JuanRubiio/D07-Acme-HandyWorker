package controllers.handyWorker;

import java.util.Collection;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import services.TutorialService;

import controllers.AbstractController;


import domain.Tutorial;

@Controller
@RequestMapping("/tutorial")
public class TutorialController extends AbstractController{

	@Autowired
	private TutorialService TutorialService;

	
	//HAY QUE HACER UN METODO POR CADA ENLACE O BOTON DE LA ENTIDAD EN LA APLICACION
	
	//VISTAS DIRECCIONABLES (SOLO LAS RENDERIZA Y LAS MUESTRA)
	
	//LIST
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		
		ModelAndView res;
		Collection<Tutorial> tutoriales;
		tutoriales = TutorialService.findAll();
		
		res = new ModelAndView("tutorial/list");
		res.addObject("tutorials",tutoriales);
		res.addObject("requestURI","tutorial/list.do");
		
		return res;
	}
	
	
}