package controllers.customer;

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

import services.FixUpTaskService;

import controllers.AbstractController;
import domain.FixUpTask;

@Controller
@RequestMapping("/fixUpTask/customer")
public class FixUpTaskController extends AbstractController{

	@Autowired
	private FixUpTaskService fixUpTaskService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView res;
		Collection<FixUpTask> fixUpTasks;
		
		fixUpTasks= fixUpTaskService.findAll();
		
		res = new ModelAndView("fixUpTask/list");
		res.addObject("fixUpTask",fixUpTasks);
		res.addObject("requestURI","fixUpTask/customer/list.do");
		
		return res;
	}
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView res;
		FixUpTask fixUpTask;
		
		fixUpTask = this.fixUpTaskService.create();
		
		res = this.createEditModelAndView(fixUpTask);
		
		return res;
	}

	@RequestMapping(value="/edit",method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam int fixUpTaskId){
		ModelAndView res;
		FixUpTask fixUpTask;
		
		fixUpTask = this.fixUpTaskService.findOne(fixUpTaskId);
		Assert.notNull(fixUpTask);
		res = createEditModelAndView(fixUpTask);
		
		return res;
	}

	@RequestMapping(value="/edit",method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid FixUpTask fixUpTask, BindingResult binding){
		ModelAndView res;
		
		if(binding.hasErrors()){
			res = createEditModelAndView(fixUpTask);
		}else{
			try{
				fixUpTaskService.save(fixUpTask);
				res = new ModelAndView("redict:list.do");
			}catch(Throwable oops){
				res = createEditModelAndView(fixUpTask, "fixUpTask.commit.error");
			}
		}
		
		return res;
	}
	
	@RequestMapping(value="/edit",method = RequestMethod.POST, params="delete")
	public ModelAndView delete(FixUpTask fixUpTask, BindingResult binding){
		ModelAndView res;
		
		try{
			fixUpTaskService.delete(fixUpTask);
			res = new ModelAndView("redict:list.do");
		} catch(Throwable oops){
			res = createEditModelAndView(fixUpTask, "fixUpTask.commit.error");
		}
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(FixUpTask fixUpTask){
		ModelAndView res;
		
		res = createEditModelAndView(fixUpTask,null);
		
		return res;
	}
	
	protected ModelAndView createEditModelAndView(FixUpTask fixUpTask, String messageCode){
		ModelAndView res;
		
		res = new ModelAndView("fixUpTask/edit");
		res.addObject("fixUpTask",fixUpTask);
		res.addObject("message",messageCode);		
		
		return res;
	}
	
}
