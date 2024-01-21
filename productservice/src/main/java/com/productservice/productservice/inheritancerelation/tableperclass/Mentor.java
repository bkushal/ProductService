package com.productservice.productservice.inheritancerelation.tableperclass;

import jakarta.persistence.Entity;

@Entity(name = "tpc_mentor")
public class Mentor extends User {
	private double avgRating;

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	
}
