package chapter26.adv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author karl xie
 */
public class MovieAnalysis {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        Actor actor1 = new Actor("Tom Hanks");
        Actor actor2 = new Actor("Leonardo DiCaprio");
        Actor actor3 = new Actor("Margot Robbie");

        movies.add(new Movie("Forrest Gump", Arrays.asList(new Director("Robert Zemeckis")),
                Arrays.asList(new Role("Forrest Gump", actor1))));
        movies.add(new Movie("Titanic", Arrays.asList(new Director("James Cameron")),
                Arrays.asList(new Role("Jack Dawson", actor2), new Role("Rose", actor3))));
        movies.add(new Movie("Inception", Arrays.asList(new Director("Christopher Nolan")),
                Arrays.asList(new Role("Cobb", actor2), new Role("Harley Quinn", actor3))));

        // Find actors who have played in at least two movies
        Map<Actor, Long> actorFrequency = movies.stream()
                .flatMap(movie -> movie.getRoles().stream())
                .map(Role::getActor)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<String> popularActors = actorFrequency.entrySet().stream()
                .filter(entry -> entry.getValue() >= 2)
                .map(entry -> entry.getKey().getName())
                .collect(Collectors.toList());

        System.out.println("Actors who have played in at least two movies: " + popularActors);
    }
}