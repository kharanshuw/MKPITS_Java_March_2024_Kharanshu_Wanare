package assignment4;

public class Main {
public static void main(String[] args) {
	MovieCollection movieCollection=new MovieCollection();
	Movie movie=new Movie("1", "avengers", "xyz", "scifi",2012);
	Movie movie2=new Movie("2", "b", "v", "scifi",2012);
	Movie movie3=new Movie("3", "d", "w", "scifi",2012);
	Movie movie4=new Movie("4", "c", "g", "scifi",2012);
	movieCollection.addMovie(movie);
	movieCollection.addMovie(movie2);
	movieCollection.addMovie(movie3);
	movieCollection.addMovie(movie4);
//	movieCollection.removeMovieByMovieID("1");
	Movie movie5=movieCollection.searchMovieByTitle("avengers");
	System.out.println(movie5);
	System.out.println(movieCollection.searchMovieByTitle("avengers"));
	movieCollection.displaybygonra();
}
}
