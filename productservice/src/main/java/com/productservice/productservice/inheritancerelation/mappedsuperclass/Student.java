package com.productservice.productservice.inheritancerelation.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name = "ms_student")
public class Student extends User {
	private double psp;

	public double getPsp() {
		return psp;
	}

	public void setPsp(double psp) {
		this.psp = psp;
	}
}
