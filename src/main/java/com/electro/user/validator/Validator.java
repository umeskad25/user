package com.electro.user.validator;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.electro.user.entity.Consumer;
import com.electro.user.exception.InvalidConnectionTypeException;
import com.electro.user.model.TypeConnection;
import com.electro.user.model.VoltageLevel;

@Component
public class Validator {



	Boolean typeConnectionFlag = false;
	Boolean voltageLevelFlag=false;
	
	public void validateConsumer(Consumer c) throws InvalidConnectionTypeException  {
		System.out.println("success");
		ResponseEntity<TypeConnection[]> currencyConversion = 
				new RestTemplate().getForEntity("http://localhost:8000/typeConnection", 
						TypeConnection[].class);
		 
		TypeConnection[]  connection = currencyConversion.getBody();
	
		System.out.println("flag");
		
		for(TypeConnection n : connection) {
			if(n.getConnectionType().toString().equalsIgnoreCase(c.getTypeConnection())) {
				typeConnectionFlag = true;
			}
		}
		
		if(!typeConnectionFlag) {
			throw new InvalidConnectionTypeException( "Invalid connection type !!");
		}
		
		System.out.println("voltage level");
		
		ResponseEntity<VoltageLevel[]> voltageLevel = 
				new RestTemplate().getForEntity("http://localhost:8000/VoltageLevel", 
						VoltageLevel[].class);
		
		
		VoltageLevel[] t = voltageLevel.getBody();
		System.out.println(c.getVoltageLevel());
		if(c.getVoltageLevel() == null) {
			throw new InvalidConnectionTypeException( "Voltage level cannot be null !!");
		}
		
	
		for(VoltageLevel m : t) {
			
			if(m.getLevel().toString().equals(c.getVoltageLevel())) {
				voltageLevelFlag = true;
				
			}
		}
		
		if(!voltageLevelFlag) {
			throw new InvalidConnectionTypeException( "Voltage level is incorrect !!");
		}
		 
	
		
	}
}
