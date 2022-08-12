package com.electro.user.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electro.user.entity.Address;
import com.electro.user.entity.Consumer;
import com.electro.user.entity.UniqueBill;
import com.electro.user.exception.InvalidConnectionTypeException;
import com.electro.user.jpa.ConsumerRepo;
import com.electro.user.jpa.UniqueBillRepo;
import com.electro.user.validator.Validator;

@Service
public class ConsumerService {

	@Autowired
	ConsumerRepo consumerRepo;
	
	@Autowired
	Validator validator;
	
	@Autowired
	UniqueBillRepo uniqueBillRepo;
	
	public void saveUser(){
		Consumer c = new Consumer();
//		c.setConsumer((long) 12345);
		c.setIssuedDate(null);
		c.setMeterNumber((long) 123);
		c.setSanctionedLoad(1.00f);
		c.setTypeConnection("Resedential");
		Address add = new Address();
		add.setAddressId((long) 1);
		add.setArea("moshi");
		add.setHouseNo("5");
		add.setState("MAHA");
		//@SuppressWarnings("deprecation")
		//Date d = new Date(2014, 02, 11);
		UniqueBill bill1 = new UniqueBill();
//		bill1.setBill(10004834L);
		bill1.setCurrentReading(101L);
		bill1.setPreviousReading(1L);
//		//bill1.setDate(d)
		UniqueBill bill2 = new UniqueBill();
//		bill1.setBill(298073842L);
		bill1.setCurrentReading(201L);
		bill1.setPreviousReading(101L);
//		//bill1.setDate(d);
		
		List<UniqueBill> billList = new ArrayList<UniqueBill>();
		billList.add(bill1);
		billList.add(bill2);
		c.setAddress(add);
		c.setBill(billList);
		
		
		consumerRepo.save(c);
		
	}
	
	public Consumer findConsumerById(Long l) {
		System.out.println(l);
		Consumer k = consumerRepo.findByConsumerNumverValue(l);
		
		//Consumer k = consumerRepo.findConsumer((long) 12345);
		//Consumer k1 = k.get();
		System.out.println(k);
		return k;
	}
	
	public Consumer registerUser(Consumer cons) {
		System.out.println("in validator");
		
		
		//validator.validateConsumer(cons);
		System.out.println("out validator");
		Consumer k = consumerRepo.save(cons);
		return k;
	}
	
	public String addBill(Long consumerNo, UniqueBill bill) throws Exception {
		
		Consumer consumer = findConsumerById(consumerNo);
//		if(bill.equals(null)) {
//			throw new Exception("Bill cannot be empty");
//		}
//		if(consumerNo.equals(null)) {
//			throw new Exception("Consumer number cannot be empty");
//		}
//		if(consumer.getMeterNumber()!= bill.getMeterNo()) {
//			throw new Exception("Incorrect consumer number and bill");
//		}else { 
			List<UniqueBill> billList = consumer.getBill();
			UniqueBill b = new UniqueBill();
			b.setAmount(200L);
			b.setBill(3333L);
			b.setCurrentReading(1111L);
			b.setCurrentReading(3455L);
			b.setMeterNo(2L);
			b.setMultiply(1.0f);
			b.setPaid(true);
			b.setPreviousReading(10000L);
			b.setTotalUnit(12345L);
			b.setUnit(890L);
			
			billList.add(bill);
			System.out.println("bill added to list");
//			
//			for(UniqueBill b : billList) {
//				System.out.println(b.toString());
//			}
			
			consumer.setBill(billList);
			System.out.println("before saving consumert");
			Consumer k = registerUser(consumer);

			System.out.println("after saving consumert");
			System.out.println(k);
//		}
		return null;
	}
	 
	
	UniqueBill saveBill(UniqueBill bill) {
		UniqueBill ub = uniqueBillRepo.save(bill);
		return ub;
	}
	
	
}
