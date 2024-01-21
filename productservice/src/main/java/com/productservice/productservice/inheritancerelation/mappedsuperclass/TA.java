package com.productservice.productservice.inheritancerelation.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name = "ms_ta")
public class TA extends User {
	private String ta_session;

	public String getTa_session() {
		return ta_session;
	}

	public void setTa_session(String ta_session) {
		this.ta_session = ta_session;
	}
}
