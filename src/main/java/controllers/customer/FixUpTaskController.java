package controllers.customer;

import java.util.ArrayList;
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
import services.CategoryService;
import services.FixUpTaskService;
import services.WarrantyService;

import controllers.AbstractController;
import domain.Actor;
import domain.Category;
import domain.Customer;
import domain.FixUpTask;
import domain.Warranty;


@Controller
@RequestMapping("/fixUpTask/customer")
public class FixUpTaskController extends AbstractController{

	@Autowired
	private FixUpTaskService fixUpTaskService;
	
	@Autowired
	private ActorService actorService;
	
	@Autowired
	private WarrantyService warrantyService;
	
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping(value="/list",method = RequestMethod.GET)
	public ModelAndView list(){
		ModelAndView res;
		Collection<FixUpTask> fixUpTasks;
		
		//Si falla, probar:
		//Actor logueado = this.actorService.getPrincipal();
		fixUpTasks = fixUpTaskService.findAll();
		
		//borrar fixUpTask
		
		res = new ModelAndView("fixUpTask/listcustomer");
		res.addObject("fixUpTask",fixUpTasks);
		res.addObject("requestURI","fixUpTask/customer/list.do");
		
		return res;
	}
	
	@RequestMapping(value="/create",method = RequestMethod.GET)
	public ModelAndView create(){
		ModelAndView res;
		FixUpTask fixUpTask;
		
		Collection<Category> categories = new ArrayList<>();
		Collection<Warranty> warranties = new ArrayList<>();

		warranties = this.warrantyService.findAll();
		categories = this.categoryService.findAll();
		
		//Si falla, probar:
		Actor logueado = this.actorService.getPrincipal();
		Customer c = (Customer)logueado;
		
		fixUpTask = this.fixUpTaskService.create();
		fixUpTask.setCustomer(c);
		res = this.createEditModelAndView(fixUpTask);
		
		res.addObject("categories", categories);
		res.addObject("warranties", warranties);
		
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

	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam final int fixUpTaskId) {
			ModelAndView result;
			FixUpTask f;
			f = this.fixUpTaskService.findOne(fixUpTaskId);
			result = new ModelAndView("fixUpTask/showcustomer");
			result.addObject("fixUpTask", f);

			return result;
		}
	
	@RequestMapping(value="/delete",method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam final int fixUpTaskId){
		ModelAndView res;
		FixUpTask fixUpTask;
		fixUpTask = this.fixUpTaskService.findOne(fixUpTaskId);
		Assert.notNull(fixUpTask);
		fixUpTaskService.delete(fixUpTask);
		res = new ModelAndView("redirect:list.do");
		return res;
	}
	
	
	@RequestMapping(value="/save",method = RequestMethod.POST, params="save")
	public ModelAndView save(@Valid FixUpTask fixUpTask, BindingResult binding){
		ModelAndView res;
		
		Collection<Category> categories = new ArrayList<>();
		Collection<Warranty> warranties = new ArrayList<>();

		warranties = this.warrantyService.findAll();
		categories = this.categoryService.findAll();
		
		if(binding.hasErrors()){
			System.out.println(binding.getAllErrors());
			res = createEditModelAndView(fixUpTask);
			res.addObject("categories", categories);
			res.addObject("warranties", warranties);
			
		}else{
			try{
				fixUpTaskService.save(fixUpTask);
				res = new ModelAndView("redirect:list.do");
			}catch(Throwable oops){
				res = createEditModelAndView(fixUpTask, "fixUpTask.commit.error");
				res.addObject("categories", categories);
				res.addObject("warranties", warranties);
				
			}
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
