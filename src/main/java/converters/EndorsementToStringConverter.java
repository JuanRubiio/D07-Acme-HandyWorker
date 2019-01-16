
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Endorsement;

@Component
@Transactional
public class EndorsementToStringConverter implements Converter<Endorsement, String> {

	@Override
	public String convert(final Endorsement e) {
		String result;
		if (e == null)
			result = null;
		else
			result = String.valueOf(e.getId());
		return result;
	}

}