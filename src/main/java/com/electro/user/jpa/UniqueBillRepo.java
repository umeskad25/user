package com.electro.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.electro.user.entity.UniqueBill;

@Repository
public interface UniqueBillRepo extends JpaRepository<UniqueBill, Long>{

	@SuppressWarnings("unchecked")
	UniqueBill save(UniqueBill u);
	
}
