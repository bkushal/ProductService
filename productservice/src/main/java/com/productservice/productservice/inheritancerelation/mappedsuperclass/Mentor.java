package com.productservice.productservice.inheritancerelation.mappedsuperclass;

import jakarta.persistence.Entity;

@Entity(name = "ms_mentor")
public class Mentor extends User {
	private double avgRating;

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
	
}
