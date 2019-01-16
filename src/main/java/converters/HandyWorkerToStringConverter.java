package converters;

import org.springframework.core.convert.converter.Converter;

import domain.HandyWorker;

public class HandyWorkerToStringConverter implements Converter<HandyWorker,String> {

	@Override
	public String convert(HandyWorker handyWorker) {
		String res;
		
		if(handyWorker==null){
			res=null;
		}else{
			res = String.valueOf(handyWorker.getId());
		}
		
		return res;
	}
	
}
