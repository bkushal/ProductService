package com.productservice.productservice.inheritancerelation.tableperclass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_student")
public class Student extends User {
	private double psp;

	public double getPsp() {
		return psp;
	}

	public void setPsp(double psp) {
		this.psp = psp;
	}
}
