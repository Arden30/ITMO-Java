package abstracts;

public abstract class Human implements Humanable {
    private String name;
    private boolean hurt;

    protected Human(String name) {
        this.setName(name);
    }
    protected Human(String name, boolean hurt) {
        this.name = name;
        this.hurt = hurt;
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
