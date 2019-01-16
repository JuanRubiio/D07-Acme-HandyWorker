
package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import repositories.ComplaintRepository;
import domain.Complaint;

public class StringToComplaintConverter implements Converter<String, Complaint> {

	@Autowired
	ComplaintRepository	complaintRepository;


	@Override
	public Complaint convert(final String text) {
		Complaint res;
		int id;

		try {
			if (StringUtils.isEmpty(text))
				res = null;
			else {
				id = Integer.valueOf(text);
				res = this.complaintRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}

		return res;
	}
}
