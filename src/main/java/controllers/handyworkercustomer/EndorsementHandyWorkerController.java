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

import services.ActorService;

import services.EndorsementService;

import controllers.AbstractController;
import domain.Actor;
import domain.Customer;


import domain.Endorsement;


@Controller
@RequestMapping("/endorsement/handyworker")
public class EndorsementHandyWorkerController extends AbstractController{

	@Autowired
	private EndorsementService EndorsementService;
	@Autowired
	private ActorService actorService;
	
	
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		
		ModelAndView res;
		Collection<String> Endorsements;
		Actor logueado = this.actorService.getPrincipal();
		Endorsements = EndorsementService.findByWriteToComments(logueado.getId());
		
		res = new ModelAndView("endorsement/list");
		res.addObject("endorsements",Endorsements);
		res.addObject("requestURI","endorsement/handyworker/list.do");
		
		return res;
	}
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public ModelAndView create(@RequestParam Customer customer){
		ModelAndView res;
		Endorsement Endorsement;
		
		Endorsement = this.EndorsementService.create(customer);
		
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
	
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam final int endorsementId) {
			ModelAndView result;
			Endorsement e;
			e = this.EndorsementService.findOne(endorsementId);
			result = new ModelAndView("endorsement/show");
			result.addObject("endorsement", e);

			return result;
		}
	
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam final int endorsementId){
		
		ModelAndView res;
		Endorsement e;
		e = this.EndorsementService.findOne(endorsementId);
		Assert.notNull(e);
		EndorsementService.delete(e);
		
		res = new ModelAndView("redirect:list.do");
		return res;
	}
	

	@RequestMapping(value="/save",method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Endorsement Endorsement, BindingResult binding){
		ModelAndView res;
		
		if(binding.hasErrors()){
			System.out.println(binding.getAllErrors());
			res = createEditModelAndView(Endorsement);
		}else{
			try{
				EndorsementService.save(Endorsement);
				res = new ModelAndView("redirect:list.do");
			}catch(Throwable oops){
				res = createEditModelAndView(Endorsement, "endorsement.commit.error");
								  }
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
		
		
		res = new ModelAndView("endorsement/edit");
		res.addObject("endorsement",Endorsement);
		res.addObject("message",messageCode);		
		
		return res;
	}
	
}