
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
import domain.Endorser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class EndorserServiceTest extends AbstractTest {

	@Autowired
	private EndorserService	endorserService;


	@Test
	public void testFindAllEndorser() {

		final Collection<Endorser> todos = this.endorserService.findAll();
		Assert.isTrue(todos.size() == 5);

	}

	@Test
	public void testFindOneEndorser() {

		final Endorser recuperado = this.endorserService.findOne(1308);
		Assert.isTrue(recuperado.getName().equals("David"));
	}

	@Test
	public void testgetNumberPositiveWords() {

		final Integer p = this.endorserService.getNumberOfPositiveWords(1308);
		Assert.isTrue(p == 2);
	}

	@Test
	public void testgetNumberNegativeWords() {

		final Integer n = this.endorserService.getNumberOfNegativeWords(1308);
		Assert.isTrue(n == 1);
	}

	@Test
	public void testCalculateScore() {

		final Double score = this.endorserService.calculateScore(1308);
		Assert.isTrue(score == 1.0);
	}

}
