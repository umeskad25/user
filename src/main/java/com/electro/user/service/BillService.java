package com.electro.user.service;

import java.util.List;

import com.electro.user.entity.UniqueBill;

public interface BillService {

	public List<UniqueBill> retriveBill(Long consumer);
	
}
