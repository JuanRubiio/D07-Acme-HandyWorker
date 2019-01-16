package controllers.handyworkercustomer;

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
import services.EndorsementService;

import controllers.AbstractController;
import domain.HandyWorker;
import domain.Section;
import domain.Endorsement;

@Controller
@RequestMapping("/Endorsement/handyworker")
public class EndorsementCustomerController extends AbstractController{

	@Autowired
	private EndorsementService EndorsementService;
	@Autowired
	private SectionService sectionService;
	
	
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		
		ModelAndView res;
		Collection<Endorsement> Endorsementes;
		
		Endorsementes = EndorsementService.findAll();
		
		res = new ModelAndView("Endorsement/list");
		res.addObject("Endorsementes",Endorsementes);
		res.addObject("requestURI","Endorsement/handyworker/list.do");
		
		return res;
	}
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public ModelAndView create(@RequestParam HandyWorker handyWorker){
		ModelAndView res;
		Endorsement Endorsement;
		
		Endorsement = this.EndorsementService.create(handyWorker);
		
		res = this.createEditModelAndView(Endorsement);
		
		return res;
	}

	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int EndorsementId){
		ModelAndView res;
		Endorsement Endorsement;
		
		Endorsement = this.EndorsementService.findOne(EndorsementId);
		Assert.notNull(Endorsement);
		res = createEditModelAndView(Endorsement);
		
		return res;
	}

	@RequestMapping(value="/edit",method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Endorsement Endorsement, BindingResult binding){
		ModelAndView res;
		
		if(binding.hasErrors()){
			res = createEditModelAndView(Endorsement);
		}else{
			try{
				EndorsementService.save(Endorsement);
				res = new ModelAndView("redict:list.do");
			}catch(Throwable oops){
				res = createEditModelAndView(Endorsement, "Endorsement.commit.error");
								  }
		     }
		
		return res;
	}
	
	@RequestMapping(value="/edit",method = RequestMethod.POST, params="delete")
	public ModelAndView delete(Endorsement Endorsement, BindingResult binding){
		ModelAndView res;
		
		try{
			EndorsementService.delete(Endorsement);
			res = new ModelAndView("redict:list.do");
		} catch(Throwable oops){
			res = createEditModelAndView(Endorsement, "Endorsement.commit.error");
		}
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(Endorsement Endorsement){
		ModelAndView res;
		
		res = createEditModelAndView(Endorsement,null);
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(Endorsement Endorsement, String messageCode){
		ModelAndView res;
		Collection<Section> sections;
		
		sections = sectionService.findAll();
		
		
		res = new ModelAndView("Endorsement/edit");
		res.addObject("Endorsement",Endorsement);
		res.addObject("section", sections);
		res.addObject("message",messageCode);		
		
		return res;
	}
	
}