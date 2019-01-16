
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Configuration;

@Component
@Transactional
public class ConfigurationToStringConverter implements Converter<Configuration, String> {

	@Override
	public String convert(final Configuration arg0) {
		String result;
		if (arg0 == null)
			result = null;
		else
			result = String.valueOf(arg0.getId());
		return result;
	}

}
