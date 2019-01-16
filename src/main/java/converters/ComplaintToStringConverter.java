
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Complaint;

@Component
@Transactional
public class ComplaintToStringConverter implements Converter<Complaint, String> {

	@Override
	public String convert(final Complaint complaint) {
		String res;

		if (complaint == null)
			res = null;
		else
			res = String.valueOf(complaint.getId());

		return res;
	}

}
