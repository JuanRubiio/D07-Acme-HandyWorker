package converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import repositories.HandyWorkerRepository;

import domain.HandyWorker;

public class StringToHandyWorkerConverter implements Converter<String ,HandyWorker>{

	@Autowired
	HandyWorkerRepository handyWorkerRepository;
	
	@Override
	public HandyWorker convert(String text) {
		HandyWorker res;
		int id;
		
		try{
			if(StringUtils.isEmpty(text)){
				res=null;
			}else{
				id = Integer.valueOf(text);
				res = handyWorkerRepository.findOne(id);
			}
		}catch(Throwable oops){
			throw new IllegalArgumentException(oops);
		}
		
		return res;
	}
	
}
