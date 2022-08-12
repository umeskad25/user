package com.electro.user.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.electro.user.entity.Consumer;

@Repository
@EnableJpaRepositories
public interface ConsumerRepo extends JpaRepository<Consumer, Long> {

	@SuppressWarnings("unchecked") 
	Consumer save(Consumer consumer);
	
	@Query( "SELECT c FROM Consumer c WHERE c.consumer = :l") 
Consumer findByConsumerNumverValue(@Param("l") Long l);
	
//	 
}
