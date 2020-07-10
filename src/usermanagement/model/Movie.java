package usermanagement.model;

public class Movie {
	private String name;
	
	private String actors[];
	private double rating;
	private String poster;
	private String director;
	
	public Movie(String name, String[] actors, double rating, String poster, String director) {
		super();
		this.name = name;
		this.actors = actors;
		this.rating = rating;
		this.poster = poster;
		this.director = director;
	}
	
	public Movie(String name, double rating, String poster, String director) {
		super();
		this.name = name;
		this.actors = actors;
		this.rating = rating;
		this.poster = poster;
		this.director = director;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getActors() {
		return actors;
	}
	public void setActors(String[] actors) {
		this.actors = actors;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}
	
}
