
package controllers.administrator;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.SpamService;
import controllers.AbstractController;
import domain.Spam;

@Controller
@RequestMapping("/spam/administrator")
public class SpamAdministratorController extends AbstractController {

	@Autowired
	private SpamService	spamService;


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView show() {
		final ModelAndView res = new ModelAndView("spam/list");
		final Collection<Spam> spam = this.spamService.findAll();

		res.addObject("spam", spam);

		return res;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView edit() {
		final ModelAndView res;
		final Spam spam = this.spamService.create();
		Assert.notNull(spam);

		res = this.createEditModelAndView(spam);

		return res;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Spam spam, final BindingResult result) {
		ModelAndView res;
		if (result.hasErrors())
			res = this.createEditModelAndView(spam);
		else
			try {
				this.spamService.save(spam);
				res = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				res = this.createEditModelAndView(spam, "spam.commit.error");
			}
		return res;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(@Valid final Spam spam, final BindingResult result) {
		ModelAndView res;
		try {
			this.spamService.delete(spam);
			res = new ModelAndView("redirect:list.do");
		} catch (final Throwable oops) {
			res = this.createEditModelAndView(spam, "spam.commit.error");
		}
		return res;
	}

	private ModelAndView createEditModelAndView(final Spam spam) {
		ModelAndView result;

		result = this.createEditModelAndView(spam, null);
		return result;
	}

	private ModelAndView createEditModelAndView(final Spam spam, final String messageCode) {
		ModelAndView result;

		result = new ModelAndView("spam/edit");
		result.addObject("spam", spam);
		result.addObject("message", messageCode);
		return null;
	}

}
