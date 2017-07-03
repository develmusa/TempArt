package com.tempart;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {



    public static void main(String[] args) {

        final ArrayList<TemperaturPicture> pictures = new ArrayList<>();

        pictures.add(new TemperaturPicture("outputPicture/Copenhagen_AFMHot.png", "./data/history_export_Copenhagen_19930101-19940101_20160921.csv", new AfmHot()));
        pictures.add(new TemperaturPicture("outputPicture/Brugg_AFMHot.png", "./data/history_export_Brugg_19900101-19910101-20160921.csv", new AfmHot()));
        pictures.add(new TemperaturPicture("outputPicture/Rapperswil_AFMHot.png", "./data/history_export_Rapperswil_20150101-20160101_20160921.csv", new AfmHot()));

        for (TemperaturPicture picture: pictures) {
            try {
                picture.drawImage();
            } catch(IOException | ParseException e){
                e.printStackTrace();
            }
        }


        /*

        TemperaturPicture temperaturPictureCopenhagenAFMHot = new TemperaturPicture(123, 123, "outputPicture/Copenhagen_AFMHot.png", "./data/history_export_Copenhagen_19930101-19940101_20160921.csv", new AfmHot());
        TemperaturPicture temperaturPictureBruggAFMHot = new TemperaturPicture(123, 123, "outputPicture/Brugg_AFMHot.png", "./data/history_export_Brugg_19900101-19910101-20160921.csv", new AfmHot());
        TemperaturPicture temperaturPictureRapperswilAFMHot = new TemperaturPicture(123, 123, "outputPicture/Rapperswil_AFMHot.png", "./data/history_export_Rapperswil_20150101-20160101_20160921.csv", new AfmHot());


        temperaturPictureBruggAFMHot.drawImage();
        temperaturPictureRapperswilAFMHot.drawImage();

        TemperaturPicture temperaturPictureCopenhagenHsv = new TemperaturPicture(123, 123, "outputPicture/Copenhagen_Hsv.png", "./data/history_export_Copenhagen_19930101-19940101_20160921.csv", new Hsv());
        TemperaturPicture temperaturPictureBruggHsv = new TemperaturPicture(123, 123, "outputPicture/Brugg_Hsv.png", "./data/history_export_Brugg_19900101-19910101-20160921.csv", new Hsv());
        TemperaturPicture temperaturPictureRapperswilHsv = new TemperaturPicture(123, 123, "outputPicture/Rapperswil_Hsv.png", "./data/history_export_Rapperswil_20150101-20160101_20160921.csv", new Hsv());
        temperaturPictureCopenhagenHsv.drawImage();
        temperaturPictureBruggHsv.drawImage();
        temperaturPictureRapperswilHsv.drawImage();

        TemperaturPicture temperaturPictureCopenhagenHot = new TemperaturPicture(123, 123, "outputPicture/Copenhagen_Hot.png", "./data/history_export_Copenhagen_19930101-19940101_20160921.csv", new Hot());
        TemperaturPicture temperaturPictureBruggHot = new TemperaturPicture(123, 123, "outputPicture/Brugg_Hot.png", "./data/history_export_Brugg_19900101-19910101-20160921.csv", new Hot());
        TemperaturPicture temperaturPictureRapperswilHot = new TemperaturPicture(123, 123, "outputPicture/Rapperswil_Hot.png", "./data/history_export_Rapperswil_20150101-20160101_20160921.csv", new Hot());
        temperaturPictureCopenhagenHot.drawImage();
        temperaturPictureBruggHot.drawImage();
        temperaturPictureRapperswilHot.drawImage();

        TemperaturPicture temperaturPictureCopenhagenRainbow = new TemperaturPicture(123, 123, "outputPicture/Copenhagen_Rainbow.png", "./data/history_export_Copenhagen_19930101-19940101_20160921.csv", new Rainbow());
        TemperaturPicture temperaturPictureBruggRainbow = new TemperaturPicture(123, 123, "outputPicture/Brugg_Rainbow.png", "./data/history_export_Brugg_19900101-19910101-20160921.csv", new Rainbow());
        TemperaturPicture temperaturPictureRapperswilRainbow = new TemperaturPicture(123, 123, "outputPicture/Rapperswil_Rainbow.png", "./data/history_export_Rapperswil_20150101-20160101_20160921.csv", new Rainbow());
        temperaturPictureCopenhagenRainbow.drawImage();
        temperaturPictureBruggRainbow.drawImage();
        temperaturPictureRapperswilRainbow.drawImage(); */
    }
}
