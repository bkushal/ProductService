package com.productservice.productservice.inheritancerelation.singletable;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity(name = "st_student")
@DiscriminatorValue(value = "2")
public class Student extends User {
	private double psp;

	public double getPsp() {
		return psp;
	}

	public void setPsp(double psp) {
		this.psp = psp;
	}
}
