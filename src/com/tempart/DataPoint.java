package com.tempart;

import java.time.LocalDateTime;

/**
 * Created by sikcd on 26.09.2016.
 */
public class DataPoint {
    private LocalDateTime time;
    private double temp;

    public DataPoint(LocalDateTime time, double temp) {
        this.time = time;
        this.temp = temp;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public double getTemp() {
        return temp;
    }
}
