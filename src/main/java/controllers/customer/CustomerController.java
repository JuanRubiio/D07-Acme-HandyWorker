
package controllers.customer;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import controllers.AbstractController;

import security.UserAccountService;
import services.CustomerService;
import domain.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController extends AbstractController {

	@Autowired
	private CustomerService		customerService;
	@Autowired
	private UserAccountService	userAccountService;


	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView display() {
		ModelAndView result;

		final Customer customer = this.customerService.findByPrincipal();
		result = new ModelAndView("customer/show");
		result.addObject("customer", customer);

		return result;

	}

	//	@RequestMapping(value = "/create", method = RequestMethod.GET)
	//	public ModelAndView create() {
	//		ModelAndView result;
	//
	//		//	final Customer c = this.customerService.create();
	//		final UserAccount ua = this.userAccountService.createForCustomer();
	//		c.setUserAccount(ua);
	//
	//		result = this.createEditModelAndView(c);
	//
	//		return result;
	//
	//	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit() {
		ModelAndView result;

		final Customer c = this.customerService.findByPrincipal();

		result = this.createEditModelAndView(c);

		return result;

	}

	protected ModelAndView createEditModelAndView(final Customer c) {
		final ModelAndView result = this.createEditModelAndView(c, null);

		return result;
	}

	protected ModelAndView createEditModelAndView(final Customer c, final String message) {
		ModelAndView result;

		result = new ModelAndView("customer/create");
		result.addObject("customer", c);
		result.addObject("message", message);

		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Customer c, final BindingResult binding) {
		ModelAndView result;
		final Md5PasswordEncoder encoder = new Md5PasswordEncoder();
		if (binding.hasErrors()) {
			System.out.println(binding.getAllErrors());
			result = this.createEditModelAndView(c);
		} else
			try {
				c.getUserAccount().setPassword(encoder.encodePassword(c.getUserAccount().getPassword(), null));
				final Customer cs = this.customerService.save(c);
				result = new ModelAndView("security/login");
				result.addObject("credentials", cs.getUserAccount());
				return result;
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(c, "customer.commit.error");
			}

		return result;
	}

}
