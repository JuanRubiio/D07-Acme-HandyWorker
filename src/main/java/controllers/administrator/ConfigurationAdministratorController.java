
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

import services.ConfigurationService;
import controllers.AbstractController;
import domain.Configuration;

@Controller
@RequestMapping("/configuration/administrator")
public class ConfigurationAdministratorController extends AbstractController {

	@Autowired
	private ConfigurationService	configurationService;


	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show() {
		final ModelAndView res = new ModelAndView("configuration/show");
		final Collection<Configuration> configuration = this.configurationService.findAll();

		res.addObject("configuration", configuration);

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		final ModelAndView res;
		final Configuration configuration = this.configurationService.findAll().iterator().next();
		Assert.notNull(configuration);

		res = this.createEditModelAndView(configuration);

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Configuration configuration, final BindingResult result) {
		ModelAndView res;
		if (result.hasErrors())
			res = this.createEditModelAndView(configuration);
		else
			try {
				this.configurationService.save(configuration);
				res = new ModelAndView("redirect:/#");
			} catch (final Throwable oops) {
				res = this.createEditModelAndView(configuration, "configuration.commit.error");
			}
		return res;
	}

	private ModelAndView createEditModelAndView(final Configuration configuration) {
		ModelAndView result;

		result = this.createEditModelAndView(configuration, null);
		return result;
	}

	private ModelAndView createEditModelAndView(final Configuration configuration, final String messageCode) {
		ModelAndView result;

		result = new ModelAndView("configuration/edit");
		result.addObject("configuration", configuration);
		result.addObject("message", messageCode);
		return null;
	}

}
