package com.tempart.datahandling;

import java.time.LocalDateTime;

class DataPoint {
    private final LocalDateTime time;
    private final double temp;

    public DataPoint(LocalDateTime time, double temp) {
        this.time = time;
        this.temp = temp;
    }
}
