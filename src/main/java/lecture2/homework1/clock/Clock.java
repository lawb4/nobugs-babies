package lecture2.homework1.clock;

public class Clock implements Readable {

    private int hours;
    private int minutes;
    private int seconds;

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public void tick() {
        seconds++;
        calculateTickLogic();
    }

    public void calculateTickLogic() {
        if (seconds == 60) {
            seconds = 0;
            minutes++;
        }

        if (minutes == 60) {
            minutes = 0;
            hours++;
        }

        if (hours == 24) {
            hours = 0;
        }
    }

    @Override
    public void readTime() {
        System.out.printf("Текущее время: %02d:%02d:%02d\n", getHours(), getMinutes(), getSeconds());
    }
}
