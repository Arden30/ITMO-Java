package abstracts;

import exceptions.IllegalNameException;

public abstract class Human implements Humanable {
    private String name;
    private boolean hurt;
    protected Human(String name) throws IllegalNameException {
        if (name == null || name.isEmpty() || name.matches(".*\\d+.*")) {
            throw new IllegalNameException("Имя некорректно");
        } else {
            this.name = name;
        }
    }
    protected Human(String name, boolean hurt) throws IllegalNameException {
        if (name == null || name.isEmpty() || name.matches(".*\\d+.*")) {
            throw new IllegalNameException("Имя некорректно");
        } else {
            this.name = name;
            this.hurt = hurt;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public boolean isHurt() {
        return hurt;
    }
    public class Feelings {
        private final String feeling;
        public Feelings(String feeling) {
            this.feeling = feeling;
        }
        public void Feel() {
            System.out.println(Human.this.name + " " + this.feeling);
        }
    }
    public static class Actions {
        public static void Position(String position) {
            System.out.print("Придав своему телу " + position + " положение, ");
        }
        public static void NotToBe(Human human) {
            System.out.println(human + " и там не было. ");
        }
    }

    @Override
    public String toString() {
        return " " + name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Human human = (Human) o;
        return name.equals(human.name);
    }

}
