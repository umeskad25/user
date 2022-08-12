package com.electro.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.electro.user.entity.Test;
import com.electro.user.entity.UniqueBill;
import com.electro.user.exception.BillException;
import com.electro.user.exception.InvalidConnectionTypeException;
import com.electro.user.jpa.ConsumerRepo;
import com.electro.user.service.BillService;
import com.electro.user.service.ConsumerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RetriveBillController {

	
	
	@Autowired
	BillService billService;
	
	 private static final Logger logger = LoggerFactory.getLogger(RetriveBillController.class);
		
	
	/*
	This method received consumer number 
	and return the List of Bills	
	*/
	@GetMapping("/allBill/{consumer}")
	public ResponseEntity<Object> retriveBillList(@PathVariable Long consumer) {
		
		logger.info("Called allBill controller"+" with consumer number : "+consumer);
		
		List<UniqueBill> listOfBill =null;
		
		try {
			listOfBill = billService.retriveBill(consumer);
		} catch (InvalidConnectionTypeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}catch(BillException billException) {
			return ResponseEntity.status(HttpStatus.OK).body(billException.getMessage());
		}
		
		
		logger.info("result return with "+listOfBill.size()+" records");
		return ResponseEntity.status(HttpStatus.OK).body(listOfBill);
		
	}
	
	
	@GetMapping("/uitest")
	public ResponseEntity<Object> test() {
		
		
		List<UniqueBill> listOfBill = new ArrayList<UniqueBill>();
		
		UniqueBill bill =  new UniqueBill();
		bill.setBill(19999L);
		bill.setAmount(2000L);
		bill.setCurrentReading(3444L);
		bill.setMeterNo(340L);
		bill.setPaid(true);
		bill.setPreviousReading(122L);
		bill.setMultiply(1.0f);
		bill.setTotalUnit(100L);
		bill.setUnit(200L);
		

		UniqueBill bill2 =  new UniqueBill();
		bill2.setBill(1999L);
		bill2.setAmount(200L);
		bill2.setCurrentReading(344L);
		bill2.setMeterNo(34L);
		bill2.setPaid(true);
		bill2.setPreviousReading(12L);
		bill2.setMultiply(1.5f);
		bill2.setTotalUnit(10L);
		bill2.setUnit(20L);
		
		
		UniqueBill bill3 =  new UniqueBill();
		bill3.setBill(23L);
		bill3.setAmount(18L);
		bill3.setCurrentReading(12L);
		bill3.setMeterNo(34L);
		bill3.setPaid(true);
		bill3.setPreviousReading(87L);
		bill3.setMultiply(2.0f);
		bill3.setTotalUnit(56L);
		bill3.setUnit(30L);
		
		listOfBill.add(bill);
		listOfBill.add(bill2);
		listOfBill.add(bill3);
		
		
		
		Test t = new Test();
		t.setA("hi");
		t.setB("hello");
		
		
		
		//return listOfBill;
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("no any bill available");
		
	}
	
	
	@GetMapping("/resource")
	  @ResponseBody
	  public Map<String, Object> home() {
	    Map<String, Object> model = new HashMap<String, Object>();
	    model.put("id", UUID.randomUUID().toString());
	    model.put("content", "Hello World");
	    return model;
	  }
	
	
}
