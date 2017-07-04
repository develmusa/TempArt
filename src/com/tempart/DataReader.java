package com.tempart;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by sikcd on 21.09.2016.
 */
public class DataReader {
    private String path;
    private String regex = "([0-9]*)-([0-9]*)-([0-9]*)T([0-9]*):([0-9]*);(-?[0-9]*.[0-9]*)";
    private Queue<Double> temeratures;
    private Queue<DataPoint> dataPointsRaw;
    private Queue<DataPoint> dataPointsCompleted;
    private double highestTemp;
    private double lowestTemp;



    public void readFile() throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File(path));
        temeratures = new LinkedList<>();
        dataPointsRaw = new LinkedList<>();
        while(scanner.hasNext()){
            String scannerIn = scanner.nextLine();
            double temperature = temperaturPatternMatcher(scannerIn);
            LocalDateTime time = timePatternMatcher(scannerIn);
            if (time != null){
                temeratures.add(temperature);
                DataPoint datapoint = new DataPoint(time, temperature);
                dataPointsRaw.add(datapoint);
                if (temperature > highestTemp) {
                    highestTemp = temperature;
                }
                else if (temperature < lowestTemp) {
                    lowestTemp = temperature;
                }
            }
        }
        scanner.close();
        System.out.println("Temperatures in Queue: " + temeratures.size());
    }
    private double temperaturPatternMatcher(String attributes) throws ParseException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(attributes);
        if(matcher.find()){
            double temp = Double.parseDouble(matcher.group(6));
            return temp;
        } else {
            return Double.MIN_VALUE;
        }
    }

    public LocalDateTime timePatternMatcher(String attributes) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(attributes);
        LocalDateTime time;
        if(matcher.find()){
            time = LocalDateTime.of(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
            return time;
        }
        return null;
    }

    public DataReader(String path) {
        this.path = path;
    }

    public double getLowestTemp() {
        return lowestTemp;
    }

    public double getHighestTemp() {
        return highestTemp;
    }

    public Queue<Double> getTemeratures() {
        return temeratures;
    }
}
