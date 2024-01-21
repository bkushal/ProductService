package com.productservice.productservice.inheritancerelation.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_ta")
@DiscriminatorValue(value = "1")
public class TA extends User {
	private String ta_session;

	public String getTa_session() {
		return ta_session;
	}

	public void setTa_session(String ta_session) {
		this.ta_session = ta_session;
	}
}
