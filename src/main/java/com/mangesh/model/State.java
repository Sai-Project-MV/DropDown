package com.mangesh.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.Data;

@Entity
@Data
@Table(name="STATE")
public class State {

	@Id
	//@GeneratedValue
	@Column(name="STATEID")
	private Integer stateId;
	@Column(name="STATENAME")
	private String stateName;
	@OneToMany(targetEntity = City.class,cascade = CascadeType.ALL,
			fetch = FetchType.EAGER,orphanRemoval = true)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "STATEID_FK",referencedColumnName = "STATEID")
	private Set<City> city;
}
