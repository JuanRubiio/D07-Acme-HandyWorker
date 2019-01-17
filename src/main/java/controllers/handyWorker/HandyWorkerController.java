
package controllers.handyWorker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.HandyWorkerService;
import controllers.AbstractController;
import domain.HandyWorker;

@Controller
@RequestMapping("/actor/handyWorker")
public class HandyWorkerController extends AbstractController {

	@Autowired
	private HandyWorkerService	handyWorkerService;


	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int handyWorkerId) {
		ModelAndView res;

		HandyWorker handyWorkers;

		handyWorkers = this.handyWorkerService.findOne(handyWorkerId);
		Assert.notNull(handyWorkers);
		res = this.createEditModelAndView(handyWorkers);
		return res;
	}

	protected ModelAndView createEditModelAndView(final HandyWorker handyWorker) {
		ModelAndView res;

		res = this.createEditModelAndView(handyWorker, null);

		return res;
	}

	protected ModelAndView createEditModelAndView(final HandyWorker handyWorker, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("handyWorker/edit");
		res.addObject("handyWorker", handyWorker);
		res.addObject("message", messageCode);

		return res;
	}

}
