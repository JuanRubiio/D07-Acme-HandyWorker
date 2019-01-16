
package services;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.HandyWorker;
import domain.Tutorial;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class TutorialServiceTest extends AbstractTest {

	@Autowired
	private TutorialService		tutorialService;

	@Autowired
	private HandyWorkerService	handyWorkerService;


	@Test
	public void createTest() {
		super.authenticate("handyWorker1");
		final HandyWorker handyWorker = this.handyWorkerService.findOne(1313);
		final Tutorial tutorial = this.tutorialService.create(handyWorker);
		Assert.notNull(tutorial);
	}

	@Test
	public void saveTest() {
		super.authenticate("handyWorker1");
		final Tutorial tutorial = this.tutorialService.findOne(1415);
		tutorial.setTitle("Titulo nuevo");
		this.tutorialService.save(tutorial);
		Assert.isTrue(this.tutorialService.findOne(1415).getTitle().equals("Titulo nuevo"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void deleteTest() {
		super.authenticate("handyworker1");
		final Tutorial tutorial = this.tutorialService.findOne(1415);

		this.tutorialService.delete(tutorial);
		Assert.isNull(this.tutorialService.findOne(1415));
		super.authenticate(null);
	}

}
