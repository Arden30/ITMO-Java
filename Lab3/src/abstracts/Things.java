package abstracts;

public abstract class Things implements Thingsable{
    private String name;

    protected Things(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Things things = (Things) o;
        return name.equals(things.name);
    }
}
