package org.demo.interview;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by ehabtaleb on 17/01/17.
 */
public class Movie {

  private final String id;
  private final float rating;
  private List<Movie> relatedMovies;

  public Movie(String name, float rate){
    this.id = name;
    this.rating = rate;
    this.relatedMovies = new LinkedList<>();
  }

  public float getRating() {
    return rating;
  }

  public List<Movie> getRelatedMovies() {
    return relatedMovies;
  }

  public String getId() {
    return id;
  }

  public void addRelatedMovie(Movie relatedMovie) {
    this.relatedMovies.add(relatedMovie);
  }

  public static float highestRating(Movie movie){
    HashSet<String> visited = new HashSet<>();
    float[] rating = new float[movie.getRelatedMovies().size()];
    return highestRating(movie, visited, rating);
  }

  private static float highestRating(Movie movie, HashSet<String> visited,
      float[] rating) {
    if(visited.contains(movie.id)){
      return 0f;
    }
    visited.add(movie.id);
    for (int i = 0; i < movie.getRelatedMovies().size(); i++){
      Movie child = movie.getRelatedMovies().get(i);
      float localHigh = highestRating(child, visited, rating);

    }
    return 0f;
  }


}
