
package controllers.handyWorker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.CustomerService;
import controllers.AbstractController;
import domain.Customer;

@Controller
@RequestMapping("/customer/handyWorker")
public class CustomerFixUpTaskHandyWorkerController extends AbstractController {

	@Autowired
	private CustomerService	customerService;


	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam final int customerId) {
		final ModelAndView res;
		Customer customer;

		customer = this.customerService.findOne(customerId);
		Assert.notNull(customer);
		res = this.createEditModelAndView(customer);
		return res;
	}

	protected ModelAndView createEditModelAndView(final Customer customer) {
		ModelAndView res;

		res = this.createEditModelAndView(customer, null);

		return res;
	}

	protected ModelAndView createEditModelAndView(final Customer customer, final String messageCode) {
		ModelAndView res;

		//¿DROPDOWN para Status?

		res = new ModelAndView("customer/show");
		res.addObject("customer", customer);
		res.addObject("message", messageCode);

		return res;
	}

}
