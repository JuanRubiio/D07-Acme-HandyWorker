
package services;

import java.util.Collection;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.Finder;
import domain.FixUpTask;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class FinderServiceTest extends AbstractTest {

	@Autowired
	private FinderService	finderService;


	@Test
	public void testSaveFinder() {
		super.authenticate("handyWorker1");
		final Finder finder = this.finderService.create();
		Assert.notNull(finder);
		super.authenticate(null);
	}

	@Test
	public void testFindFixUpTask() {
		super.authenticate("handyWorker1");
		final Finder finder = this.finderService.create();
		Assert.notNull(finder);
		final Collection<FixUpTask> res = this.finderService.findFixUpTasks(finder);
		Assert.notEmpty(res);
		super.authenticate(null);
	}

}
