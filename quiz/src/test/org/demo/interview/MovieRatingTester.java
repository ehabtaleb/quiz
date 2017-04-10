package org.demo.interview;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * Created by ehabtaleb on 17/01/17.
 */
public class MovieRatingTester {

  @Test
  public void testMovieMaxRating(){

    int n = 2;
    Movie movieD = new Movie("D", 4.2f);
    Movie movieC = new Movie("C", 2.2f);
    Movie movieB = new Movie("B", 3.2f);
    //movieB.addRelatedMovies(movieD);
    //movieC.addRelatedMovies(movieD);
    Movie movieA = new Movie("A", 1.2f);
    //movieA.addRelatedMovies(movieB);
    //movieA.addRelatedMovies(movieC);

    Set<Movie> highRatedSet = findNHighRatedMovies(movieA, n);
    Assert.assertThat(highRatedSet.size(), Is.is(3));
  }

  private Set<Movie> findNHighRatedMovies(Movie movie, int n) {
    if(n < 1 || movie.getRelatedMovies().size() < 1){
      return new HashSet<>();
    }
    float maxRate = 0.0f;
    Set<Movie> nMaxRatedSet = null;
    List<Movie> relatedList = movie.getRelatedMovies();
    for (int i = 0; i < relatedList.size(); i++) {
      Movie m = relatedList.get(i);
      Set<Movie> moviesSet = findNHighRatedBranch(m, n);
      float localSum = calcBranchRate(moviesSet);
      if(localSum > maxRate){
        maxRate = localSum;
        nMaxRatedSet = moviesSet;
      }
    }
    return nMaxRatedSet;
  }

  private Set<Movie> findNHighRatedBranch(Movie m, int n) {
    HashSet<Movie> movies =  new HashSet<>();
    if(n < 2 || m.getRelatedMovies().size() < 1) {
      movies.add(m);
      return movies;
    }
    List<Movie> relatedList = m.getRelatedMovies();
    Stack<Movie> stack = new Stack();
    for (int i = 0; i < relatedList.size(); i++) {
      Movie child = relatedList.get(i);
      stack.push(child);
      while(child.getRelatedMovies().size() > 0){
        child = child.getRelatedMovies().get(i);
        stack.push(child);
      }

    }
    return null;
  }

  private float calcBranchRate(Set<Movie> moviesSet) {
   float sum = 0.0f;
    for (Movie movie : moviesSet){
     sum = sum + movie.getRating();
   }
    return sum;
  }
}
