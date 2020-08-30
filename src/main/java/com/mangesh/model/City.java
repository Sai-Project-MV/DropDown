package com.mangesh.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="CITY")
public class City {

	@Id
	//@GeneratedValue
	@Column(name="CITYID")
	private Integer cityId;
	@Column(name="CITYNAME")
	private String cityName;
}
