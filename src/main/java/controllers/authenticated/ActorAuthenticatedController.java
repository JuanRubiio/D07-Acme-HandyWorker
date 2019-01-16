
package controllers.authenticated;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import controllers.AbstractController;
import domain.Actor;

@Controller
@RequestMapping("/actor")
public class ActorAuthenticatedController extends AbstractController {

	@Autowired
	private ActorService	actorService;


	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView res;
		Actor actor;
		try {
			actor = this.actorService.getPrincipal();
			res = new ModelAndView("actor/edit");
			res.addObject("actor", actor);
		} catch (final Throwable oops) {
			res = new ModelAndView("redirect:/#");
		}

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Actor actor, final BindingResult binding) {
		ModelAndView res;

		if (binding.hasErrors()) {
			res = new ModelAndView("actor/edit");
			res.addObject("actor", actor);
		} else
			try {
				this.actorService.save(actor);
				res = new ModelAndView("redirect:/#");
			} catch (final Throwable oops) {
				res = new ModelAndView("actor/edit");
				res.addObject("actor", actor);
				res.addObject("message", "actor.commit.error");
			}

		return res;
	}

}
