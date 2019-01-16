
package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.ProfessionalRecord;

@Component
@Transactional
public class ProfessionalRecordToStringConverter implements Converter<ProfessionalRecord, String> {

	@Override
	public String convert(final ProfessionalRecord ProfessionalRecord) {
		String result;

		if (ProfessionalRecord == null)
			result = null;
		else
			result = String.valueOf(ProfessionalRecord.getId());

		return result;
	}
}
