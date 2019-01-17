package converters;

import org.springframework.core.convert.converter.Converter;

import domain.Customer;

public class CustomerToStringConverter implements Converter<Customer,String> {

	@Override
	public String convert(Customer Customer) {
		String res;
		
		if(Customer==null){
			res=null;
		}else{
			res = String.valueOf(Customer.getId());
		}
		
		return res;
	}
	
}
