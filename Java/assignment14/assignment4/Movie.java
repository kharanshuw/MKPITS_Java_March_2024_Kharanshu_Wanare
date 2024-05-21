package assignment14.assignment4;

import java.util.ArrayList;
import java.util.List;

class Movie implements Comparable<Movie>{
    String movieID;
    String title;
    String director;
    String genre;
    int yearReleased;

    Movie(String movieID, String title, String director, String genre, int yearReleased) {
        this.movieID = movieID;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.yearReleased = yearReleased;
    }

    @Override
    public String toString() {
        return "MovieID: " + movieID + ", Title: " + title + ", Director: " + director + ", Genre: " + genre + ", Year Released: " + yearReleased;
    }

	@Override
	public int compareTo(Movie o) {
		return this.genre.compareTo(o.genre);
	}
}