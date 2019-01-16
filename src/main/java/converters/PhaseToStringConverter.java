package converters;

import javax.transaction.Transactional;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import domain.Phase;

@Component
@Transactional	
public class PhaseToStringConverter implements Converter<Phase,String>{

	@Override
	public String convert(Phase phase) {
		String res;
		
		if(phase==null){
			res=null;
		}else{
			res = String.valueOf(phase.getId());
		}

		return res;
	}
	
}
