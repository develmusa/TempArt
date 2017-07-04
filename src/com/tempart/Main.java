package com.tempart;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {



    public static void main(String[] args) {

        final HashMap<String, String> dataSets  = new HashMap<>();

        dataSets.put("Copenhagen_1993", "./data/history_export_Copenhagen_19930101-19940101_20160921.csv");
        dataSets.put("Brugg_1990", "./data/history_export_Brugg_19900101-19910101-20160921.csv");
        dataSets.put("Rapperswil_2015", "./data/history_export_Rapperswil_20150101-20160101_20160921.csv");

        final ArrayList<TemperaturePicture> pictures = new ArrayList<>();

        for (Map.Entry<String, String> data : dataSets.entrySet()) {
            pictures.add(new TemperaturePicture("outputPicture/"+ data.getKey() +"_AfmHot.png", data.getValue(), ColorMap.AFMHOT, 288, 365, 9504, 9490));
            pictures.add(new TemperaturePicture("outputPicture/"+ data.getKey() +"_HSV.png", data.getValue(), ColorMap.HSV, 288, 365, 9504, 9490));
            pictures.add(new TemperaturePicture("outputPicture/"+ data.getKey() +"_Hot.png", data.getValue(), ColorMap.HOT, 288, 365, 9504, 9490));
            pictures.add(new TemperaturePicture("outputPicture/"+ data.getKey() +"_Rainbow.png", data.getValue(), ColorMap.RAINBOW, 288, 365, 9504, 9490));
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
