package lecture3.homework.api.models;

public class Unicorn {

    private String name;
    private String colorTail;

    public Unicorn(String name, String colorTail) {
        this.name = name;
        this.colorTail = colorTail;
    }

    public void setColorTail(String colorTail) {
        this.colorTail = colorTail;
    }

    public String toJson() {
        return String.format("{\"name\": \"%s\", \"colorTail\": \"%s\"}", name, colorTail);
    }
}
