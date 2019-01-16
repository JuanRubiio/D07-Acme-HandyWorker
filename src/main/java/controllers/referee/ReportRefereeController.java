
package controllers.referee;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ReportService;
import controllers.AbstractController;
import domain.Report;

@Controller
@RequestMapping("/report/referee")
public class ReportRefereeController extends AbstractController {

	@Autowired
	private ReportService	reportService;


	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(@RequestParam final int reportId) {
		ModelAndView res;
		Report report;

		report = this.reportService.findOne(reportId);

		res = this.createEditModelAndView(report);

		return res;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create(@RequestParam final Integer complaintId) {
		ModelAndView res;
		final Report report;
		//hay q pasarle la queja lo qe nose es como
		report = this.reportService.create(complaintId);

		res = this.createEditModelAndView(report);

		return res;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView result;
		Collection<Report> reports;

		reports = this.reportService.findAll();

		result = new ModelAndView("report/list");
		result.addObject("reports", reports);
		result.addObject("requestURI", "report/referee/list.do");
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final int reportId) {
		ModelAndView result;
		Report report;
		report = this.reportService.findOne(reportId);
		Assert.notNull(report);
		result = this.createEditModelAndView(report);
		return result;
	}

	//save
	//borrar

	protected ModelAndView createEditModelAndView(final Report report, final String messageCode) {
		ModelAndView result;
		result = new ModelAndView("report/edit");
		result.addObject("report", report);

		result.addObject("message", messageCode);
		return result;
	}

	protected ModelAndView createEditModelAndView(final Report report) {
		ModelAndView result;
		result = this.createEditModelAndView(report, null);
		return result;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "delete")
	public ModelAndView delete(final Report report, final BindingResult binding) {
		ModelAndView res;

		try {
			this.reportService.delete(report);
			res = new ModelAndView("redict:list.do");
		} catch (final Throwable oops) {
			res = this.createEditModelAndView(report, "report.commit.error");
		}

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Report report, final BindingResult binding) {
		ModelAndView res;

		if (binding.hasErrors())
			res = this.createEditModelAndView(report);
		else
			try {
				this.reportService.save(report);
				res = new ModelAndView("redict:list.do");
			} catch (final Throwable oops) {
				res = this.createEditModelAndView(report, "report.commit.error");
			}

		return res;
	}
}
