
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Actor;

@Component
@Transactional
public class ActorToStringConverter implements Converter<Actor, String> {

	@Override
	public String convert(final Actor arg0) {
		String result;
		if (arg0 == null)
			result = null;
		else
			result = String.valueOf(arg0.getId());
		return result;
	}

}
