package model.BEANS;

public class Ratings {
	private String id;
	private String rating;
	public Ratings(String id, String rating) {
		super();
		this.id = id;
		this.rating = rating;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	@Override
	public String toString() {
		return "Ratings [id=" + id + ", rating=" + rating + "]";
	}
	
	
}
