package com.tempart;

import java.awt.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;


public class Main {



    public static void main(String[] args) {

        final HashMap<String, String> dataSets  = new HashMap<>();

        dataSets.put("Copenhagen_1993", "./data/history_export_Copenhagen_19930101-19940101_20160921.csv");
        dataSets.put("Brugg_1990", "./data/history_export_Brugg_19900101-19910101-20160921.csv");
        dataSets.put("Rapperswil_2015", "./data/history_export_Rapperswil_20150101-20160101_20160921.csv");

        final ArrayList<TemperaturePicture> pictures = new ArrayList<>();

        //Dimensions of input data (x,y)
        Rectangle inputData = new Rectangle(288,365);
        //Dimensions of the output picture (x,y)
        Rectangle outputPicture = new Rectangle(9504,9490);

        for (Entry<String, String> data : dataSets.entrySet()) {
            pictures.add(new TemperaturePicture("outputPicture/"+ data.getKey() +"_AfmHot.png", data.getValue(), ColorMap.AFMHOT, inputData, outputPicture));
            pictures.add(new TemperaturePicture("outputPicture/"+ data.getKey() +"_HSV.png", data.getValue(), ColorMap.HSV, inputData, outputPicture));
            pictures.add(new TemperaturePicture("outputPicture/"+ data.getKey() +"_Hot.png", data.getValue(), ColorMap.HOT, inputData, outputPicture));
            pictures.add(new TemperaturePicture("outputPicture/"+ data.getKey() +"_Rainbow.png", data.getValue(), ColorMap.RAINBOW, inputData, outputPicture));
        }

        for (TemperaturePicture picture: pictures) {
            try {
                picture.generateImage();
            } catch(IOException | ParseException e){
                e.printStackTrace();
            }
        }
    }
}
