
package controllers.customer;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ComplaintService;
import services.CustomerService;
import services.FixUpTaskService;
import services.RefereeService;
import services.ReportService;
import controllers.AbstractController;
import domain.Complaint;
import domain.FixUpTask;
import domain.Referee;
import domain.Report;

@Controller
@RequestMapping("/complaint")
public class ComplaintController extends AbstractController {

	@Autowired
	private CustomerService		customerService;

	@Autowired
	private ComplaintService	complaintService;
	@Autowired
	private RefereeService		refereeService;

	@Autowired
	private ReportService		reportService;
	@Autowired
	private FixUpTaskService	fixUpTaskService;


	@RequestMapping(value = "/customer/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		final Collection<Complaint> complaints = this.complaintService.findByCustomer();
		result = new ModelAndView("complaint/list");
		result.addObject("requestURI", "complaint/list.do");
		result.addObject("complaints", complaints);
		return result;
	}

	@RequestMapping(value = "/customer/show", method = RequestMethod.GET)
	public ModelAndView display(final int complaintId) {
		ModelAndView result;
		final Complaint complaint = this.complaintService.findOne(complaintId);
		final FixUpTask referredFixUpTask = this.fixUpTaskService.findByComplaint(complaintId);
		result = new ModelAndView("complaint/show");
		result.addObject("requestURI", "complaint/customer/show.do");
		result.addObject("complaint", complaint);
		result.addObject("referredFixUpTask", referredFixUpTask);
		return result;
	}

	@RequestMapping(value = "/customer/create", method = RequestMethod.GET)
	public ModelAndView create(final int fixUpTaskId) {
		ModelAndView result;
		final Complaint c = this.complaintService.create();
		result = this.createEditModelAndView(c);
		result.addObject(fixUpTaskId);
		result.addObject("action", "complaint/customer/create.do?fixUpTaskId=" + fixUpTaskId);
		return result;

	}

	protected ModelAndView createEditModelAndView(final Complaint c) {
		final ModelAndView result = this.createEditModelAndView(c, null);
		return result;
	}

	protected ModelAndView createEditModelAndView(final Complaint c, final String message) {
		ModelAndView result;
		result = new ModelAndView("complaint/create");
		result.addObject("complaint", c);
		result.addObject("message", message);

		return result;
	}

	@RequestMapping(value = "/customer/create", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Complaint c, @RequestParam final Integer fixUpTaskId, final BindingResult binding) {
		ModelAndView result;
		if (binding.hasErrors()) {
			System.out.println(binding.getAllErrors());
			result = this.createEditModelAndView(c);
		} else
			try {
				final FixUpTask fut = this.fixUpTaskService.findOne(fixUpTaskId);
				final Collection<Complaint> complaints = fut.getComplaints();
				complaints.add(c);
				fut.setComplaints(complaints);
				this.fixUpTaskService.save(fut);

				result = new ModelAndView("redirect:list.do");
			} catch (final Throwable oops) {
				result = this.createEditModelAndView(c, "complaint.commit.error");
			}

		return result;
	}

	@RequestMapping(value = "/referee/listNotAssigned", method = RequestMethod.GET)
	public ModelAndView listRefereeNot() {
		ModelAndView result;
		//	final Collection<Complaint> complaints = ComplaintService.findAll();
		final Complaint complaint = this.complaintService.obtieneQuejaSinReferee();
		//	final Collection<Complaint> notAssigned = new ArrayList<Complaint>();
		//	for (final Complaint c : complaints)
		//		if (c.getReport() == null)
		//			notAssigned.add(c);
		result = new ModelAndView("complaint/list");
		result.addObject("requestURI", "complaint/referee/listNotAssigned.do");
		result.addObject("complaints", complaint);
		return result;
	}

	/*
	 * @RequestMapping(value = "/referee/listAssigned", method = RequestMethod.GET)
	 * public ModelAndView listReferee() {
	 * ModelAndView result;
	 * final Collection<Complaint> complaints = ComplaintService.findAll();
	 * final Collection<Complaint> assigned = new ArrayList<Complaint>();
	 * final Referee r = this.refereeService.findByPrincipal();
	 * r.getReports();
	 * result = new ModelAndView("complaint/list");
	 * result.addObject("requestURI", "complaint/referee/listNotAssigned.do");
	 * result.addObject("complaints", assigned);
	 * return result;
	 * }
	 */

	@RequestMapping(value = "/referee/listAssigned", method = RequestMethod.GET)
	public ModelAndView listReferee() {
		ModelAndView result;
		final Collection<Complaint> assigned = this.complaintService.findAll();
		final Referee r = this.refereeService.findByPrincipal();
		r.getReports();
		result = new ModelAndView("complaint/list");
		result.addObject("requestURI", "complaint/referee/listNotAssigned.do");
		result.addObject("complaints", assigned);
		return result;
	}

	@RequestMapping(value = "/referee/assign", method = RequestMethod.GET)
	public ModelAndView assign(@RequestParam final int reportId) {
		ModelAndView result;
		final Report c = this.reportService.findOne(reportId);
		final Referee r = this.refereeService.findByPrincipal();
		r.getReports().add(c);
		this.refereeService.save(r);
		result = new ModelAndView("complaint/list");
		result.addObject("requestURI", "referee/complaint/listNotAssigned.do");
		result.addObject("complaints", r.getReports());
		return result;
	}

}
