
package controllers.authenticated;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.SocialProfileService;
import controllers.AbstractController;
import domain.Actor;
import domain.SocialProfile;

@Controller
@RequestMapping("/socialProfile/actor")
public class SocialProfileActorController extends AbstractController {

	@Autowired
	private SocialProfileService	socialProfileService;

	@Autowired
	private ActorService			actorService;


	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show() {
		final ModelAndView res = new ModelAndView("socialProfile/show");
		final Actor actor = this.actorService.getPrincipal();
		final SocialProfile social = this.socialProfileService.getSocialProfileForActor(actor);
		final SocialProfile socialres = this.socialProfileService.create();
		if (social == null)
			res.addObject("socialProfile", socialres);
		else
			res.addObject("socialProfile", social);

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		final ModelAndView res = new ModelAndView("SocialProfile/edit");
		final Actor actor = this.actorService.getPrincipal();
		final SocialProfile social = this.socialProfileService.getSocialProfileForActor(actor);
		final SocialProfile socialres = this.socialProfileService.create();
		if (social == null)
			res.addObject("socialProfile", socialres);
		else
			res.addObject("socialProfile", social);

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final SocialProfile socialProfile, final BindingResult result) {
		ModelAndView res;
		if (result.hasErrors())
			res = this.createEditModelAndView(socialProfile);
		else
			try {
				this.socialProfileService.save(socialProfile);
				res = new ModelAndView("redirect:/#");
			} catch (final Throwable oops) {
				res = this.createEditModelAndView(socialProfile, "SocialProfile.commit.error");
			}
		return res;
	}

	private ModelAndView createEditModelAndView(final SocialProfile socialProfile) {
		ModelAndView result;

		result = this.createEditModelAndView(socialProfile, null);
		return result;
	}

	private ModelAndView createEditModelAndView(final SocialProfile socialProfile, final String messageCode) {
		ModelAndView result;

		result = new ModelAndView("socialProfile/edit");
		result.addObject("socialProfile", socialProfile);
		result.addObject("message", messageCode);
		return null;
	}

}
