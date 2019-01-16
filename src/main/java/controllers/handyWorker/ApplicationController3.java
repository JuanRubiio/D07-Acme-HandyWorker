
package controllers.handyWorker;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ApplicationService;
import services.FixUpTaskService;
import controllers.AbstractController;
import domain.Application;
import domain.FixUpTask;

@Controller
@RequestMapping("/application/handyWorker")
public class ApplicationController3 extends AbstractController {

	@Autowired
	private ApplicationService	applicationService;

	@Autowired
	private FixUpTaskService	fixUpTaskService;


	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;
		Application application;
		FixUpTask fixUpTask;

		fixUpTask = this.fixUpTaskService.create();
		application = this.applicationService.create(fixUpTask);

		res = this.createEditModelAndView(application);

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Application application, final BindingResult binding) {
		ModelAndView res;

		if (binding.hasErrors())
			res = this.createEditModelAndView(application);
		else
			try {
				this.applicationService.save(application);
				res = new ModelAndView("redict:list.do");
			} catch (final Throwable oops) {
				res = this.createEditModelAndView(application, "application.commit.error");
			}

		return res;
	}

	protected ModelAndView createEditModelAndView(final Application application) {
		ModelAndView res;

		res = this.createEditModelAndView(application, null);

		return res;
	}

	protected ModelAndView createEditModelAndView(final Application application, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("application/edit");
		res.addObject("application", application);
		res.addObject("message", messageCode);

		return res;
	}

}
