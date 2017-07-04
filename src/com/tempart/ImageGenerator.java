package com.tempart;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public final class ImageGenerator {


    private ImageGenerator(){}


    public static void generateImage(TemperatureImage temperatureImage) throws IOException, ParseException {
        Queue<Double> temperatures = loadData(temperatureImage);
        BufferedImage img = drawImage(temperatureImage, temperatures);
        writeImage(temperatureImage, img);
    }

    private static Queue<Double> loadData(TemperatureImage temperatureImage) throws FileNotFoundException, ParseException {
        DataParser.readFile(temperatureImage.getDataSet(), temperatureImage.getRegex());
        Queue<Double> temperatures = scaleImage(temperatureImage, temperatureImage.getDataSet().getTemperatures());
        temperatureImage.getPictureColor().setTemperaturs((float) temperatureImage.getDataSet().getHighestTemp(), (float) temperatureImage.getDataSet().getLowestTemp());
        return temperatures;
    }

    private static BufferedImage drawImage(TemperatureImage temperatureImage, Queue<Double> temperatures) {
        BufferedImage img = new BufferedImage(temperatureImage.getOutputPictureDimensions().width, temperatureImage.getOutputPictureDimensions().height, BufferedImage.TYPE_INT_ARGB );
        for(int y = 0; y < temperatureImage.getOutputPictureDimensions().height; y++) {
            if(y % (temperatureImage.getOutputPictureDimensions().height/ temperatureImage.getInputDataDimensions().height) == 0){
                for (int x = 0; x < temperatureImage.getOutputPictureDimensions().width; x++) {
                    img.setRGB(x, y, temperatureImage.getPictureColor().getColor((float) temperatures.poll().doubleValue()).getRGB());
                }
            } else {
                for (int x = 0; x < temperatureImage.getOutputPictureDimensions().width; x++) {
                    img.setRGB(x, y, img.getRGB(x, y - 1));
                }
            }
        }
        return img;
    }

    private static void writeImage(TemperatureImage temperatureImage, BufferedImage img) throws IOException {
        File outputFile = new File(temperatureImage.getOutputPath());
        ImageIO.write(img, "PNG", outputFile);
        System.out.println("Write file: " + temperatureImage.getOutputPath());
    }

    public static Queue<Double> scaleImage(TemperatureImage temperatureImage, Queue<Double> temperatures){
        Queue<Double> temperaturesScaled = new LinkedList<>();
        double previousTemperature;
        while (!temperatures.isEmpty()){
            previousTemperature = temperatures.poll();
            if (temperatures.isEmpty()){
                temperaturesScaled.add(previousTemperature);
            } else {
                double x1 = 0;
                double y1 = previousTemperature;
                double x2 = 32;
                double y2 = temperatures.peek();
                double slope = (y2 - y1) / (x2 - x1);
                temperaturesScaled.add(previousTemperature);
                for (int x = 1; x < (temperatureImage.getOutputPictureDimensions().width / temperatureImage.getInputDataDimensions().width); x++){
                    temperaturesScaled.add(slope * x + y1);
                }
            }
        }
        return temperaturesScaled;
    }
}