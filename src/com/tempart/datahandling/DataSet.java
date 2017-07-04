package com.tempart.datahandling;

import java.util.LinkedList;
import java.util.Queue;

public class DataSet {
    private final String path;
    private final Queue<Double> temperatures = new LinkedList<>();
    private final Queue<DataPoint> dataPointsRaw = new LinkedList<>();
    private double highestTemp;
    private double lowestTemp;

    public DataSet(String path) {
        this.path = path;
    }

    String getPath() {
        return path;
    }


    public Queue<Double> getTemperatures() {
        return temperatures;
    }

    Queue<DataPoint> getDataPointsRaw() {
        return dataPointsRaw;
    }


    public double getHighestTemp() {
        return highestTemp;
    }

    void setHighestTemp(double highestTemp) {
        this.highestTemp = highestTemp;
    }

    public double getLowestTemp() {
        return lowestTemp;
    }

    void setLowestTemp(double lowestTemp) {
        this.lowestTemp = lowestTemp;
    }

}
