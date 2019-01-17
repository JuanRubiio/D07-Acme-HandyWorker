
package domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Complaint extends DomainEntity {

	private String	ticker;
	private Date	moment;
	private String	description;
	private String	attachements;
	private Collection<Report> reports;

	@NotBlank
	@Pattern(regexp = "\\d{6}-[A-Z]{4}")
	public String getTicker() {
		return this.ticker;
	}

	public void setTicker(final String ticker) {
		this.ticker = ticker;
	}

	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getMoment() {
		return this.moment;
	}

	public void setMoment(final Date moment) {
		this.moment = moment;
	}
	@NotBlank
	public String getDescription() {
		return this.description;
	}

	public void setDescription(final String description) {
		this.description = description;
	}

	public String getAttachements() {
		return this.attachements;
	}

	public void setAttachements(final String attachements) {
		this.attachements = attachements;
	}

	public Collection<Report> getReports() {
		return reports;
	}

	public void setReports(Collection<Report> reports) {
		this.reports = reports;
	}

}
