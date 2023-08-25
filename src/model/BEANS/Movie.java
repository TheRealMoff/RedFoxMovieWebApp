package model.BEANS;

public class Movie {
	private String id;
	private String image;
	private String Title;
	private String Director;
	private String Actors;
	private String genre;
	private String year_of_production;
	private int average_rate;
	public Movie(String id, String image, String title, String director, String actors, String genre,
			String year_of_production, int average_rate) {
		super();
		this.id = id;
		this.image = image;
		Title = title;
		Director = director;
		Actors = actors;
		this.genre = genre;
		this.year_of_production = year_of_production;
		this.average_rate = average_rate;
	}
	public Movie(String title, String director, String actors, String genre, String year_of_production,
			int average_rate) {
		super();
		Title = title;
		Director = director;
		Actors = actors;
		this.genre = genre;
		this.year_of_production = year_of_production;
		this.average_rate = average_rate;
	}
	public Movie(String id, String title, String director, String actors, String genre, String year_of_production,
			int average_rate) {
		super();
		this.id = id;
		Title = title;
		Director = director;
		Actors = actors;
		this.genre = genre;
		this.year_of_production = year_of_production;
		this.average_rate = average_rate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getYear_of_production() {
		return year_of_production;
	}
	public void setYear_of_production(String year_of_production) {
		this.year_of_production = year_of_production;
	}
	public int getAverage_rate() {
		return average_rate;
	}
	public void setAverage_rate(int average_rate) {
		this.average_rate = average_rate;
	}
	@Override
	public String toString() {
		return "Movie [id=" + id + ", image=" + image + ", Title=" + Title + ", Director=" + Director + ", Actors="
				+ Actors + ", genre=" + genre + ", year_of_production=" + year_of_production + ", average_rate="
				+ average_rate + "]";
	}
	
}
