package com.tempart;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class DataParser {
    //private static String regex = "([0-9]*)-([0-9]*)-([0-9]*)T([0-9]*):([0-9]*);(-?[0-9]*.[0-9]*)";

    private DataParser() {
    }

    public static void readFile(DataSet dataSet, String regex) throws FileNotFoundException, ParseException {
        Scanner scanner = new Scanner(new File(dataSet.getPath()));
        while(scanner.hasNext()){
            String scannerIn = scanner.nextLine();
            double temperature = temperaturePatternMatcher(scannerIn, regex);
            LocalDateTime time = timePatternMatcher(scannerIn, regex);
            if (time != null){
                dataSet.getTemperatures().add(temperature);
                DataPoint datapoint = new DataPoint(time, temperature);
                dataSet.getDataPointsRaw().add(datapoint);
                if (temperature > dataSet.getHighestTemp()) {
                    dataSet.setHighestTemp(temperature);
                }
                else if (temperature < dataSet.getLowestTemp()) {
                    dataSet.setLowestTemp(temperature);
                }
            }
        }
        scanner.close();
        System.out.println("Temperatures in Queue: " + dataSet.getTemperatures().size());
    }

    private static double temperaturePatternMatcher(String attributes, String regex) throws ParseException {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(attributes);
        if(matcher.find()){
            double temp = Double.parseDouble(matcher.group(6));
            return temp;
        } else {
            return Double.MIN_VALUE;
        }
    }

    public static LocalDateTime timePatternMatcher(String attributes, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(attributes);
        LocalDateTime time;
        if(matcher.find()){
            time = LocalDateTime.of(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
            return time;
        }
        return null;
    }
}