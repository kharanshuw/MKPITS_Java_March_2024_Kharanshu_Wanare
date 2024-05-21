package assignment14.assignment4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class MovieCollection {
    List<Movie> movies;

    MovieCollection() {
        movies = new ArrayList<>();
    }

    void addMovie(Movie movie) {
        movies.add(movie);
    }

    void removeMovieByMovieID(String movieID) {
    Iterator<Movie> iterator = movies.iterator();
    while (iterator.hasNext()) {
        Movie movie = iterator.next();
        if (movie.movieID.equals(movieID)) {
            iterator.remove();
            break;
        }
    }
	}


    Movie searchMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.title.equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }

    List<Movie> getMoviesByGenre(String genre) {
        List<Movie> result = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.genre.equalsIgnoreCase(genre)) {
                result.add(movie);
            }
        }
        return result;
    }
    
    public void displaybygonra() {
		Collections.sort(movies);
		System.out.println(movies);
		
	}
    
    
}
