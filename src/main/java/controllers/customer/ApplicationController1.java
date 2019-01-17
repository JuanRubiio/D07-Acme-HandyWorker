package controllers.customer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ApplicationService;

import controllers.AbstractController;
import domain.Application;

@Controller
@RequestMapping("/application/customer")
public class ApplicationController1 extends AbstractController{

	@Autowired
	private ApplicationService applicationService;
	
	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int applicationId){
		ModelAndView res;
		Application applications;
		
		applications = this.applicationService.findOne(applicationId);
		Assert.notNull(applications);
		res = createEditModelAndView(applications);
		
		return res;
	}
	
	@RequestMapping(value="/edit",method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid Application application, BindingResult binding){
		ModelAndView res;
		
		if(binding.hasErrors()){
			res = createEditModelAndView(application);
		}else{
			try{
				applicationService.save(application);
				res = new ModelAndView("redict:list.do");
			}catch(Throwable oops){
				res = createEditModelAndView(application, "application.commit.error");
			}
		}
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(Application application){
		ModelAndView res;
		
		res = createEditModelAndView(application,null);
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(Application application, String messageCode){
		ModelAndView res;
		
		//¿DROPDOWN para Status?
		
		res = new ModelAndView("application/edit");
		res.addObject("application",application);
		res.addObject("message",messageCode);		
		
		return res;
	}
	
}
