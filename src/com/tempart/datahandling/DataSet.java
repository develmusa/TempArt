package com.tempart.datahandling;

import java.util.LinkedList;
import java.util.Queue;

public class DataSet {
    private String path;
    private Queue<Double> temperatures = new LinkedList<>();
    private Queue<DataPoint> dataPointsRaw = new LinkedList<>();
    private double highestTemp;
    private double lowestTemp;

    public DataSet (String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }


    public Queue<Double> getTemperatures() {
        return temperatures;
    }

    public Queue<DataPoint> getDataPointsRaw() {
        return dataPointsRaw;
    }


    public double getHighestTemp() {
        return highestTemp;
    }

    public void setHighestTemp(double highestTemp) {
        this.highestTemp = highestTemp;
    }

    public double getLowestTemp() {
        return lowestTemp;
    }

    public void setLowestTemp(double lowestTemp) {
        this.lowestTemp = lowestTemp;
    }

}
