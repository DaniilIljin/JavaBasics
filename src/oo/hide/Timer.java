package oo.hide;

public class Timer {
    long currentTime = System.currentTimeMillis();

    public String getPassedTime() {
        double timePassed = System.currentTimeMillis() - currentTime;
        return String.format("%s seconds", timePassed / 1000);
    }
}
