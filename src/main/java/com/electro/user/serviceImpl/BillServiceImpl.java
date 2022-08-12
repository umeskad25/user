package com.electro.user.serviceImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.electro.user.entity.Consumer;
import com.electro.user.entity.UniqueBill;
import com.electro.user.exception.BillException;
import com.electro.user.exception.InvalidConnectionTypeException;
import com.electro.user.jpa.ConsumerRepo;
import com.electro.user.service.BillService;
@Service
public class BillServiceImpl  implements BillService{

	@Autowired
	ConsumerRepo consumerRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(BillServiceImpl.class);
	
	
	@Override
	public List<UniqueBill> retriveBill(Long consumerId) throws InvalidConnectionTypeException,BillException{
		
		logger.info("Retrive bill called ");
		
		Consumer consumerDetail=null;
		
		try {
			 consumerDetail = consumerRepo.findByConsumerNumverValue(consumerId);
			
		} catch (Exception e) {
			logger.info("catched in exception");
		}
		
		if(consumerDetail == null) {
			logger.info("No such user found in the database ");
			 throw new InvalidConnectionTypeException("User is not a part of Electro service or check Consumer Number");
		}
		
		logger.info("Retrived detail");
		List<UniqueBill> billList = consumerDetail.getBill();
		
		if(billList.size()==0) {
			throw new BillException("User dont have any bill till the date");
		}
		
		return billList;
	}
}
