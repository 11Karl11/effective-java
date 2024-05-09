package chapter26.adv;

import java.util.List;

/**
 * @author karl xie
 */
class Movie {
    private String title;
    private List<Director> directors;
    private List<Role> roles;

    Movie(String title, List<Director> directors, List<Role> roles) {
        this.title = title;
        this.directors = directors;
        this.roles = roles;
    }

    List<Role> getRoles() {
        return roles;
    }
}

class Director {
    private String name;

    Director(String name) {
        this.name = name;
    }
}

class Role {
    private String characterName;
    private Actor actor;

    Role(String characterName, Actor actor) {
        this.characterName = characterName;
        this.actor = actor;
    }

    Actor getActor() {
        return actor;
    }
}

class Actor {
    private String name;

    Actor(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return name.equals(actor.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}