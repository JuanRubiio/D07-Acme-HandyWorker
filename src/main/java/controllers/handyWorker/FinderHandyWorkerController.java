
package controllers.handyWorker;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.FinderService;
import controllers.AbstractController;
import domain.Finder;

public class FinderHandyWorkerController extends AbstractController {

	@Autowired
	private FinderService	finderService;


	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam final int finderId) {
		ModelAndView res;
		Finder finder;

		finder = this.finderService.findOne(finderId);

		res = this.createEditModelAndView(finder);

		return res;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView res;
		final Finder finder;
		//hay q pasarle la queja lo qe nose es como
		finder = this.finderService.create();

		res = this.createEditModelAndView(finder);

		return res;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Finder> finders;

		finders = this.finderService.findAll();

		result = new ModelAndView("finder/list");
		result.addObject("finders", finders);
		result.addObject("requestURI", "finder/handyWorker/list.do");
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int finderId) {
		ModelAndView result;
		Finder finder;
		finder = this.finderService.findOne(finderId);
		Assert.notNull(finder);
		result = this.createEditModelAndView(finder);
		return result;
	}

	//save
	//borrar

	protected ModelAndView createEditModelAndView(final Finder finder, final String messageCode) {
		ModelAndView result;
		result = new ModelAndView("finder/edit");
		result.addObject("finder", finder);

		result.addObject("message", messageCode);
		return result;
	}

	protected ModelAndView createEditModelAndView(final Finder finder) {
		ModelAndView result;
		result = this.createEditModelAndView(finder, null);
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Finder finder, final BindingResult binding) {
		ModelAndView res;

		if (binding.hasErrors())
			res = this.createEditModelAndView(finder);
		else
			try {
				this.finderService.save(finder);
				res = new ModelAndView("redict:list.do");
			} catch (final Throwable oops) {
				res = this.createEditModelAndView(finder, "finder.commit.error");
			}
		return res;
	}
}
