package com.electro.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Address {

	@Id
	Long addressId;
	String houseNo;
	String area;
	String LandMark;
	String townCity;
	String state;
	String pincode;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	User user;
	
	 
}
