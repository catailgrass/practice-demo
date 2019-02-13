package practice.proxy;

public class Wizard {
    private String name;

    public Wizard(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString(){
        return "I am " + this.getName();
    }
}
