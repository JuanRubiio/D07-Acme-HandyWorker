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

import services.SectionService;


import controllers.AbstractController;

import domain.Section;


@Controller
@RequestMapping("/section/handyworker")
public class SectionHandyWorkerController extends AbstractController{

	@Autowired
	private SectionService SectionService;
	
	
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		
		ModelAndView res;
		Collection<Section> Sectiones;
		
		Sectiones = SectionService.findAll();
		
		res = new ModelAndView("section/list");
		res.addObject("Sectiones",Sectiones);
		res.addObject("requestURI","section/handyworker/list.do");
		
		return res;
	}
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public ModelAndView create(@RequestParam Integer tutorialId){
		ModelAndView res;
		Section Section;
		
		Section = this.SectionService.create(tutorialId);
		
		res = this.createEditModelAndView(Section);
		
		return res;
	}

	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int SectionId){
		ModelAndView res;
		Section Section;
		
		Section = this.SectionService.findOne(SectionId);
		Assert.notNull(Section);
		res = createEditModelAndView(Section);
		
		return res;
	}

	@RequestMapping(value="/edit",method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Section Section, BindingResult binding){
		ModelAndView res;
		
		if(binding.hasErrors()){
			res = createEditModelAndView(Section);
		}else{
			try{
				SectionService.save(Section);
				res = new ModelAndView("redict:list.do");
			}catch(Throwable oops){
				res = createEditModelAndView(Section, "Section.commit.error");
								  }
		     }
		
		return res;
	}
	
	@RequestMapping(value="/edit",method = RequestMethod.POST, params="delete")
	public ModelAndView delete(Section Section, BindingResult binding){
		ModelAndView res;
		
		try{
			SectionService.delete(Section);
			res = new ModelAndView("redict:list.do");
		} catch(Throwable oops){
			res = createEditModelAndView(Section, "Section.commit.error");
		}
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(Section Section){
		ModelAndView res;
		
		res = createEditModelAndView(Section,null);
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(Section Section, String messageCode){
		ModelAndView res;
		
		
		
		res = new ModelAndView("Section/edit");
		res.addObject("Section",Section);
		res.addObject("message",messageCode);		
		
		return res;
	}
	
}