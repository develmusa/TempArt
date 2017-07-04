package com.tempart.datahandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class DataParser {

    private DataParser() {
    }

    public static void readFile(DataSet dataSet, String regex) throws FileNotFoundException, ParseException {
        System.out.println("\tReading Data Set:\t" + dataSet.getPath());
        Scanner scanner = new Scanner(new File(dataSet.getPath()));
        while (scanner.hasNext()) {
            String scannerIn = scanner.nextLine();
            double temperature = temperaturePatternMatcher(scannerIn, regex);
            LocalDateTime time = timePatternMatcher(scannerIn, regex);
            writeData(dataSet, temperature, time);
        }
        scanner.close();
        System.out.println("\tData Parsing Complete");
        System.out.println("\t\tNumber Of Data Points:\t" + dataSet.getTemperatures().size());
        System.out.println("\t\tHighest Temperature:\t" + dataSet.getHighestTemp() + "°C");
        System.out.println("\t\tLowest Temperature:\t\t" + dataSet.getLowestTemp() + "°C");
    }

    private static void writeData(DataSet dataSet, double temperature, LocalDateTime time) {
        if (time != null) {
            dataSet.getTemperatures().add(temperature);
            DataPoint datapoint = new DataPoint(time, temperature);
            dataSet.getDataPointsRaw().add(datapoint);
            if (temperature > dataSet.getHighestTemp()) {
                dataSet.setHighestTemp(temperature);
            } else if (temperature < dataSet.getLowestTemp()) {
                dataSet.setLowestTemp(temperature);
            }
        }
    }

    private static double temperaturePatternMatcher(String attributes, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(attributes);
        if (matcher.find()) {
            return Double.parseDouble(matcher.group(6));
        } else {
            return Double.MIN_VALUE;
        }
    }

    private static LocalDateTime timePatternMatcher(String attributes, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(attributes);
        LocalDateTime time;
        if (matcher.find()) {
            time = LocalDateTime.of(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)));
            return time;
        }
        return null;
    }
}
