
package controllers.authenticated;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.MessageBoxService;
import controllers.AbstractController;
import domain.MessageBox;

@Controller
@RequestMapping("/messagebox")
public class MessageBoxActorController extends AbstractController {

	@Autowired
	private ActorService		actorService;

	@Autowired
	private MessageBoxService	messageBoxService;


	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;

		Collection<MessageBox> messagebox;
		try {
			messagebox = this.messageBoxService.findMessageBoxsByPrincipal();

			result = new ModelAndView("messagebox/list");
			result.addObject("messageboxes", messagebox);
			result.addObject("requestUri", "messagebox/list.do");
		} catch (final Throwable oops) {
			result = new ModelAndView("redirect:/#");
		}
		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		final MessageBox messagebox = this.messageBoxService.create();

		result = new ModelAndView("messagebox/edit");
		result.addObject("messagebox", messagebox);

		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView create(@Valid @ModelAttribute("messageBox") final MessageBox messagebox, final BindingResult bindingResult) {
		ModelAndView result;

		if (bindingResult.hasErrors()) {
			result = new ModelAndView("messagebox/edit");
			result.addObject("messagebox", messagebox);
		} else
			try {
				this.messageBoxService.save(messagebox);
				result = new ModelAndView("redirect:/messagebox/list.do");
			} catch (final Throwable oops) {
				result = new ModelAndView("messagebox/edit");
				result.addObject("messagebox", messagebox);
				result.addObject("messageerror", "error");
			}
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int id) {
		ModelAndView result;
		final MessageBox messagebox = this.messageBoxService.findOne(id);

		result = new ModelAndView("messagebox/edit");
		result.addObject("messagebox", messagebox);

		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute("messageBox") final MessageBox messagebox, final BindingResult bindingResult) {
		ModelAndView result;

		if (bindingResult.hasErrors()) {
			result = new ModelAndView("messagebox/edit");
			result.addObject("messagebox", messagebox);
		} else
			try {
				this.messageBoxService.save(messagebox);
				result = new ModelAndView("redirect:/messagebox/list.do");
			} catch (final Throwable oops) {
				result = new ModelAndView("messagebox/edit");
				result.addObject("messagebox", messagebox);
				result.addObject("messageerror", "error");
			}
		return result;
	}

}
