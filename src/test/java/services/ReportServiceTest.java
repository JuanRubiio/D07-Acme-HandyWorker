
package services;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import utilities.AbstractTest;
import domain.Report;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"classpath:spring/datasource.xml", "classpath:spring/config/packages.xml"
})
@Transactional
public class ReportServiceTest extends AbstractTest {

	@Autowired
	private ReportService	reportService;


	@Test
	public void testSaveReport() {
		super.authenticate("referee1");
		final Report report = this.reportService.findOne(1433);
		report.setDescription("esta es una nueva descrpcion");
		this.reportService.save(report);
		Assert.isTrue(this.reportService.findAll().contains(report));
	}

	@Test
	public void testCreateReport() {
		super.authenticate("referee1");
		final Report report = this.reportService.create(1408);
		Assert.notNull(report);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDeleteReport() {

		super.authenticate("referee1");
		Report report;
		report = this.reportService.findOne(1408);
		this.reportService.delete(report);
		this.reportService.findOne(1420);
		super.authenticate(null);
	}

}
