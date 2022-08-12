package com.electro.user.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString 
public class UniqueBill {

	@Id
	@GeneratedValue
	Long bill;
	Long currentReading; 
	Long previousReading;
	Float multiply;
	Long unit;
	Long totalUnit;
	Boolean paid;
	Long amount;
	Long meterNo;
	
//	Date date;
	
	
}
