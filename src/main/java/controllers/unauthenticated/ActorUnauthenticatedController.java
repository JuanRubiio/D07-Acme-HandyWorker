
package controllers.unauthenticated;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.CustomerService;
import controllers.AbstractController;
import domain.Actor;

@Controller
@RequestMapping("/actor")
public class ActorUnauthenticatedController extends AbstractController {

	@Autowired
	private ActorService	actorService;

	@Autowired
	private CustomerService	customerService;


	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView res;
		Actor actor;
		final List<String> role = new ArrayList<>();
		role.add("Customer");
		role.add("Handy Worker");
		try {
			actor = this.customerService.create();
			res = new ModelAndView("actor/register");
			res.addObject("actor", actor);
			res.addObject("role", role);
		} catch (final Throwable oops) {
			res = new ModelAndView("redirect:/#");
		}

		return res;
	}

	//TODO darle una vuelta a esto, ver como registrarte como handy worker o customer
	@RequestMapping(value = "/register", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Actor actor, final String role, final BindingResult binding) {
		ModelAndView res;

		if (binding.hasErrors()) {
			res = new ModelAndView("actor/edit");
			res.addObject("actor", actor);
		} else
			try {
				if (role.equals("Customer"))
					this.actorService.save(actor);
				else if (role.equals("Handy Worker")) {

				}
				res = new ModelAndView("redirect:/#");
			} catch (final Throwable oops) {
				res = new ModelAndView("actor/edit");
				res.addObject("actor", actor);
				res.addObject("message", "actor.commit.error");
			}

		return res;
	}

}
