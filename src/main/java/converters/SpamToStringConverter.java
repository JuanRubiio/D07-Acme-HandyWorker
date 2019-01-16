
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Spam;

@Component
@Transactional
public class SpamToStringConverter implements Converter<Spam, String> {

	@Override
	public String convert(final Spam arg0) {
		String result;
		if (arg0 == null)
			result = null;
		else
			result = String.valueOf(arg0.getId());
		return result;
	}

}
