package com.tempart;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Main {



    public static void main(String[] args) {

        final HashMap<String, String> dataSets  = new HashMap<>();
        final ArrayList<TemperatureImage> temperatureImages = new ArrayList<>();

        dataSets.put("Copenhagen_1993", "./data/history_export_Copenhagen_19930101-19940101_20160921.csv");
        dataSets.put("Brugg_1990", "./data/history_export_Brugg_19900101-19910101-20160921.csv");
        dataSets.put("Rapperswil_2015", "./data/history_export_Rapperswil_20150101-20160101_20160921.csv");

        //Dimensions of input data (x,y)
        Rectangle inputDataDimensions = new Rectangle(288,365);
        //Dimensions of the output picture (x,y)
        Rectangle outputPictureDimensions = new Rectangle(9504,9490);


        for (Entry<String, String> data : dataSets.entrySet()) {
            temperatureImages.add(new TemperatureImage("outputPicture/"+ data.getKey() +"_AfmHot.png", data.getValue(), ColorMap.AFMHOT, inputDataDimensions, outputPictureDimensions));
            temperatureImages.add(new TemperatureImage("outputPicture/"+ data.getKey() +"_HSV.png", data.getValue(), ColorMap.HSV, inputDataDimensions, outputPictureDimensions));
            temperatureImages.add(new TemperatureImage("outputPicture/"+ data.getKey() +"_Hot.png", data.getValue(), ColorMap.HOT, inputDataDimensions, outputPictureDimensions));
            temperatureImages.add(new TemperatureImage("outputPicture/"+ data.getKey() +"_Rainbow.png", data.getValue(), ColorMap.RAINBOW, inputDataDimensions, outputPictureDimensions));
        }

        for (TemperatureImage temperatureImage : temperatureImages) {
            try {
                ImageGenerator.generateImage(temperatureImage);
            } catch(IOException | ParseException e){
                e.printStackTrace();
            }
        }
    }
}
