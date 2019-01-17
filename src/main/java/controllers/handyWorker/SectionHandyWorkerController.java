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
import services.TutorialService;


import controllers.AbstractController;

import domain.Section;
import domain.Tutorial;



@Controller
@RequestMapping("/section/handyworker")
public class SectionHandyWorkerController extends AbstractController{

	@Autowired
	private SectionService SectionService;
	@Autowired
	private TutorialService tutorialService;	
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(@RequestParam Integer tutorialId){
		
		ModelAndView res;
		Collection<Section> Sectiones;
		
		Sectiones = SectionService.findByTutorial(tutorialId);
		Tutorial tuto = tutorialService.findOne(tutorialId);
	
		
		res = new ModelAndView("section/list");
		res.addObject("sections",Sectiones);
		res.addObject("tutorial",tuto);
		res.addObject("requestURI","section/handyworker/list.do");
		
		return res;
	}
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public ModelAndView create(@RequestParam Integer tutorialId){
		ModelAndView res;
		Section Section;
	
		Tutorial t = this.tutorialService.findOne(tutorialId);
		Section = this.SectionService.create(tutorialId);
		Collection<Section> secciones = t.getSections();
		secciones.add(Section);
		
		res = this.createEditModelAndView(Section);
		res.addObject("action","section/handyworker/save.do?tutorialId=" + tutorialId);
		return res;
	}

	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int sectionId,@RequestParam int tutorialId){
		ModelAndView res;
		Section Section;
		
		Section = this.SectionService.findOne(sectionId);
		Assert.notNull(Section);
		res = createEditModelAndView(Section);
		res.addObject("action","section/handyworker/save.do?tutorialId=" + tutorialId);
		res.addObject("id", tutorialId);
		
		return res;
	}
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam final int sectionId,@RequestParam int tutorialId) {
			ModelAndView result;
			Section s;
			s = this.SectionService.findOne(sectionId);
			result = new ModelAndView("section/show");
			result.addObject("section", s);
			result.addObject("id", tutorialId);

			return result;
		}
	
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam final int sectionId, @RequestParam int tutorialId){
		
		ModelAndView res;
		Section section;
	    section = this.SectionService.findOne(sectionId);
		Assert.notNull(section);
		SectionService.delete(section);
		res = new ModelAndView("redirect:list.do?tutorialId="+tutorialId);
		return res;
	}

	@RequestMapping(value="/save",method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Section Section, BindingResult binding, @RequestParam int tutorialId){
		ModelAndView res;
		
		if(binding.hasErrors()){
			System.out.println(binding.getAllErrors());
			res = createEditModelAndView(Section);
		}else{
			try{
				SectionService.save(Section,tutorialId);
				res = new ModelAndView("redirect:list.do?tutorialId="+tutorialId);
			}catch(Throwable oops){
				res = createEditModelAndView(Section, "Section.commit.error");
								  }
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
		
		res = new ModelAndView("section/edit");
		res.addObject("section",Section);
		res.addObject("message",messageCode);		
		
		return res;
	}
	
}