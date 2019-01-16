
package converters;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import repositories.ActorRepository;
import domain.Actor;

@Component
@Transactional
public class StringToActorConverter implements Converter<String, Actor> {

	@Autowired
	ActorRepository	actorRepository;


	@Override
	public Actor convert(final String arg0) {
		Actor res;
		int id;

		try {
			if (StringUtils.isEmpty(arg0))
				res = null;
			else {
				id = Integer.valueOf(arg0);
				res = this.actorRepository.findOne(id);
			}
		} catch (final Throwable oops) {
			throw new IllegalArgumentException(oops);
		}
		return res;
	}

}
