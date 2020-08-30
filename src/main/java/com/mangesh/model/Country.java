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

@Data
@Entity
@Table(name = "COUNTRY")
public class Country {

	@Id
	//@GeneratedValue
	@Column(name="COUNTRYID")
	private Integer countryId;
	@Column(name="COUNTRYNAME")
	private String countryName;

	@OneToMany(targetEntity = State.class, cascade = CascadeType.ALL,
			fetch = FetchType.EAGER, orphanRemoval = true)
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "COUNTRYID_FK", referencedColumnName = "COUNTRYID")
	private Set<State> state;
}
