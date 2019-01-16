
package controllers.authenticated;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.MessageBoxService;
import services.MessageService;
import controllers.AbstractController;
import domain.Actor;
import domain.Message;
import domain.MessageBox;

@Controller
@RequestMapping("/message")
public class MessageActorController extends AbstractController {

	@Autowired
	private ActorService		actorService;

	@Autowired
	private MessageBoxService	messageBoxService;

	@Autowired
	private MessageService		messageService;


	// Creating
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Message mess;
		Collection<Actor> actors;
		Actor actor;

		mess = this.messageService.create();
		actors = this.actorService.findAll();
		actor = this.actorService.getPrincipal();
		actors.remove(actor);

		result = new ModelAndView("message/create");
		result.addObject("message", mess);
		result.addObject("actors", actors);
		return result;
	}

	// Save
	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid @ModelAttribute("message") Message mess, final BindingResult bindingResult) {
		ModelAndView result;
		Collection<Actor> actors;
		Actor actor;

		actors = this.actorService.findAll();
		actor = this.actorService.getPrincipal();
		actors.remove(actor);

		if (bindingResult.hasErrors()) {
			result = new ModelAndView("message/create");
			result.addObject("mess", mess);
			result.addObject("actors", actors);
		} else
			try {
				mess = this.messageService.save(mess);
				result = new ModelAndView("redirect:/messagebox/list.do");
			} catch (final Throwable oops) {
				result = new ModelAndView("message/create");
				result.addObject("message", mess);
				result.addObject("messageerror", "message.commit.error");
				result.addObject("actors", actors);
			}
		return result;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list(@RequestParam final int messageBoxId) {
		ModelAndView result;
		Collection<Message> messages;
		MessageBox messagebox;
		try {
			messagebox = this.messageBoxService.findOne(messageBoxId);

			messages = messagebox.getMessages();

			result = new ModelAndView("message/list");
			result.addObject("messages", messages);
			result.addObject("messagebox", messagebox);
			result.addObject("requestUri", "message/list.do");
		} catch (final Throwable oops) {
			result = new ModelAndView("redirect:/#");
		}
		return result;
	}

	@RequestMapping(value = "/list", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Message message, final BindingResult binding) {
		ModelAndView res;

		try {
			this.messageService.delete(message);
			res = new ModelAndView("redirect:/#");
		} catch (final Throwable oops) {
			System.out.println(oops.getMessage());
			res = new ModelAndView("message/list");
			res.addObject("messages", message);
			res.addObject("requestUri", "message/list.do");

		}

		return res;
	}

	@RequestMapping(value = "/display", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam final int messageId) {

		final ModelAndView res = new ModelAndView("message/display");
		final Message message = this.messageService.findOne(messageId);
		res.addObject("message", message);

		return res;
	}

	// Creating
	@RequestMapping(value = "/administrator/broadcast", method = RequestMethod.GET)
	public ModelAndView createBroadcast() {
		ModelAndView result;
		Message mess;

		mess = this.messageService.create();

		result = new ModelAndView("message/broadcast");
		result.addObject("message", mess);
		return result;
	}

	// Save
	@RequestMapping(value = "/broadcast", method = RequestMethod.POST, params = "save")
	public ModelAndView saveBroadcast(@Valid @ModelAttribute("message") Message mess, final BindingResult bindingResult) {
		ModelAndView result;

		if (bindingResult.hasErrors()) {
			result = new ModelAndView("message/broadcast");
			result.addObject("message", mess);
		} else
			try {
				mess = this.messageService.save(mess);
				result = new ModelAndView("redirect:/messagebox/list.do");
			} catch (final Throwable oops) {
				result = new ModelAndView("message/create");
				result.addObject("message", mess);
				result.addObject("messageerror", "message.commit.error");
			}
		return result;
	}

	// Delete
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView sendToTrashFolder(@RequestParam final int messageId) {
		ModelAndView result;
		Message message;
		try {
			message = this.messageService.findOne(messageId);
			Assert.notNull(message);

			this.messageService.delete(messageId);

			result = new ModelAndView("redirect:/message/list.do");
		} catch (final Throwable oops) {
			result = new ModelAndView("redirect:/#");
		}
		return result;
	}

	// Delete
	@RequestMapping(value = "/move", method = RequestMethod.GET)
	public ModelAndView move(@RequestParam final int messageId) {
		ModelAndView result;
		Message message;
		try {
			message = this.messageService.findOne(messageId);
			Assert.notNull(message);

			this.messageService.delete(messageId);

			result = new ModelAndView("redirect:/message/list.do");
		} catch (final Throwable oops) {
			result = new ModelAndView("redirect:/#");
		}
		return result;
	}

}
