
package controllers.handyWorker;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.ActorService;
import services.CurriculumService;
import services.EducationalRecordService;
import services.EndorserRecordService;
import services.HandyWorkerService;
import services.MiscellaneousRecordService;
import services.PersonalRecordService;
import services.ProfessionalRecordService;
import controllers.AbstractController;
import domain.Actor;
import domain.Curriculum;
import domain.EducationalRecord;
import domain.EndorserRecord;
import domain.MiscellaneousRecord;
import domain.PersonalRecord;
import domain.ProfessionalRecord;

@Controller
@RequestMapping("curriculum/handyworker")
public class CurriculumController extends AbstractController {

	//Services

	@Autowired
	private CurriculumService			curriculumService;

	@Autowired
	private PersonalRecordService		personalRecordService;

	@Autowired
	private EndorserRecordService		endorserRecordService;

	@Autowired
	private EducationalRecordService	educationalRecordService;

	@Autowired
	private ProfessionalRecordService	professionalRecordService;

	@Autowired
	private MiscellaneousRecordService	miscellaneousRecordService;

	@Autowired
	private ActorService				actorService;

	@Autowired
	private HandyWorkerService			handyWorkerService;


	// Constructors ------------------------------------------------------------------

	public CurriculumController() {
		super();
	}

	//Curriculum----
	//create----------------------------------------------------------------------------

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView res;
		Curriculum c = null;

		//Actor logged = actorService.getByUserAccountId(LoginService.getPrincipal());
		final Actor logged = this.actorService.getPrincipal();

		c = this.handyWorkerService.findOne(logged.getId()).getCurriculum();

		//		for (final Curriculum cu : this.curriculumService.findAll())
		//			if (cu.getHandyWorker().equals(logged))
		//				c = cu;

		res = new ModelAndView("curriculum/create");
		res.addObject("curriculum", c);

		return res;
	}
	//Delete
	@RequestMapping(value = "/deleteCurriculum", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam final int curriculumId) {
		ModelAndView res;
		final Curriculum c = this.curriculumService.findOne(curriculumId);

		try {
			this.curriculumService.delete(c);
			res = new ModelAndView("redirect:create.do");
		} catch (final Throwable e) {
			res = new ModelAndView("curriculum/create");
			res.addObject("curriculum", c);
			res.addObject("message", "message.commit.error");
		}
		return res;
	}

	//PERSONAL RECORD ----------------------------------------------------------------

	//Create--------------------------------------------------------------------------
	@RequestMapping(value = "/createPersonalRecord", method = RequestMethod.GET)
	public ModelAndView create() {
		// its the same as creating a personal record, saving it, and assigning it to the curricula later on,
		// then creating a curricula, asssigning the PR to it then saving the curricula

		ModelAndView res;
		final PersonalRecord pr = this.personalRecordService.create();

		res = this.createEditPersonalRecordModelAndView(pr);
		return res;
	}

	//Edit-----------------------------------------------------------------------------
	@RequestMapping(value = "/editPersonalRecord", method = RequestMethod.GET)
	public ModelAndView editPR(@RequestParam final int personalRecordId) {

		ModelAndView res;
		final PersonalRecord pr = this.personalRecordService.findOne(personalRecordId);

		res = this.createEditPersonalRecordModelAndView(pr);
		return res;
	}

	//Save-----------------------------------------------------------------------------
	@RequestMapping(value = "/editPersonalRecord", method = RequestMethod.POST, params = "save")
	public ModelAndView savePersonalRecord(@Valid final PersonalRecord pr, final BindingResult binding) {
		// we check if the logged in actor has a curricula, if not create one and bind the PR to it (save the record first)
		ModelAndView res;
		System.out.println(binding);
		System.out.println(pr.getName() + " " + pr.getEmail() + pr.getLinkedinIdProfile());

		if (binding.hasErrors())
			res = this.createEditPersonalRecordModelAndView(pr);
		else
			try {
				System.out.println("tries to save the personal record / create curriculum");
				this.personalRecordService.save(pr);// this already checks for the existance of a curricula. and if it doesnt exist it does it all.
				res = new ModelAndView("redirect:create.do");
			} catch (final Throwable e) {
				res = this.createEditPersonalRecordModelAndView(pr, "message.commit.error");
				System.out.println(e);
			}
		return res;
	}

	//ENDORSER RECORD ----------------------------------------------------------------

	//Create--------------------------------------------------------------------------
	@RequestMapping(value = "/createEndorserRecord", method = RequestMethod.GET)
	public ModelAndView createEndorser() {

		ModelAndView res;
		final EndorserRecord er = this.endorserRecordService.create();

		res = this.createEditEndorserRecordModelAndView(er);
		return res;
	}

	//Edit-----------------------------------------------------------------------------
	@RequestMapping(value = "/editEndorserRecord", method = RequestMethod.GET)
	public ModelAndView editEndorserRecord(@RequestParam final int endorserRecordId) {

		ModelAndView res;
		final EndorserRecord er = this.endorserRecordService.findOne(endorserRecordId);

		res = this.createEditEndorserRecordModelAndView(er);
		return res;
	}

	//Save-----------------------------------------------------------------------------
	@RequestMapping(value = "/editEndorserRecord", method = RequestMethod.POST, params = "save")
	public ModelAndView saveEndorserRecord(@Valid final EndorserRecord er, final BindingResult binding) {
		ModelAndView res;
		System.out.println(binding);
		System.out.println(er.getName() + er.getEmail());

		if (binding.hasErrors())
			res = this.createEditEndorserRecordModelAndView(er);
		else
			try {
				this.endorserRecordService.save(er);
				res = new ModelAndView("redirect:create.do");
			} catch (final Throwable e) {
				res = this.createEditEndorserRecordModelAndView(er, "message.commit.error");
				System.out.println(e);
			}
		return res;
	}

	//Delete-----------------------------------------------------------------------------
	@RequestMapping(value = "/deleteEndorserRecord", method = RequestMethod.GET)
	public ModelAndView deleteEndorserRecord(@RequestParam final int endorserRecordId) {
		ModelAndView res;
		this.endorserRecordService.delete(this.endorserRecordService.findOne(endorserRecordId));

		res = new ModelAndView("redirect:create.do");
		return res;
	}

	//EDUCATION RECORD ----------------------------------------------------------------

	// Create--------------------------------------------------------------------------
	@RequestMapping(value = "/createEducationRecord", method = RequestMethod.GET)
	public ModelAndView createEducation() {

		ModelAndView res;
		final EducationalRecord er = this.educationalRecordService.create();

		res = this.createEditEducationRecordModelAndView(er);
		return res;
	}

	// Edit-----------------------------------------------------------------------------
	@RequestMapping(value = "/editEducationRecord", method = RequestMethod.GET)
	public ModelAndView editEducationRecord(@RequestParam final int educationRecordId) {

		ModelAndView res;
		final EducationalRecord er = this.educationalRecordService.findOne(educationRecordId);

		res = this.createEditEducationRecordModelAndView(er);
		return res;
	}

	// Save-----------------------------------------------------------------------------
	@RequestMapping(value = "/editEducationRecord", method = RequestMethod.POST, params = "save")
	public ModelAndView saveEducationRecord(@Valid final EducationalRecord er, final BindingResult binding) {
		ModelAndView res;
		System.out.println(binding);

		if (binding.hasErrors())
			res = this.createEditEducationRecordModelAndView(er);
		else
			try {
				this.educationalRecordService.save(er);
				res = new ModelAndView("redirect:create.do");
			} catch (final Throwable e) {
				res = this.createEditEducationRecordModelAndView(er, "message.commit.error");
				System.out.println(e);
			}
		return res;
	}

	// Delete-----------------------------------------------------------------------------
	@RequestMapping(value = "/deleteEducationRecord", method = RequestMethod.GET)
	public ModelAndView deleteEducationRecord(@RequestParam final int educationRecordId) {
		ModelAndView res;
		this.educationalRecordService.delete(this.educationalRecordService.findOne(educationRecordId));

		res = new ModelAndView("redirect:create.do");
		return res;
	}

	//PROFESSIONAL RECORD ----------------------------------------------------------------

	// Create--------------------------------------------------------------------------
	@RequestMapping(value = "/createProfessionalRecord", method = RequestMethod.GET)
	public ModelAndView createProfessional() {

		ModelAndView res;
		final ProfessionalRecord pr = this.professionalRecordService.create();

		res = this.createEditProfessionalRecordModelAndView(pr);
		return res;
	}

	// Edit-----------------------------------------------------------------------------
	@RequestMapping(value = "/editProfessionalRecord", method = RequestMethod.GET)
	public ModelAndView editProfessionalRecord(@RequestParam final int professionalRecordId) {

		ModelAndView res;
		final ProfessionalRecord pr = this.professionalRecordService.findOne(professionalRecordId);

		res = this.createEditProfessionalRecordModelAndView(pr);
		return res;
	}

	// Save-----------------------------------------------------------------------------
	@RequestMapping(value = "/editProfessionalRecord", method = RequestMethod.POST, params = "save")
	public ModelAndView saveProfessionalRecord(@Valid final ProfessionalRecord pr, final BindingResult binding) {
		ModelAndView res;
		System.out.println(binding);

		if (binding.hasErrors())
			res = this.createEditProfessionalRecordModelAndView(pr);
		else
			try {
				this.professionalRecordService.save(pr);
				res = new ModelAndView("redirect:create.do");
			} catch (final Throwable e) {
				res = this.createEditProfessionalRecordModelAndView(pr, "message.commit.error");
				System.out.println(e);
			}
		return res;
	}

	// Delete-----------------------------------------------------------------------------
	@RequestMapping(value = "/deleteProfessionalRecord", method = RequestMethod.GET)
	public ModelAndView deleteProfessionalRecord(@RequestParam final int professionalRecordId) {
		ModelAndView res;
		this.educationalRecordService.delete(this.educationalRecordService.findOne(professionalRecordId));

		res = new ModelAndView("redirect:create.do");
		return res;
	}
	//MISCELLANEOUS RECORD ----------------------------------------------------------------

	// Create--------------------------------------------------------------------------
	@RequestMapping(value = "/createMiscellaneousRecord", method = RequestMethod.GET)
	public ModelAndView createMiscellaneousRecord() {

		ModelAndView res;
		final MiscellaneousRecord mr = this.miscellaneousRecordService.create();

		res = this.createEditMiscellaneousRecordModelAndView(mr);
		return res;
	}

	// Edit-----------------------------------------------------------------------------
	@RequestMapping(value = "/editMiscellaneousRecord", method = RequestMethod.GET)
	public ModelAndView editMiscellaneousRecord(@RequestParam final int miscellaneousRecordId) {

		ModelAndView res;
		final MiscellaneousRecord mr = this.miscellaneousRecordService.findOne(miscellaneousRecordId);

		res = this.createEditMiscellaneousRecordModelAndView(mr);
		return res;
	}

	// Save-----------------------------------------------------------------------------
	@RequestMapping(value = "/editMiscellaneousRecord", method = RequestMethod.POST, params = "save")
	public ModelAndView saveMiscellaneousRecord(@Valid final MiscellaneousRecord mr, final BindingResult binding) {
		ModelAndView res;
		System.out.println(binding);

		if (binding.hasErrors())
			res = this.createEditMiscellaneousRecordModelAndView(mr);
		else
			try {
				this.miscellaneousRecordService.save(mr);
				res = new ModelAndView("redirect:create.do");
			} catch (final Throwable e) {
				res = this.createEditMiscellaneousRecordModelAndView(mr, "message.commit.error");
				System.out.println(e);
			}
		return res;
	}

	// Delete-----------------------------------------------------------------------------
	@RequestMapping(value = "/deleteMiscellaneousRecord", method = RequestMethod.GET)
	public ModelAndView deleteMiscellaneousRecord(@RequestParam final int miscellaneousRecordId) {
		ModelAndView res;
		this.miscellaneousRecordService.delete(this.miscellaneousRecordService.findOne(miscellaneousRecordId));

		res = new ModelAndView("redirect:create.do");
		return res;
	}

	//Helper methods---------------------------------------------------
	//Personal Record---------------------------------------------------
	protected ModelAndView createEditPersonalRecordModelAndView(final PersonalRecord pr) {
		ModelAndView res;
		res = this.createEditPersonalRecordModelAndView(pr, null);
		return res;
	}
	protected ModelAndView createEditPersonalRecordModelAndView(final PersonalRecord pr, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("curriculum/editPersonalRecord");
		res.addObject("personalRecord", pr);
		res.addObject("message", messageCode);

		return res;
	}

	//Endorser Record---------------------------------------------------
	protected ModelAndView createEditEndorserRecordModelAndView(final EndorserRecord er) {
		ModelAndView res;
		res = this.createEditEndorserRecordModelAndView(er, null);
		return res;
	}
	protected ModelAndView createEditEndorserRecordModelAndView(final EndorserRecord er, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("curriculum/editEndorserRecord");
		res.addObject("endorserRecord", er);
		res.addObject("message", messageCode);

		return res;
	}

	//Education Record---------------------------------------------------
	protected ModelAndView createEditEducationRecordModelAndView(final EducationalRecord er) {
		ModelAndView res;
		res = this.createEditEducationRecordModelAndView(er, null);
		return res;
	}
	protected ModelAndView createEditEducationRecordModelAndView(final EducationalRecord er, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("curriculum/editEducationRecord");
		res.addObject("educationRecord", er);
		res.addObject("message", messageCode);

		return res;
	}
	//Professional Record---------------------------------------------------
	protected ModelAndView createEditProfessionalRecordModelAndView(final ProfessionalRecord pr) {
		ModelAndView res;
		res = this.createEditProfessionalRecordModelAndView(pr, null);
		return res;
	}
	protected ModelAndView createEditProfessionalRecordModelAndView(final ProfessionalRecord pr, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("curriculum/editProfessionalRecord");
		res.addObject("professionalRecord", pr);
		res.addObject("message", messageCode);

		return res;
	}

	//Miscellaneous Record---------------------------------------------------
	protected ModelAndView createEditMiscellaneousRecordModelAndView(final MiscellaneousRecord mr) {
		ModelAndView res;
		res = this.createEditMiscellaneousRecordModelAndView(mr, null);
		return res;
	}
	protected ModelAndView createEditMiscellaneousRecordModelAndView(final MiscellaneousRecord mr, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("curriculum/editMiscellaneousRecord");
		res.addObject("miscellaneousRecord", mr);
		res.addObject("message", messageCode);

		return res;
	}
}
