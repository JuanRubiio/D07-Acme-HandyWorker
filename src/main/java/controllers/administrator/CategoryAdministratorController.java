
package controllers.administrator;

import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import services.CategoryService;
import controllers.AbstractController;
import domain.Category;

@Controller
@RequestMapping("/category/administrator")
public class CategoryAdministratorController extends AbstractController {

	//Los admin son los que controlan el arbol de categorias
	@Autowired
	private CategoryService	categoryService;


	public CategoryAdministratorController() {
		super();
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView list() {
		ModelAndView res;
		Collection<Category> categories;

		categories = this.categoryService.findAll();
		res = new ModelAndView("category/list");
		res.addObject("categories", categories);
		res.addObject("requestURI", "/category/administrator/list.do");

		return res;
	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView result;
		Category category;
		try {
			category = this.categoryService.create();
			result = this.createModelAndView(category);
			result.addObject("categories", this.categoryService.findAll());
			result.addObject("action", "category/administrator/create.do");
		} catch (final Throwable oops) {
			result = new ModelAndView("redirect:/#");
		}
		return result;
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST, params = "save")
	public ModelAndView saveCreate(@Valid final Category category, final BindingResult result) {
		ModelAndView res;
		if (result.hasErrors()) {
			res = this.createModelAndView(category);
			res.addObject("categories", this.categoryService.findAll());
		} else
			try {
				this.categoryService.save(category);
				res = new ModelAndView("redirect:/category/administrator/list.do");
			} catch (final Throwable oops) {
				res = this.createModelAndView(category);
				res.addObject("categories", this.categoryService.findAll());
			}

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam final Integer categoryId) {
		ModelAndView res;
		Category category;
		try {
			category = this.categoryService.findOne(categoryId);
			res = this.editModelAndView(category);
		} catch (final Throwable oops) {
			res = new ModelAndView("redirect:/#");
		}

		return res;
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST, params = "save")
	public ModelAndView save(@Valid final Category category, final BindingResult result) {
		ModelAndView res;
		if (result.hasErrors())
			res = this.editModelAndView(category);
		else
			try {
				this.categoryService.save(category);
				res = new ModelAndView("redirect:/category/administrator/list.do");
			} catch (final Throwable oops) {
				res = this.editModelAndView(category);
			}

		return res;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam final int categoryId) {
		ModelAndView res;

		try {
			final Category category = this.categoryService.findOne(categoryId);
			this.categoryService.delete(category);
			res = new ModelAndView("redirect:/category/administrator/list.do");
		} catch (final Throwable oops) {
			System.out.println(oops.getMessage());
			final Category category = this.categoryService.findOne(categoryId);
			res = this.editModelAndView(category, "category.commit.error");
		}

		return res;
	}

	private ModelAndView editModelAndView(final Category category) {
		ModelAndView res;

		res = this.editModelAndView(category, null);

		return res;
	}
	private ModelAndView editModelAndView(final Category category, final String messageCode) {
		ModelAndView res;

		res = new ModelAndView("category/edit");
		res.addObject("category", category);
		res.addObject("message", messageCode);

		return res;
	}
	private ModelAndView createModelAndView(final Category category) {
		ModelAndView res;

		res = this.createModelAndView(category, null);

		return res;
	}

	private ModelAndView createModelAndView(final Category category, final String messageCode) {

		ModelAndView res;

		res = new ModelAndView("category/create");
		res.addObject("category", category);
		res.addObject("message", messageCode);

		return res;

	}

}
