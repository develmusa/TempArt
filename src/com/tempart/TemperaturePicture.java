package com.tempart;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.*;

public class TemperaturePicture {
    private final String inputPath;
    private final String outputPath;
    private final Rectangle inputData;
    private final Rectangle outputPicture;
    private final ColorGradient pictureColor;


    public TemperaturePicture(String outputPath, String inputPath, ColorMap color, Rectangle inputData, Rectangle outputPicture) {
        this.outputPath = outputPath;
        this.inputPath = inputPath;
        this.pictureColor = new ColorGradientFactory().getColorGradient(color);
        this.inputData = inputData;
        this.outputPicture = outputPicture;
    }


    public void generateImage() throws IOException, ParseException {
        Queue<Double> temperatures = loadData();
        BufferedImage img = drawImage(temperatures);
        writeImage(img);
    }

    private Queue<Double> loadData() throws FileNotFoundException, ParseException {
        DataReader dataReader = new DataReader(inputPath);
        dataReader.readFile();
        Queue<Double> temperatures = scaleImage(dataReader.getTemeratures());
        pictureColor.setTemperaturs((float)dataReader.getHighestTemp(), (float)dataReader.getLowestTemp());
        return temperatures;
    }

    private BufferedImage drawImage(Queue<Double> temperatures) {
        BufferedImage img = new BufferedImage(outputPicture.width, outputPicture.height, BufferedImage.TYPE_INT_ARGB );
        for(int y = 0; y < outputPicture.height; y++) {
            if(y % (outputPicture.height/inputData.height) == 0){
                for (int x = 0; x < outputPicture.width; x++) {
                    img.setRGB(x, y, pictureColor.getColor((float) temperatures.poll().doubleValue()).getRGB());
                }
            } else {
                for (int x = 0; x < outputPicture.width; x++) {
                    img.setRGB(x, y, img.getRGB(x, y - 1));
                }
            }
        }
        return img;
    }

    private void writeImage(BufferedImage img) throws IOException {
        File outputFile = new File(outputPath);
        ImageIO.write(img, "PNG", outputFile);
        System.out.println("Write file: " + outputPath);
    }

    public Queue<Double> scaleImage(Queue<Double> temperatures){
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
                for (int x = 1; x < (outputPicture.width / inputData.width); x++){
                    temperaturesScaled.add(slope * x + y1);
                }
            }
        }
        return temperaturesScaled;
    }
}