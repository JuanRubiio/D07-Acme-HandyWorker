package controllers.handyWorker;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import services.ActorService;
import services.SectionService;
import services.TutorialService;

import controllers.AbstractController;
import domain.Actor;
import domain.HandyWorker;
import domain.Section;
import domain.Tutorial;

@Controller
@RequestMapping("/tutorial/handyworker")
public class TutorialHandyWorkerController extends AbstractController{

	@Autowired
	private TutorialService TutorialService;
	@Autowired
	private SectionService sectionService;
	@Autowired
	private ActorService actorService;
	
	//HAY QUE HACER UN METODO POR CADA ENLACE O BOTON DE LA ENTIDAD EN LA APLICACION
	
	//VISTAS DIRECCIONABLES (SOLO LAS RENDERIZA Y LAS MUESTRA)
	
	//LIST
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		
		ModelAndView res;
		Collection<Tutorial> tutoriales;
		Actor logueado = this.actorService.getPrincipal();
		tutoriales = TutorialService.findByHandyWorker(logueado.getId());
		
		res = new ModelAndView("tutorial/list");
		res.addObject("tutorials",tutoriales);
		res.addObject("requestURI","tutorial/handyworker/list.do");
		
		return res;
	}
	
	
	//CREATE
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView res;
		Tutorial tutorial;
		Actor logueado = this.actorService.getPrincipal();
		//Assert.isTrue(logueado instanceof HandyWorker);
		HandyWorker hw = (HandyWorker) logueado;
		tutorial = this.TutorialService.create();
		tutorial.setHandyWorker(hw);
		res = this.createEditModelAndView(tutorial);
		
		return res;
	}

	//EDIT
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int tutorialId){
		ModelAndView res;
		Tutorial Tutorial;
		
		Tutorial = this.TutorialService.findOne(tutorialId);
		Assert.notNull(Tutorial);
		res = createEditModelAndView(Tutorial);
		
		return res;
	}

	//SHOW
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam final int tutorialId) {
			ModelAndView result;
			Tutorial t;
			t = this.TutorialService.findOne(tutorialId);
			result = new ModelAndView("tutorial/show");
			result.addObject("tutorial", t);

			return result;
		}
	
	//DELETE
	
	
	//PARA BORRAR, ELIMINAR TAMBIEN DE TABLAS AJENAS
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam final int tutorialId){
		
		ModelAndView res;
		Tutorial tutorial;
		tutorial = this.TutorialService.findOne(tutorialId);
		Assert.notNull(tutorial);
		TutorialService.delete(tutorial);
		//REDIRIGE AL CONTROLLER DE LIST Y CARGA LA VISTA LIST.JSP
		res = new ModelAndView("redirect:list.do");
		return res;
	}
	
	
	//BOTONES POST EN VARIAS VISTAS
	
	
	//SAVE (CREAR O EDITAR)
	
	//PARA GUARDAR EN LA BASE DE DATOS RELLENARLE TODOS LOS CAMBIOS NECESARIOS
	
	@RequestMapping(value="/save",method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Tutorial tutorial, BindingResult binding){
		ModelAndView res;
		
		if(binding.hasErrors()){
			System.out.println(binding.getAllErrors());
			res = createEditModelAndView(tutorial);
		}else{
			try{
				TutorialService.save(tutorial);
				res = new ModelAndView("redirect:list.do");
			}catch(Throwable oops){
				System.out.println("catch");
				res = createEditModelAndView(tutorial, "tutorial.commit.error");
								  }
		     }
		
		return res;
	}	
	
	
	//METODOS AUXILIARES
	
	protected ModelAndView createEditModelAndView(Tutorial Tutorial){
		ModelAndView res;
		
		res = createEditModelAndView(Tutorial,null);
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(Tutorial tutorial, String messageCode){
		ModelAndView res;
		Collection<Section> sections;
		
		sections = sectionService.findAll();
		
		//CREA UNA VISTA RENDERIZADA USANDO EDIT.JSP COMO BASE
		res = new ModelAndView("tutorial/edit");
		res.addObject("tutorial",tutorial);
		res.addObject("section", sections);
		res.addObject("message",messageCode);		
		
		return res;
	}
	
}