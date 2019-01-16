
package services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.Section;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class SectionServiceTest extends AbstractTest {

	@Autowired
	private SectionService	sectionService;


	@Test
	public void createTest() {
		super.authenticate("handyworker1");
		Section section = new Section();
		section = this.sectionService.create(1415);
		Assert.notNull(section);
	}

	@Test
	public void saveTest() {

		final Section section = this.sectionService.findOne(1412);
		section.setTitle("Titulo");
		this.sectionService.save(section);
		Assert.isTrue(this.sectionService.findAll().contains(section));
	}
	@Test(expected = IllegalArgumentException.class)
	public void deleteTest() {
		super.authenticate("handyworker1");
		final Section section = this.sectionService.findOne(1412);

		this.sectionService.delete(section);
		Assert.isNull(this.sectionService.findOne(1412));
		super.authenticate(null);
	}

}
