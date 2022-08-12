package com.electro.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.electro.user.entity.Consumer;
import com.electro.user.entity.UniqueBill;
import com.electro.user.exception.InvalidConnectionTypeException;
import com.electro.user.service.BillService;
import com.electro.user.service.ConsumerService;

@RestController
public class Controller {
//
	@Autowired
	ConsumerService c;
	
	@Autowired
	BillService billService;
	
	 private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	   
	
	@GetMapping(value = "/t")
	public ResponseEntity<String> test() {
		System.out.println("in");
		c.saveUser();
		return ResponseEntity.status(HttpStatus.OK).body("Voltage level added succesfully ");
	}
	
	@GetMapping(value = "/t1/{l}")
	public ResponseEntity<Consumer> test1(@PathVariable Long l) {
		System.out.println("in1");
		Consumer k = c.findConsumerById(l);
		return ResponseEntity.status(HttpStatus.OK).body(k);
	}
	
	@PostMapping(value = "/t")
	public ResponseEntity<Object> test1(@RequestBody Consumer k) {
		System.out.println("in1");
		Consumer k1 = null;
		try {
			 k1= c.registerUser(k);
		} catch (InvalidConnectionTypeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(k1);
	}
	
	
	@PostMapping(value = "/bill/{consumer}")
	public ResponseEntity<Object> addBill(@PathVariable Long consumer, @RequestBody UniqueBill bill) {
		
		try {
			logger.info("logges try");
			c.addBill(consumer, bill);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		@PathVariable Long consumer,@RequestBody UniqueBill bill
		System.out.println();
		//Long meterNo
		//Long consumer
		
		return ResponseEntity.status(HttpStatus.OK).body("");
	}
	
	
	
	
}
