package com.tempart;

import com.tempart.coloring.ColorMap;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


class TempArt {
    public static void main(String[] args) {

        final HashMap<String, String> dataSets = new HashMap<>();
        final ArrayList<TemperatureImage> temperatureImages = new ArrayList<>();

        //Data Sets with temperature values
        dataSets.put("example_data", "./data/example_data.csv");

        //Regex for Parsing the Data
        String regex = "([0-9]*)-([0-9]*)-([0-9]*)T([0-9]*):([0-9]*);(-?[0-9]*.[0-9]*)";

        //Dimensions of input data (x,y)
        Rectangle inputDataDimensions = new Rectangle(288, 2);

        //Dimensions of the output picture (x,y)
        Rectangle outputPictureDimensions = new Rectangle(9504, 9490);

        for (Entry<String, String> data : dataSets.entrySet()) {
            temperatureImages.add(new TemperatureImage("outputPicture/" + data.getKey() + "_AfmHot.png", data.getValue(), ColorMap.AFMHOT, inputDataDimensions, outputPictureDimensions, regex));
            temperatureImages.add(new TemperatureImage("outputPicture/" + data.getKey() + "_HSV.png", data.getValue(), ColorMap.HSV, inputDataDimensions, outputPictureDimensions, regex));
            temperatureImages.add(new TemperatureImage("outputPicture/" + data.getKey() + "_Hot.png", data.getValue(), ColorMap.HOT, inputDataDimensions, outputPictureDimensions, regex));
            temperatureImages.add(new TemperatureImage("outputPicture/" + data.getKey() + "_Rainbow.png", data.getValue(), ColorMap.RAINBOW, inputDataDimensions, outputPictureDimensions, regex));
        }

        try {
            for (TemperatureImage temperatureImage : temperatureImages) {
                ImageGenerator.generateImage(temperatureImage);
            }
        } catch (IOException | ParseException | InputDimensionException e) {
            e.printStackTrace();
        } finally {
            System.out.println("\nPicture generation aborted.\n\n");
        }

    }
}
