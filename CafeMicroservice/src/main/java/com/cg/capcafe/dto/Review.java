package com.cg.capcafe.dto;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Entity class for storing Cafe review details.
 * @author Akash Verma
 *
 */
@Entity
@Table(name = "review")
public class Review {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "review_id")
	private int reviewId;
	
	
	@ManyToOne(fetch = FetchType.EAGER,
			   cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH, CascadeType.REMOVE})
	@JoinColumn(name = "cafe_id", nullable = false)
	private Cafe cafe;
	
	private int rating;
	
	@ManyToOne(fetch = FetchType.EAGER,
			   cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
	@JoinColumn(name = "employee_id", nullable = false)
	private Employee employee;
	
	private String review;

	public Review(int reviewId, Cafe cafe, int rating, Employee employee, String review) {
		super();
		this.reviewId = reviewId;
		this.cafe = cafe;
		this.rating = rating;
		this.employee = employee;
		this.review = review;
	}

	public Review() {}

	public int getReviewId() {
		return reviewId;
	}

	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}

	public Cafe getCafe() {
		return cafe;
	}

	public void setCafe(Cafe cafe) {
		this.cafe = cafe;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + rating;
		result = prime * result + ((review == null) ? 0 : review.hashCode());
		result = prime * result + reviewId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		if (rating != other.rating)
			return false;
		if (review == null) {
			if (other.review != null)
				return false;
		} else if (!review.equals(other.review))
			return false;
		if (reviewId != other.reviewId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", cafe=" + cafe + ", rating=" + rating + ", employee=" + employee
				+ ", review=" + review + "]";
	}
	
	
	
	

}
