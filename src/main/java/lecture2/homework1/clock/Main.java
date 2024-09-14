package lecture2.homework1.clock;

public class Main {
    public static void main(String[] args) {

        Clock clock = new Clock();
        clock.setHours(23);
        clock.setMinutes(59);
        clock.setSeconds(59);

        clock.readTime(); // Текущее время: 23:59:59
        clock.tick();
        clock.readTime(); // Текущее время: 00:00:00
        clock.tick();
        clock.readTime(); // Текущее время: 00:00:01
    }
}
