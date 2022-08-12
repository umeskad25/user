package com.electro.user.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Consumer {

	@Id
	@GeneratedValue
	Long consumer;
	String userName;
	Date issuedDate;
	Float sanctionedLoad;
	String typeConnection;
	Long meterNumber;
	String voltageLevel; 
	@OneToOne( cascade = CascadeType.ALL)
	@JoinColumn(name="address_id",unique = true)
	Address address;
	@OneToMany(targetEntity = UniqueBill.class,cascade =CascadeType.ALL)
	@JoinColumn(name="cp_fk",referencedColumnName = "consumer")
	List<UniqueBill> bill; 
}
