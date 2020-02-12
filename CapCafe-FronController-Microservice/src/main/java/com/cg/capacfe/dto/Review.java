package com.cg.capacfe.dto;


/**
 * Entity class for storing Cafe review details.
 * @author Akash Verma
 *
 */
public class Review {
	
	private int reviewId;
	
	private Cafe cafe;
	
	private int rating;
	
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
