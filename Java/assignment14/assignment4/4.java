import java.util.ArrayList;
import java.util.List;

class Movie {
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
}

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
}
