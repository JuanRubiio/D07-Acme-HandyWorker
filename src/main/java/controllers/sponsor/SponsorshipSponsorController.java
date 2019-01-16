package controllers.sponsor;

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
import services.SponsorshipService;

import controllers.AbstractController;
import domain.Sponsor;
import domain.Section;
import domain.Sponsorship;
import domain.Tutorial;

@Controller
@RequestMapping("/Sponsorship/sponsor")
public class SponsorshipSponsorController extends AbstractController{

	@Autowired
	private SponsorshipService SponsorshipService;
	
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		
		ModelAndView res;
		Collection<Sponsorship> sponsorships;
		
		sponsorships = SponsorshipService.findAll();
		
		res = new ModelAndView("sponsorship/list");
		res.addObject("sponsorships",sponsorships);
		res.addObject("requestURI","sponsorship/sponsor/list.do");
		
		return res;
	}
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public ModelAndView create(@RequestParam Tutorial tutorial){
		ModelAndView res;
		Sponsorship Sponsorship;
		
		Sponsorship = this.SponsorshipService.create(tutorial);
		
		res = this.createEditModelAndView(Sponsorship);
		
		return res;
	}

	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int SponsorshipId){
		ModelAndView res;
		Sponsorship Sponsorship;
		
		Sponsorship = this.SponsorshipService.findOne(SponsorshipId);
		Assert.notNull(Sponsorship);
		res = createEditModelAndView(Sponsorship);
		
		return res;
	}

	@RequestMapping(value="/edit",method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Sponsorship Sponsorship, BindingResult binding){
		ModelAndView res;
		
		if(binding.hasErrors()){
			res = createEditModelAndView(Sponsorship);
		}else{
			try{
				SponsorshipService.save(Sponsorship);
				res = new ModelAndView("redict:list.do");
			}catch(Throwable oops){
				res = createEditModelAndView(Sponsorship, "Sponsorship.commit.error");
								  }
		     }
		
		return res;
	}
	
//	@RequestMapping(value="/edit",method = RequestMethod.POST, params="delete")
//	public ModelAndView delete(Sponsorship Sponsorship, BindingResult binding){
//		ModelAndView res;
//		
//		try{
//			SponsorshipService.delete(Sponsorship);
//			res = new ModelAndView("redict:list.do");
//		} catch(Throwable oops){
//			res = createEditModelAndView(Sponsorship, "Sponsorship.commit.error");
//		}
//		
//		return res;
//	}
	
	protected ModelAndView createEditModelAndView(Sponsorship Sponsorship){
		ModelAndView res;
		
		res = createEditModelAndView(Sponsorship,null);
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(Sponsorship Sponsorship, String messageCode){
		ModelAndView res;

		
		res = new ModelAndView("Sponsorship/edit");
		res.addObject("Sponsorship",Sponsorship);
		res.addObject("message",messageCode);		
		
		return res;
	}
	
}