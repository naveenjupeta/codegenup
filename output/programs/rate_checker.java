import java.time.LocalTime;
import java.time.Duration;
import java.util.Queue;
import java.util.LinkedList;

public class RateChecker {
    private int actions;
    private int seconds;
    private Queue<LocalTime> times;

    public RateChecker(int actions, int seconds) {
        this.actions = actions;
        this.seconds = seconds;
        this.times = new LinkedList<LocalTime>();
    }

    public boolean check() {
        LocalTime current_time = LocalTime.now();
        times.add(current_time);

        if (times.size() > actions) {
            return false;
        }

        LocalTime first_time = times.peek();
        if (Duration.between(first_time, current_time).getSeconds() <= seconds) {
            return true;
        } else {
            times.remove();
            return false;
        }
    }